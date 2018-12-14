package catalogs;

import java.util.Iterator;
import java.util.LinkedList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import business.Employee;
import facade.exceptions.ApplicationException;

/**
 * A catalog of Employees
 * 
 * @author fmartins
 * @version 1.1 (17/04/2015)
 *
 */
@Stateless
public class EmployeeCatalog {

	/**
	 * Entity manager for accessing the persistence service 
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Finds a Employee given its VAT number.
	 * 
	 * @param vat The VAT number of the Employee to fetch from the repository
	 * @return The Employee object corresponding to the Employee with the vat number.
	 * @throws ApplicationException When the Employee with the vat number is not found.
	 */
	public Employee getEmployee (int vat) throws ApplicationException {
		TypedQuery<Employee> query = em.createNamedQuery(Employee.FIND_BY_VAT_NUMBER, Employee.class);
		query.setParameter(Employee.NUMBER_VAT_NUMBER, vat);
		try {
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new ApplicationException ("Employee not found.");
		}
	}
	
	
	public Employee getEmployeeById(int id) throws ApplicationException {
		Employee c = em.find(Employee.class, id);
		if (c == null)
			throw new ApplicationException("Employee with id " + id + " not found");
		else
			return c;
	}
	
	public Iterable<Employee> getEmployees() {
        TypedQuery<Employee> query = em.createNamedQuery(Employee.FIND_ALL_EMPLOYEES, Employee.class);
        return new LinkedList<>(query.getResultList());
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void updateEmployeeComission(int vatNumber, int comission) throws ApplicationException {
		Employee e = getEmployee(vatNumber);
		//se ja tiver algum valor, adiciona mais a nova comissao
		e.setTotalComission(e.getTotalComission() + comission);
		em.persist(e);
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void cancelAllComissions() throws ApplicationException {
		LinkedList<Employee> all_employees = (LinkedList<Employee>) getEmployees(); 
		Iterator<Employee> it = all_employees.iterator();
		
		while(it.hasNext()){
			//iterar cada employee
			Employee e = (Employee) it.next();
			e.cancelAllComissions();
			em.persist(e);
		}
	}
	
	


}
