package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.IEmployeeServiceRemote;
import presentation.web.model.CancelAllComissionsModel;

@Stateless
public class CancelAllComissionsAction extends Action {
	
	@EJB 
	private IEmployeeServiceRemote cancelAllComissionsHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ApplicationException {
		
		CancelAllComissionsModel model = new CancelAllComissionsModel();
		request.setAttribute("model", model);
		
		try {
			cancelAllComissionsHandler.cancelAllComissions();
			model.addMessage("All employee comissions were cancelled successfully");
		} catch (ApplicationException e) {
			model.addMessage("Error cancelling comissions: " + e.getMessage());
		}
		
		request.getRequestDispatcher("/cancelAllComissions/cancelAllComissions.jsp").forward(request, response);
	}

}
