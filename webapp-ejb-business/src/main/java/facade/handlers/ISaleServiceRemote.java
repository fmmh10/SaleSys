package facade.handlers;

import javax.ejb.Remote;

import facade.dto.SaleDTO;
import facade.exceptions.ApplicationException;

@Remote
public interface ISaleServiceRemote {
	
	public SaleDTO newSale (int vat) throws ApplicationException;
	public SaleDTO addProductToSale(int saleId, int productCode, double qty) throws ApplicationException;
	public double getSaleDiscount (int saleId) throws ApplicationException;
	public void close (int saleId) throws ApplicationException;
	public void addEmployeeToSale (int saleId, int vatNumber) throws ApplicationException;
	public void addComissionPercentageToSale (int saleId, int percentage) throws ApplicationException;
}
