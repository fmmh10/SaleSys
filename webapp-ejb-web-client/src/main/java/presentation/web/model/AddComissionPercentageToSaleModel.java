package presentation.web.model;

public class AddComissionPercentageToSaleModel extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9102473278781210243L;
	private int saleId;
	private int comission_percentage;
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;	
	}
	
	public int getSaleId() {
		return saleId;
	}
	
	public void setComission_percentage(int comission_percentage) {
		this.comission_percentage = comission_percentage;
	}
	
	public int getComission_percentage() {
		return comission_percentage;
	}
}
