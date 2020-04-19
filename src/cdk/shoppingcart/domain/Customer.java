package cdk.shoppingcart.domain;

import java.util.ArrayList;
import java.util.List;

import cdk.shoppingcart.enums.CustomerType;

public class Customer {

	private final CustomerType customerType;

	private List<Discount> discounts;

	public Customer(CustomerType customerType) {
		this.customerType = customerType;
		this.discounts = new ArrayList<>();
	}

	public void addDiscount(Discount discount) {
		this.discounts.add(discount);
	}

	public boolean isDiscountApplied(CustomerType type) {
		return (customerType.equals(type));
	}

	public float calculateDiscount(float amount) {
		float finaldiscount = 0f;

		for (Discount discount : discounts) {
			if (discount.isDiscountApplied(amount)) {
				finaldiscount += discount.calculateDiscount(amount);

			}
		}

		return finaldiscount;
	}

}
