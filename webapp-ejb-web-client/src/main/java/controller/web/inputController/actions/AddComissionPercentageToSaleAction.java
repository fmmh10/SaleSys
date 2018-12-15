package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddComissionPercentageToSaleModel;

@Stateless
public class AddComissionPercentageToSaleAction extends Action{

	@EJB 
	private ISaleServiceRemote addComissionPercentageToSaleHandler;
	
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ApplicationException {
		
		AddComissionPercentageToSaleModel model = createHelper(request);
		request.setAttribute("model", model);
		
		if (validInput(model)) {
			try {
				addComissionPercentageToSaleHandler.addComissionPercentageToSale(model.getSaleId(), model.getComission_percentage());
				model.addMessage("Comission Percentage successfully added.");
			} catch (ApplicationException e) {
				model.addMessage("Error adding Comission Percentage: " + e.getMessage());
			}
		} else
			model.addMessage("Error validating customer data");
			
			
		request.getRequestDispatcher("/addComissionPercentageToSale/addComissionPercentageToSale.jsp").forward(request, response);
	}
	
	
	private boolean validInput(AddComissionPercentageToSaleModel model) {
		
		// check if designation is filled
		boolean result = isFilled(model,Integer.toString(model.getSaleId()), "Sale id must be filled.");
		
		result &= isFilled(model, Integer.toString(model.getComission_percentage()), "Percentage type must be filled");
		return result;
	}

	
	
	
	private AddComissionPercentageToSaleModel createHelper(HttpServletRequest request) {
		// Create the object model
		AddComissionPercentageToSaleModel model = new AddComissionPercentageToSaleModel();
		// fill it with data from the request
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
		model.setComission_percentage(Integer.parseInt(request.getParameter("comission_percentage")));
		return model;
	}	

}
