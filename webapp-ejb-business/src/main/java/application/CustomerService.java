package application;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import facade.dto.CustomerDTO;
import facade.dto.DiscountDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ICustomerServiceRemote;
import facade.interfaces.IDiscount;

import handlers.*;

/**
 * A service the offers the addition of customer. The purpose of this class is to provide access 
 * to the business layer, hiding its implementation from the clients. Clients should never interact 
 * directly with the business layer. 
 * 
 * @author fmartins
 * @version 1.1 (16/2/2017)
 */
@Stateless 
public class CustomerService implements ICustomerServiceRemote {

	/**
	 * The business object façades that handle this use case request
	 */
	@EJB
	private AddCustomerHandler addCustomerHandler;
	
	@EJB
	private GetCustomerHandler getCustomerHandler;
	
	@EJB
	private RemoveCustomerHandler removeCustomerHandler;
	
	/**
	 * Adds a customer given its VAT number, denomination, phone number,
	 * and discount type.
	 * 
	 * @param vat The VAT number of the customer to add to the system
	 * @param denomination The customer's denomination 
	 * @param phoneNumber The customer's phone number
	 * @param discountCode The customer's discount code
	 * @throws ApplicationException In case the customer could not be added.
	 */
	public CustomerDTO addCustomer(int vat, String denomination, int phoneNumber, 
			int discountType) throws ApplicationException {
		return addCustomerHandler.addCustomer(vat, denomination, phoneNumber, discountType);
	}
	
	
	/**
	 * Adds a customer given its VAT number, denomination, phone number,
	 * and discount type.
	 * 
	 * @param vat The VAT number of the customer to add to the system
	 * @param denomination The customer's denomination 
	 * @param phoneNumber The customer's phone number
	 * @param discountCode The customer's discount code
	 * @throws ApplicationException In case the customer could not be added.
	 */
	public Collection<DiscountDTO> getDiscounts() throws ApplicationException {
		List<DiscountDTO> result = new LinkedList<>(); 
		for (IDiscount discount : addCustomerHandler.getDiscounts())
			result.add(new DiscountDTO(discount.getId(), discount.getDescription()));
		return result;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	public CustomerDTO getCustomer(int id) throws ApplicationException {
		return getCustomerHandler.getCustomer(id);
	}

	
	/**
	 * 
	 */
	public Iterable<CustomerDTO> getCustomers() throws ApplicationException {
		return getCustomerHandler.getCustomers();
	}

	/**
	 * 
	 */
	public void deleteCustomer(int id) throws ApplicationException {
		removeCustomerHandler.deleteCustomer(id);
	}
	
	
	
}