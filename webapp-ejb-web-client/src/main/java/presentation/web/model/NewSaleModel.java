package presentation.web.model;

public class NewSaleModel extends Model {
	
	private static final long serialVersionUID = 9018115932180050434L;
	
	private String date;
	private String customerVat;
	private String open;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerVat() {
		return customerVat;
	}

	public void setCustomerVat(String customerVat) {
		this.customerVat = customerVat;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String isOpen) {
		this.open = isOpen;
	}

}
