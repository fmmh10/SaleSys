package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import catalogs.CustomerCatalog;
import facade.exceptions.ApplicationException;

/**
 * Handles the remove customer use case. This represents a very 
 * simplified use case with just one operation: addCustomer.
 * 
 * @author fmartins
 * @author alopes
 * @version 1.2 (23/05/2018)
 *
 */
@Stateless
public class RemoveCustomerHandler {
	
	/**
	 * The customer's catalog
	 */
	@EJB
	private CustomerCatalog customerCatalog;
	
	/**
	 * Removes a customer with a given id
	 * 
	 * @param vat The vat of the customer
	 * @return The data concerning the customer with the given id
	 * @throws ApplicationException When the VAT number is invalid 
	 * or there is no customer with that vat registered in the system.
	 */
	public void deleteCustomer(int id) throws ApplicationException {
		customerCatalog.deleteCustomer(id);
	}

}
