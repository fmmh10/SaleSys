package facade.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = -4087131153704256744L;
	private final int vatNumber;
	private final int phoneNumber;
	private final String designation;
	private final int id;
	private final int total_comission;

	public EmployeeDTO(int vatNumber, int phoneNumber, String designation, int id, int total_comission) {
		this.vatNumber = vatNumber;
		this.phoneNumber = phoneNumber;
		this.designation = designation;
		this.id = id;
		this.total_comission = total_comission;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public int getId() {
		return id;
	}
	
	public int getVATNumber() {
		return vatNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getTotalComission() {
		return total_comission;
	}

}