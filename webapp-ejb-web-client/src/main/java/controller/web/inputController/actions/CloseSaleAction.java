package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.CloseSaleModel;

@Stateless
public class CloseSaleAction extends Action{
	
	@EJB 
	private ISaleServiceRemote CloseSaleHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ApplicationException {

		CloseSaleModel model = createHelper(request);
		request.setAttribute("model", model);
				
		try {
			
			CloseSaleHandler.close(model.getSaleId());
			model.addMessage("Sale closed successfully!");
		
		} catch (ApplicationException e) {
			model.addMessage("Error closing sale: " + e.getMessage());
		}
		
		request.getRequestDispatcher("/closeSale/closeSale.jsp").forward(request, response);
	}	
	
	
	private CloseSaleModel createHelper(HttpServletRequest request) {
		// Create the object model
		CloseSaleModel model = new CloseSaleModel();
		// fill it with data from the request
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
		return model;
	}	
}
