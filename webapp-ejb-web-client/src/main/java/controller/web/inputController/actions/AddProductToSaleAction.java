package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddProductToSaleModel;

@Stateless
public class AddProductToSaleAction extends Action {
	
	@EJB 
	private ISaleServiceRemote addProductToSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AddProductToSaleModel model = createHelper(request);
		request.setAttribute("model", model);
		System.out.println("erro");
		
		try {
			addProductToSaleHandler.addProductToSale(model.getSaleId(), model.getProductCode(), model.getQty());
			System.out.println("erro2");
			model.clearFields();
			model.addMessage("Product successfully added.");
		} catch (ApplicationException e) {
			model.addMessage("Error adding product: " + e.getMessage());
		}
		
		
		
		request.getRequestDispatcher("/addProductToSale/addProductToSale.jsp").forward(request, response);
	}



	private AddProductToSaleModel createHelper(HttpServletRequest request) {
		// Create the object model
		AddProductToSaleModel model = new AddProductToSaleModel();
		// fill it with data from the request
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
		model.setProductCode(Integer.parseInt(request.getParameter("prodCode")));
		model.setQty(Integer.parseInt(request.getParameter("qty")));
		return model;
	}	
}
