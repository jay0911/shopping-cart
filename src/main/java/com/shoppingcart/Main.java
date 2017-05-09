package com.shoppingcart;

import com.shoppingcart.models.Product;
import com.shoppingcart.services.RuleOne;
import com.shoppingcart.services.ShoppingCart;

public class Main {
	
	public static void main(String[] args) {
		ProductList.initProducts();
		
		ShoppingCart cart1 = new ShoppingCart(new RuleOne());
		cart1.add(new Product("ult_small"));
		cart1.add(new Product("ult_small"));
		cart1.add(new Product("ult_small"));
		
		cart1.add(new Product("ult_large"));
		cart1.total();
		cart1.items();
		
		ShoppingCart cart2 = new ShoppingCart(new RuleOne());
		cart2.add(new Product("ult_large"));
		cart2.add(new Product("ult_large"));
		cart2.add(new Product("ult_large"));
		cart2.add(new Product("ult_large"));
		
		cart2.add(new Product("ult_small"));
		cart2.add(new Product("ult_small"));
		cart2.total();
		cart2.items();
		
		ShoppingCart cart3 = new ShoppingCart(new RuleOne());
		cart3.add(new Product("ult_small"));
		
		cart3.add(new Product("ult_medium"));
		cart3.add(new Product("ult_medium"));
		cart3.total();
		cart3.items();
		
		ShoppingCart cart4 = new ShoppingCart(new RuleOne());
		cart4.add(new Product("ult_small"));
		
		cart4.add(new Product("1gb"));
		cart4.setPromoCode("I<3AMAYSIM");
		cart4.total();
		cart4.items();
	}

}
