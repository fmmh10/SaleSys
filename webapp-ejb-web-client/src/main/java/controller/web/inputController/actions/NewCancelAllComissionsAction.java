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
public class NewCancelAllComissionsAction extends Action {

	@EJB 
	private IEmployeeServiceRemote cancelAllComissionsHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ApplicationException {
		
		CancelAllComissionsModel model = new CancelAllComissionsModel();
		request.setAttribute("model", model);	
		request.getRequestDispatcher("/cancelAllComissions/cancelAllComissions.jsp").forward(request, response);
	}
}
