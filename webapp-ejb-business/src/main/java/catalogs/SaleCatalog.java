package catalogs;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import business.Customer;
import business.Discount;
import business.Employee;
import business.Product;
import business.Sale;
import enums.SaleStatus;
import facade.exceptions.ApplicationException;

@Stateless
public class SaleCatalog {
	
	/**
	 * Entity manager for accessing the persistence service 
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * The customer's catalog
	 */
	@EJB
	private CustomerCatalog customerCatalog;
	private ProductCatalog productCatalog;
	private DiscountCatalog discountCatalog;
	private EmployeeCatalog employeeCatalog;
	
	/**
	 * Creates new sale
	 * 
	 * @param vat The VAT number of the customer for this sale
	 * @return The newly created Sale object 
	 * @throws ApplicationException When the customer with the vat number is not found 
	 *         or the sale could not be creaetd.
	 */
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Sale newSale (int vat) throws ApplicationException {
		Customer customer = customerCatalog.getCustomer(vat);
		Sale sale = new Sale(LocalDate.now(), customer,null);
		em.persist(sale);
		return sale;
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Sale addProductToSale (int saleId, int productCode, double qty) throws ApplicationException {
		Product product = productCatalog.getProduct(productCode);
		Sale sale = getSaleById(saleId);
		sale.addProductToSale(product, qty);
		em.persist(sale);
		return sale;
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public double getSaleDiscount (int saleId) throws ApplicationException{
		Sale sale = getSaleById(saleId);
		Customer customer = sale.getCustomer();
		Discount discount = discountCatalog.getDiscount(customer.getDiscountType().getId());		
		em.persist(sale);
		return discount.computeDiscount(sale);
		
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void close (int saleId) throws ApplicationException {
		TypedQuery<Sale> query = em.createNamedQuery(Sale.FIND_BY_ID, Sale.class);
		query.setParameter(Sale.NUMBER_ID, saleId);
		Sale sale = query.getSingleResult();
		sale.setStatus(SaleStatus.CLOSED);
		em.persist(sale);
			
		
	}
	
	
	public Sale getSaleById(int saleId) throws ApplicationException {
		Sale s = em.find(Sale.class, saleId);
		if (s == null)
			throw new ApplicationException("Sale with id " + saleId + " not found");
		else
			return s;
	}
	
	public void addEmployeeToSale (int saleId, int vatNumber) throws ApplicationException {
		Employee employee = employeeCatalog.getEmployee(vatNumber);
		Sale sale = getSaleById(saleId);
		sale.setEmployee(employee);
		em.merge(sale);
	}
	
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void addComissionPercentageToSale (int saleId, int percentage) throws ApplicationException {
		Sale sale = getSaleById(saleId);
		sale.setComission_percentage(percentage);
		em.persist(sale);
	}

}
