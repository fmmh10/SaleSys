package application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import facade.exceptions.ApplicationException;
import facade.handlers.IEmployeeServiceRemote;

import handlers.*;

/**
 * A service the offers the addition of Employee. The purpose of this class is to provide access 
 * to the business layer, hiding its implementation from the clients. Clients should never interact 
 * directly with the business layer. 
 * 
 * @author fmartins
 * @version 1.1 (16/2/2017)
 */
@Stateless 
public class EmployeeService implements IEmployeeServiceRemote {

	/**
	 * The business object façades that handle this use case request
	 */
	@EJB
	private UpdateEmployeeComissionHandler updateHandler;
	
	@EJB
	private CancelAllComissionsHandler cancelComissionsHandler;
	
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	public void updateEmployeeComission(int vatNumber, int comission) throws ApplicationException {
		
		updateHandler.update(vatNumber, comission);
		
	}



	@Override
	public void cancelAllComissions() throws ApplicationException {
		cancelComissionsHandler.cancelAllComissions();
		
	}


	
	
}