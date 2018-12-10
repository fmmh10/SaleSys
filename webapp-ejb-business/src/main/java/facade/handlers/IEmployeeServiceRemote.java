package facade.handlers;


import javax.ejb.Remote;

import facade.exceptions.ApplicationException;

@Remote
public interface IEmployeeServiceRemote {

	public void updateEmployeeComission(int vatNumber, int comission) throws ApplicationException;
	public void cancelAllComissions() throws ApplicationException;
	
}
