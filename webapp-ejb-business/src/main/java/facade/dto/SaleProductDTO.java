package facade.dto;

import java.io.Serializable;

public class SaleProductDTO implements Serializable {

	private static final long serialVersionUID = -7095741050774127934L;
	
    private final String description;
	private final double qty;
	
	public SaleProductDTO(String description, double qty) {
		this.description = description;
		this.qty = qty;
	}

	public String getDescription() {
		return description;
	}

	public double getQty() {
		return qty;
	}
	
}
