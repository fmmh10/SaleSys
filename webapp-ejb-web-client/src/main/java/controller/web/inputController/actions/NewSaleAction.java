package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.NewSaleModel;


/**
 * Handles the novo cliente event
 * 
 * @author fmartins
 *
 */
@Stateless
public class NewSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote newSaleHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		NewSaleModel model = new NewSaleModel();
		request.setAttribute("model", model);
		request.getRequestDispatcher("/newSale/newSale.jsp").forward(request, response);
	}

}
