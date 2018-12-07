package facade.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = -4087131153704256744L;
	private final int vatNumber;
	private final int phoneNumber;
	private final String designation;
	private final int id;

	public CustomerDTO(int vatNumber, int phoneNumber, String designation, int id) {
		this.vatNumber = vatNumber;
		this.phoneNumber = phoneNumber;
		this.designation = designation;
		this.id = id;
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
}