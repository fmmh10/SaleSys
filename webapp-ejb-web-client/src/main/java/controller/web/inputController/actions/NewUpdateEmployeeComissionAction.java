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
public class NewUpdateEmployeeComissionAction extends Action {
	
	@EJB 
	private IEmployeeServiceRemote updateEmployeeComissionHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ApplicationException {
		
		UpdateEmployeeComissionModel model = new UpdateEmployeeComissionModel();
		request.setAttribute("model", model);
		request.getRequestDispatcher("/updateEmployeeComission/updateEmployeeComission.jsp").forward(request, response);
	}
	

}
