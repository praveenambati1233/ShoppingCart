package cdk.shoppingcart.domain;

import java.util.ArrayList;
import java.util.List;

import cdk.shoppingcart.enums.CustomerType;

public class ShoppingCartBillCalulator {

	private List<Customer> customers;

	public ShoppingCartBillCalulator() {
		this.customers = new ArrayList<>();
		createOffers();
	}

	private void createOffers() {
		Customer customer = new Customer(CustomerType.REGULAR);
		Discount discount = new Discount(0f, 5_000f, 0.00f);
		customer.addDiscount(discount);
		discount = new Discount(5_000f, 10_000f, 0.10f);
		customer.addDiscount(discount);
		discount = new Discount(10_000f, Float.MAX_VALUE, 0.20f);
		customer.addDiscount(discount);
		customers.add(customer);

		customer = new Customer(CustomerType.PREMIUM);
		discount = new Discount(0f, 4_000f, 0.10f);
		customer.addDiscount(discount);
		discount = new Discount(4_000f, 8_000f, 0.15f);
		customer.addDiscount(discount);
		discount = new Discount(8_000f, 12_000f, 0.20f);
		customer.addDiscount(discount);
		discount = new Discount(12_000f, Float.MAX_VALUE, 0.30f);
		customer.addDiscount(discount);
		customers.add(customer);

	}

	public float calculateDiscount(CustomerType offerType, float amount) {
		float discount = 0f;

		for (Customer customer : customers) {
			if (customer.isDiscountApplied(offerType)) {
				discount += customer.calculateDiscount(amount);
				amount = amount - discount;
			}
		}

		return amount;
	}
}
