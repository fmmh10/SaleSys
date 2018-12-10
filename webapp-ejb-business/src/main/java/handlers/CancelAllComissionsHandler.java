package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import catalogs.EmployeeCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class CancelAllComissionsHandler {
	
	@EJB
	private EmployeeCatalog employeeCatalog;
	
	public void cancelAllComissions() throws ApplicationException {
		try {
		employeeCatalog.cancelAllComissions();
	
		} catch (Exception e) {
			throw new ApplicationException ("Error cancelling all comissions", e);
		}
	}

}
