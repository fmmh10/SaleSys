package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import catalogs.SaleCatalog;

import facade.exceptions.ApplicationException;

@Stateless
public class AddComissionPercentageToSaleHandler {
	/**
	 * The sale catalog
	 */
	@EJB
	private SaleCatalog saleCatalog;

	
	public void addComissionPercentageToSale(int saleId, int percentage) throws ApplicationException {
		try {
			saleCatalog.addComissionPercentageToSale(saleId, percentage);
			
			
		} catch (Exception e) {
			throw new ApplicationException ("Error adding Comission percentage to sale with id " + saleId, e);
		}

	}
	
} 