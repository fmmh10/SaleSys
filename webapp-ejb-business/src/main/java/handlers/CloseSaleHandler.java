package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import catalogs.SaleCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class CloseSaleHandler {

	@EJB
	private SaleCatalog saleCatalog;
	
	public void close (int saleId) throws ApplicationException {
		saleCatalog.close(saleId);
			
		
	}
	
}
