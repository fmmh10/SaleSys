package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddEmployeeToSaleModel;


/**
 * Handles the novo cliente event
 * 
 * @author fmartins
 *
 */
@Stateless
public class NewEmployeeToSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote addEmployeeToSaleHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AddEmployeeToSaleModel model = new AddEmployeeToSaleModel();
		request.setAttribute("model", model);
		request.getRequestDispatcher("/addEmployeeToSale/addEmployeeToSale.jsp").forward(request, response);
	}

}
