package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import catalogs.EmployeeCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class UpdateEmployeeComissionHandler {
	
	@EJB
	private EmployeeCatalog employeeCatalog;
	
	public void update(int vatNumber, int comission) throws ApplicationException {
		employeeCatalog.updateEmployeeComission(vatNumber, comission);
	}

}
