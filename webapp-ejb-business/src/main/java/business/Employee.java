package business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * A Employee
 *	
 * @author fmartins
 * @version 1.1 (17/04/2015)
 * 
 */
@Entity  
@NamedQueries({
	@NamedQuery(name=Employee.FIND_BY_VAT_NUMBER, query="SELECT c FROM Employee c WHERE c.vatNumber = :" + 
		Employee.NUMBER_VAT_NUMBER),
	@NamedQuery(name=Employee.FIND_ALL_EmployeeS, query="SELECT c FROM Employee c")
})
public class Employee {

	// Named query name constants
	public static final String FIND_BY_VAT_NUMBER = "Employee.findByVATNumber";
	public static final String NUMBER_VAT_NUMBER = "vatNumber";
	public static final String FIND_ALL_EmployeeS = "Employee.findAllEmployees";
	
	// Employee attributes 

	/**
	 * Employee primary key. Needed by JPA. Notice that it is not part of the
	 * original domain model.
	 */
	@Id @GeneratedValue 
	private int id;
	
	/**
	 * Employee's VAT number
	 */
	@Column(nullable = false, unique = true) 
	private int vatNumber;
	
	/**
	 * Employee's name. In case of a company, the represents its commercial denomination 
	 */
	@Column(nullable = false) private String designation;
	
	/**
	 * Employee's contact number
	 */
	@SuppressWarnings("unused")
	private int phoneNumber;
	
	@SuppressWarnings("unused")
	private int total_comission;

	// 1. constructor 

	/**
	 * Constructor needed by JPA.
	 */
	Employee() {
	}
	
	/**
	 * Creates a new Employee given its VAT number, its designation, phone contact, and discount type.
	 * 
	 * @param vatNumber The Employee's VAT number
	 * @param designation The Employee's designation
	 * @param phoneNumber The Employee's phone number
	 * @pre isValidVAT(vat) 
	 */
	public Employee(int vatNumber, String designation, int phoneNumber) {
		this.vatNumber = vatNumber;
		this.designation = designation;
		this.phoneNumber = phoneNumber;
	}

	
	// 2. getters and setters
	
	/**
	 * For testing purposes only.
	 * 
	 * @return The Employee VAT number
	 */
	public int getVATNumber() {
		return vatNumber;
	}
	
	/**
	 * @return The Employee phone number
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * @return The description of the Employee
	 */
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * @return The Employee's id
	 */
	public int getId() {
		return id;
	}
	
	public int getTotalComission() {
		return total_comission;
	}
	
	public void setTotalComission(int comission) {
		this.total_comission = comission;
	}

	public void cancelAllComissions() {
		this.total_comission = 0;
	}
	
	/**
	 * Checks if a VAT number is valid.
	 * 
	 * @param vat The number to be checked.
	 * @return Whether the VAT number is valid. 
	 */
	public static boolean isValidVAT(int vat) {
		// If the number of digits is not 9, error!
		if (vat < 100000000 || vat > 999999999)
			return false;
		
		// If the first number is not 1, 2, 5, 6, 8, 9, error!
		int firstDigit = vat / 100000000;
		if (firstDigit > 2 && firstDigit < 8 &&
			firstDigit != 5 && firstDigit != 6)
			return false;
		
		return vat % 10 == mod11(vat);
	}


	/**
	 * @param num The number to compute the modulus 11.
	 * @return The modulus 11 of num.
	 */
	private static int mod11(int num) {
		// Checks the congruence modules 11.
		int sum = 0;
		int quocient = num / 10;
		
		for (int i = 2; i < 10 && quocient != 0; i++) {
			sum += quocient % 10 * i;
			quocient /= 10;
		}
		
		int checkDigitCalc = 11 - sum % 11;
		return checkDigitCalc == 10 ? 0 : checkDigitCalc;
	}

}