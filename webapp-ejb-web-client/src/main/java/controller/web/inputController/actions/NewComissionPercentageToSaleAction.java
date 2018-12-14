package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddComissionPercentageToSaleModel;


/**
 * Handles the novo cliente event
 * 
 * @author fmartins
 *
 */
@Stateless
public class NewComissionPercentageToSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote addComissionPercentageToSaleHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AddComissionPercentageToSaleModel model = new AddComissionPercentageToSaleModel();
		request.setAttribute("model", model);
		request.getRequestDispatcher("/addComissionPercentageToSale/addComissionPercentageToSale.jsp").forward(request, response);
	}

}
