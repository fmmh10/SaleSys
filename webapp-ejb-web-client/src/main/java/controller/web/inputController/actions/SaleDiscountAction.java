package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;

import presentation.web.model.SaleDiscountModel;

@Stateless
public class SaleDiscountAction extends Action {
	
	@EJB 
	private ISaleServiceRemote SaleDiscountHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		SaleDiscountModel model = createHelper(request);
		request.setAttribute("model", model);
		
		try {
				
			double discount = SaleDiscountHandler.getSaleDiscount(model.getSaleId());
			model.addMessage("Discount:" + discount);
			
		} catch (ApplicationException e) {
			model.addMessage("Error searching for discount sale: " + e.getMessage());
		}
		
		
		
		
		request.getRequestDispatcher("/saleDiscount/saleDiscount.jsp").forward(request, response);
	}
	
	
	
	private SaleDiscountModel createHelper(HttpServletRequest request) {
		SaleDiscountModel model = new  SaleDiscountModel();
		// fill it with data from the request
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
		return model;
	}	

}
