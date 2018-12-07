package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;

import presentation.web.model.SaleDiscountModel;

@Stateless
public class SaleDiscountAction extends Action {
	
	@EJB 
	private ISaleServiceRemote SaleDiscountHandler;

	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		SaleDiscountModel model = new SaleDiscountModel();
		request.setAttribute("model", model);
		
		if (validInput(model)) {
			try {
				
				double discount = SaleDiscountHandler.getSaleDiscount(model.getSaleId());
				
				populateHelper(model, request, discount);
				
				request.setAttribute("model", model);
				//model.clearFields();
			} catch (ApplicationException e) {
				model.addMessage("Error searching for discount sale: " + e.getMessage());
			}
		} else
			model.addMessage("Error validating sale data");
		
		
		
		
		request.getRequestDispatcher("/saleDiscount/showDiscount.jsp").forward(request, response);
	}
	
	
	private boolean validInput(SaleDiscountModel model) {
		
		// check if designation is filled
		//não esta completo
		return true;
	}
	
	
	private void populateHelper(SaleDiscountModel model, HttpServletRequest request, double discount) {

		// fill it with data from the request
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
	}	

}
