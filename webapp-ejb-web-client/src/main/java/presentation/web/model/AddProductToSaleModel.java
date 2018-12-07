package presentation.web.model;

import facade.handlers.ICustomerServiceRemote;

public class AddProductToSaleModel extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1878810729159374820L;
	/**
	 * 
	 */
	private int saleId;
	private int productCode;
	private double qty;
	private String date;
	private ICustomerServiceRemote addProductToSaleHandler;
	
	public void setAddProductToSaleHandler(ICustomerServiceRemote addProductToSaleHandler) {
		this.addProductToSaleHandler = addProductToSaleHandler;
	}
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;	
	}
	
	public int getSaleId() {
		return saleId;
	}
	
	public int getProductCode() {
		return productCode;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public double getQty() {
		return qty;
	}
	
	public void setQty(double qty) {
		this.qty = qty;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void clearFields() {
		saleId = productCode = 1;
		qty = 1.0;
	}

}
