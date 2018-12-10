package presentation.web.model;

public class UpdateEmployeeComissionModel extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2404200108049537740L;
	private int vatNumber;
	private int comission;
	
	public void setVatNumber(int vatNumber) {
		this.vatNumber = vatNumber;
	}
	
	public int getVatNumber() {
		return vatNumber;
	}


	public void setComission(int comission) {
		this.comission = comission;
	}
	
	public int getComission() {
		return comission;
	}

}
