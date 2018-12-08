package facade.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SaleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final CustomerDTO customer;
	//private final EmployeeDTO employee;
	private final LocalDate saleDate;
	private final boolean isOpen;
	private final List<SaleProductDTO> saleProducts;
	private final int id;
	
	public SaleDTO(CustomerDTO customer, LocalDate saleDate, boolean isOpen, 
			       List<SaleProductDTO> saleProducts, int id) {
		this.customer = customer;
		//this.employee = employee;
		this.saleDate = saleDate;
		this.isOpen = isOpen;
		this.saleProducts = saleProducts;
		this.id = id;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}
	
	/*
	public EmployeeDTO getEmployee() {
		return employee;
	}
	*/
	public LocalDate getSaleDate() {
		return saleDate;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public List<SaleProductDTO> getSaleProducts() {
		return saleProducts;
	}
	
	public int getId() {
		return id;
	}

}
