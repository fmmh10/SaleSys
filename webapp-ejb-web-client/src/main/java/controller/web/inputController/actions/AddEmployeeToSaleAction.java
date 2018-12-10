package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddEmployeeToSaleModel;

@Stateless
public class AddEmployeeToSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote addEmployeeToSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AddEmployeeToSaleModel model = createHelper(request);
		request.setAttribute("model", model);
		
		try {
			addEmployeeToSaleHandler.addEmployeeToSale(model.getSaleId(), model.getVatNumber());
			model.addMessage("Employee successfully added.");
		} catch (ApplicationException e) {
			model.addMessage("Error adding Employee: " + e.getMessage());
		}
		
		
		
		request.getRequestDispatcher("/addEmployeeToSale/addEmployeeToSale.jsp").forward(request, response);
	}



	private AddEmployeeToSaleModel createHelper(HttpServletRequest request) {
		// Create the object model
		AddEmployeeToSaleModel model = new AddEmployeeToSaleModel();
		// fill it with data from the request
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
		model.setVatNumber(Integer.parseInt(request.getParameter("vatNumber")));
		return model;
	}	
}
