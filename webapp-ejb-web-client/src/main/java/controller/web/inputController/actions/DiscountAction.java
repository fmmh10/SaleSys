package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.SaleDiscountModel;

@Stateless
public class DiscountAction extends Action {
		
		@EJB 
		private ISaleServiceRemote SaleDiscountHandler;

		@Override
		public void process(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {

			SaleDiscountModel model = new SaleDiscountModel();
			request.setAttribute("model", model);
			request.getRequestDispatcher("/saleDiscount/saleDiscount.jsp").forward(request, response);
		}

}



