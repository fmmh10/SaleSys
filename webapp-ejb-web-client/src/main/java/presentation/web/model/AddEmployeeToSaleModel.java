package presentation.web.model;


public class AddEmployeeToSaleModel extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4409771095999221005L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	private int vatNumber;
	private int saleId;
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;	
	}
	
	public int getSaleId() {
		return saleId;
	}
	
	
	public void setVatNumber(int vatNumber) {
		this.vatNumber = vatNumber;	
	}
	
	public int getVatNumber() {
		return vatNumber;
	}
	
}
