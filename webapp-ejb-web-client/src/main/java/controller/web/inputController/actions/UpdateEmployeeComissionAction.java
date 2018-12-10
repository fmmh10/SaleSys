package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.IEmployeeServiceRemote;
import presentation.web.model.UpdateEmployeeComissionModel;


@Stateless
public class UpdateEmployeeComissionAction extends Action {
	
	@EJB 
	private IEmployeeServiceRemote updateEmployeeComissionHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		UpdateEmployeeComissionModel model = createHelper(request);
		request.setAttribute("model", model);
		
		try {
			updateEmployeeComissionHandler.updateEmployeeComission(model.getVatNumber(), model.getComission());
			model.addMessage("Comission updated successfully.");
		} catch (ApplicationException e) {
			model.addMessage("Error updating comission: " + e.getMessage());
		}
		
		
		
		request.getRequestDispatcher("/updateEmployeeComission/updateEmployeeComission.jsp").forward(request, response);
	}



	private UpdateEmployeeComissionModel createHelper(HttpServletRequest request) {
		// Create the object model
		UpdateEmployeeComissionModel model = new UpdateEmployeeComissionModel();
		// fill it with data from the request
		model.setVatNumber(Integer.parseInt(request.getParameter("vatNumber")));
		model.setComission(Integer.parseInt(request.getParameter("comission")));
		return model;
	}	
}
