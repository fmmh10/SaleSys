package business;

import javax.persistence.Entity;

/**
 * A discount based on the amount of sale being greater than a threshold
 * 
 * @author fmartins
 * @version 1.1 (17/04/2015)
 *
 */
@Entity
public class ThresholdPercentageDiscount extends Discount {

	// Just for illustrative purposes of SaleSys with Customers creation

	/**
	 * Serialization Id
	 */
	private static final long serialVersionUID = -6372694415510243401L;

	/**
	 * Constructor needed by JPA 
	 */
	ThresholdPercentageDiscount() {
	}
	
	/**
	 * Creates a discount that will apply a percentage over the total amount
	 * of products in case this amount is above a threshold.
	 * 
	 * @param discountId The id of the discount
	 * @param description The discount description
	 * @param threshold The amount threshold
	 * @param percentage The percentage to be applied
	 */
	public ThresholdPercentageDiscount(int discountId, String description, double threshold, double percentage) {
		super (discountId, description);
	}

	@Override
	public double computeDiscount(Sale sale) {
		// Just for illustrative purposes of SaleSys with Customers creation
		return 0;
	}
	
}
