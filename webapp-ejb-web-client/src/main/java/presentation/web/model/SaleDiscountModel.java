package presentation.web.model;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;

public class SaleDiscountModel extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3944578977665620716L;
	/**
	 * 
	 */
	
	private ISaleServiceRemote SaleDiscountHandler;

	public void setSaleDiscountHandler(ISaleServiceRemote SaleDiscountHandler) {
		this.SaleDiscountHandler = SaleDiscountHandler;
	}
	
	private int saleId;
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;	
	}
	
	public int getSaleId() {
		return saleId;
	}
		
	
	public double getDiscount(int saleId) throws ApplicationException {
		return SaleDiscountHandler.getSaleDiscount(saleId);
	}

}
