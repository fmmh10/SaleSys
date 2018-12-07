package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.dto.SaleDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.NewSaleModel;

@Stateless
public class CreateSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote addSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		NewSaleModel model = new NewSaleModel();
		model.setCustomerVat(request.getParameter("npc"));
		// the other data, date and status will be created by the handler

		if (validInput(model)) {
			try {
				
				SaleDTO sale = addSaleHandler.newSale(intValue(model.getCustomerVat()));
				
				populateHelper(model, request, sale);
				
				request.setAttribute("model", model);
				//model.clearFields();
				model.addMessage("Sale successfully added.");
			} catch (ApplicationException e) {
				model.addMessage("Error adding sale: " + e.getMessage());
			}
		} else
			model.addMessage("Error validating sale data");
		
		request.getRequestDispatcher("/newSale/showNewSale.jsp").forward(request, response);

		
	}
	
	private boolean validInput(NewSaleModel model) {
		
		// check if designation is filled
		boolean result =  isFilled(model, model.getCustomerVat(), "VAT number must be filled")
				       && isInt(model, model.getCustomerVat(), "VAT number with invalid characters");
		return result;
	}
	
	
	private void populateHelper(NewSaleModel model, HttpServletRequest request, SaleDTO sale) {

		// fill it with data from the request
		model.setCustomerVat(request.getParameter("customerVat"));
		model.setDate(sale.getSaleDate().toString());
		model.setOpen(sale.isOpen()?"aberta":"fechada");
	}	

}
