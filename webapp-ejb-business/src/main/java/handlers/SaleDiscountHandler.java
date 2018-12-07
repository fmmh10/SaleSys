package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Customer;
import business.Discount;
import business.Sale;
import catalogs.DiscountCatalog;
import catalogs.SaleCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class SaleDiscountHandler {
	@EJB
	private SaleCatalog saleCatalog;
	@EJB
	private DiscountCatalog discountCatalog;
	
	public double getSaleDiscount (int saleId) throws ApplicationException{
		Sale sale = saleCatalog.getSaleById(saleId);
		Customer customer = sale.getCustomer();
		
		Discount discount = discountCatalog.getDiscount(customer.getDiscountType().getId());		
		
		try {
			return discount.computeDiscount(sale);
		} catch (Exception e) {
			throw new ApplicationException ("Error getting discount sale from saleId " + saleId, e);
		}
		
	}
	
}
