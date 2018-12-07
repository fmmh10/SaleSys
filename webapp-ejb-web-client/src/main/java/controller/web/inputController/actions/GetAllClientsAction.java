package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ICustomerServiceRemote;

import presentation.web.model.AllCustomersModel;

@Stateless
public class GetAllClientsAction extends Action {
	
	@EJB 
	private ICustomerServiceRemote addCustomerHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AllCustomersModel model = createHelper(request);
		request.setAttribute("model", model);		
		request.getRequestDispatcher("/getAllCustomers/showAllCustomers.jsp").forward(request, response);
	}

	private AllCustomersModel createHelper(HttpServletRequest request) {
		// Create the object model
		AllCustomersModel model = new AllCustomersModel();
		model.setAddCustomerHandler(addCustomerHandler);
		return model;
	}	
}
