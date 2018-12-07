package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.CloseSaleModel;

@Stateless
public class CloseSaleAction extends Action{
	
	@EJB 
	private ISaleServiceRemote CloseSaleHandler;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ApplicationException {

		
		CloseSaleModel model = new CloseSaleModel();
		request.setAttribute("model", model);
		
		try {
		
		model.setSaleId(Integer.parseInt(request.getParameter("saleId")));
		
		CloseSaleHandler.close(model.getSaleId());
		
		} catch (ApplicationException e) {
			model.addMessage("Error closing sale: " + e.getMessage());
		}
		
		catch (NumberFormatException e) {
			model.addMessage("Error numberformat, mas dá para fechar a venda na BD na mesma...");
		}
		
		request.getRequestDispatcher("/closeSale/closeSale.jsp").forward(request, response);
	}	
}
