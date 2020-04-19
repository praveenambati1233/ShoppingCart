package cdk.shoppingcart.domain;

public class Discount {

	private final float lowerAmount;
	private final float upperAmount;
	private final float percentDiscount;

	public Discount(float lowerAmount, float upperAmount, float percentDiscount) {
		this.lowerAmount = lowerAmount;
		this.upperAmount = upperAmount;
		this.percentDiscount = percentDiscount;
	}

	public boolean isDiscountApplied(float amount) {
		return (lowerAmount < amount);
	}

	public float calculateDiscount(float amount) {
		if (amount > upperAmount) {
			return (upperAmount - lowerAmount) * percentDiscount;
		} else {
			return (amount - lowerAmount) * percentDiscount;
		}
	}

}