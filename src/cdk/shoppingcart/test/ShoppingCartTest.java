package cdk.shoppingcart.test;

import java.text.NumberFormat;

import cdk.shoppingcart.domain.ShoppingCartBillCalulator;
import cdk.shoppingcart.enums.CustomerType;


public class ShoppingCartTest {
	public static void main(String[] args) {
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		ShoppingCartBillCalulator customerFactory = new ShoppingCartBillCalulator();
		
		System.out.println("============Regular Customer================");
		System.out.println("purchase Amount: 5000"+ " | Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.REGULAR, 5000)));
		System.out.println("purchase Amount: 10000"+ " | Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.REGULAR, 10000)));
		System.out.println("purchase Amount: 15000"+ " | Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.REGULAR, 15000)));
		System.out.println("============Premium Customer================");
		System.out.println("purchase Amount: 4000"+ " | Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.PREMIUM, 4000)));
		System.out.println("purchase Amount: 8000"+ " | Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.PREMIUM, 8000)));
		System.out.println("purchase Amount: 12000"+ " | Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.PREMIUM, 12000)));
		System.out.println("purchase Amount: 20000"+ " |Bill Amount: "+formatter.format(customerFactory.calculateDiscount(CustomerType.PREMIUM, 20000)));
		
		
		
	}

}
