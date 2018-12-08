package handlers;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Customer;
import business.Sale;
import business.SaleProduct;
import catalogs.ProductCatalog;
import catalogs.SaleCatalog;
import facade.dto.CustomerDTO;
import facade.dto.SaleDTO;
import facade.dto.SaleProductDTO;
import facade.exceptions.ApplicationException;

@Stateless
public class AddProductToSaleHandler {
	/**
	 * The sale catalog
	 */
	@EJB
	private SaleCatalog saleCatalog;
	
	@EJB
	private ProductCatalog productCatalog;

	public SaleDTO addProductToSale(int saleId, int productCode, double qty) throws ApplicationException {
		List<SaleProductDTO> sp = new LinkedList<>();
		
		try {
			Sale s = saleCatalog.addProductToSale(saleId, productCode, qty);
			
			for(SaleProduct saleProduct : s.getSaleProducts()) {
				SaleProductDTO saleProductDTO = 
					new SaleProductDTO(saleProduct.getProduct().getDescription(), saleProduct.getQty());
				sp.add(saleProductDTO);
			}
			
			
			Customer c = s.getCustomer();
			CustomerDTO customerDTO = new CustomerDTO(c.getVATNumber(), c.getPhoneNumber(), 
					                                  c.getDesignation(), c.getId());
			System.out.println("erro");
			return new SaleDTO(customerDTO, s.getDate(), s.isOpen(), sp, s.getId());
		} catch (Exception e) {
			throw new ApplicationException ("Error adding product to sale with id " + saleId, e);
		}

	}
	
} 