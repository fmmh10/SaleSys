package application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import facade.dto.SaleDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import handlers.AddEmployeeToSaleHandler;
import handlers.AddProductToSaleHandler;
import handlers.CloseSaleHandler;
import handlers.NewSaleHandler;
import handlers.SaleDiscountHandler;

@Stateless 
public class SaleService implements ISaleServiceRemote {

	@EJB
	private NewSaleHandler newSaleHandler;
	@EJB
	private AddProductToSaleHandler ProductToSaleHandler;
	@EJB
	private SaleDiscountHandler saleDiscountHandler;
	@EJB
	private CloseSaleHandler closeSaleHandler;
	@EJB
	private AddEmployeeToSaleHandler EmployeeSaleHandler;
	
	@Override
	public SaleDTO newSale(int vat) throws ApplicationException {
		return newSaleHandler.newSale(vat);
	}

	@Override
	public SaleDTO addProductToSale(int saleId, int productCode, double qty) throws ApplicationException {
		return ProductToSaleHandler.addProductToSale(saleId, productCode, qty);
		
	}

	@Override
	public double getSaleDiscount(int saleId) throws ApplicationException {
		return saleDiscountHandler.getSaleDiscount(saleId);
	}

	@Override
	public void close(int saleId) throws ApplicationException {
		closeSaleHandler.close(saleId);
		
	}
	
	public void addEmployeeToSale (int saleId, int vatNumber) throws ApplicationException {
		EmployeeSaleHandler.addEmployeeToSale(saleId, vatNumber);
		
	}
	
	
	

}
