package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddProductToSaleModel;


/**
 * Handles the novo cliente event
 * 
 * @author fmartins
 *
 */
@Stateless
public class NewProductToSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote addProductToSaleHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AddProductToSaleModel model = new AddProductToSaleModel();
		request.setAttribute("model", model);
		request.getRequestDispatcher("/addProductToSale/addProductToSale.jsp").forward(request, response);
	}

}
