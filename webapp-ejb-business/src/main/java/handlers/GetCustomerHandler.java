package handlers;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Customer;
import catalogs.CustomerCatalog;

import facade.dto.CustomerDTO;
import facade.exceptions.ApplicationException;

/**
 * Handles the two different get customer use cases. 
 * 
 * @author fmartins
 * @author alopes
 * @version 1.2 (23/05/2018)
 *
 */
@Stateless
public class GetCustomerHandler {
	
	/**
	 * The customer's catalog
	 */
	@EJB
	private CustomerCatalog customerCatalog;
	
	public CustomerDTO getCustomer(int id) throws ApplicationException {
		
		try {
			Customer customer = customerCatalog.getCustomerById(id);
			return new CustomerDTO(customer.getVATNumber(), customer.getPhoneNumber(), customer.getDesignation(), customer.getId());
		} catch (Exception e) {
			throw new ApplicationException ("Error getting customer with id " + id, e);
		}
	}

	public List<CustomerDTO> getCustomers() throws ApplicationException {
		
		try {
			List<CustomerDTO> allCustomers = new LinkedList<>();
			for (Customer c : customerCatalog.getCustomers())
				allCustomers.add(new CustomerDTO(c.getVATNumber(), c.getPhoneNumber(), c.getDesignation(), c.getId()));
			return allCustomers;			
		} catch (Exception e) {
			throw new ApplicationException ("Error getting all customers", e);
		}  
	}

}
