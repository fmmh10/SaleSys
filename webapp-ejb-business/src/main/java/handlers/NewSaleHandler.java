package handlers;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Customer;
import business.Sale;
//import business.SaleProduct;
import catalogs.SaleCatalog;
import facade.dto.CustomerDTO;
import facade.dto.SaleDTO;
import facade.dto.SaleProductDTO;
import facade.exceptions.ApplicationException;

@Stateless
public class NewSaleHandler {
	
	/**
	 * The sale catalog
	 */
	@EJB
	private SaleCatalog saleCatalog;

	public SaleDTO newSale (int vat) throws ApplicationException {
		List<SaleProductDTO> sp = new LinkedList<>();
		
		try {
			Sale s = saleCatalog.newSale(vat);
			
/* initially the list is empty, but if not this would be the code to retrieve its saleProducts
 * 
  			for(SaleProduct saleProduct : s.getSaleProducts()) {
				SaleProductDTO saleProductDTO = 
					new SaleProductDTO(saleProduct.getProduct().getDescription(), saleProduct.getQty());
				sp.add(saleProductDTO);
			}
*/		
			Customer c = s.getCustomer();
			CustomerDTO customerDTO = new CustomerDTO(c.getVATNumber(), c.getPhoneNumber(), 
					                                  c.getDesignation(), c.getId());
			
			return new SaleDTO(customerDTO, s.getDate(), s.isOpen(), sp, s.getId());
		} catch (Exception e) {
			throw new ApplicationException ("Error adding sale for customer with VAT " + vat, e);
		}
	}
	
	

}
