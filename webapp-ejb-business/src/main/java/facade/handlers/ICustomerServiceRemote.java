package facade.handlers;

import java.util.Collection;

import javax.ejb.Remote;

import facade.dto.CustomerDTO;
import facade.dto.DiscountDTO;
import facade.exceptions.ApplicationException;

@Remote
public interface ICustomerServiceRemote {

	public CustomerDTO addCustomer (int vat, String denomination, 
			int phoneNumber, int discountType) 
			throws ApplicationException;
	
	public Collection<DiscountDTO> getDiscounts() throws ApplicationException;
	
	public CustomerDTO getCustomer(int id) throws ApplicationException;

	public Iterable<CustomerDTO> getCustomers() throws ApplicationException;

	public void deleteCustomer(int id) throws ApplicationException;
	
}
