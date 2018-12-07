package presentation.web.model;

import java.util.LinkedList;

import facade.dto.CustomerDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ICustomerServiceRemote;

public class AllCustomersModel extends Model {
	
	private ICustomerServiceRemote addCustomerHandler;

	public void setAddCustomerHandler(ICustomerServiceRemote addCustomerHandler) {
		this.addCustomerHandler = addCustomerHandler;
	}
	
	public Iterable<CustomerDTO> getCustomers() throws ApplicationException {
		try {
			return addCustomerHandler.getCustomers();
		} catch (ApplicationException e) {
			return new LinkedList<> ();		
		}	
	}
	
}
