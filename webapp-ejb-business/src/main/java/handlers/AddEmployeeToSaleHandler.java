package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import catalogs.EmployeeCatalog;
import catalogs.SaleCatalog;

import facade.exceptions.ApplicationException;

@Stateless
public class AddEmployeeToSaleHandler {
	/**
	 * The sale catalog
	 */
	@EJB
	private SaleCatalog saleCatalog;
	
	@EJB
	private EmployeeCatalog EmployeeCatalog;

	public void addEmployeeToSale(int saleId, int vatNumber) throws ApplicationException {
		try {
			saleCatalog.addEmployeeToSale(saleId, vatNumber);	
			
			
		} catch (Exception e) {
			throw new ApplicationException ("Error adding Employee to sale with id " + saleId, e);
		}

	}
	
} 