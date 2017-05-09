package com.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.models.Product;

public class ShoppingCart {
	
	private PricingRules rules;
	private List<Product> products = new ArrayList<Product>();
	private String promoCode;
	public ShoppingCart(){}
	public ShoppingCart(PricingRules rules){
		this.rules = rules;
	}
	
	public void add(Product product){
		getProducts().add(product);
	}
	
	public void add(Product product,String promoCode){
		add(product);
		setPromoCode(promoCode);
	}
	
	public void total(){
		this.calculate("total");
	}
	
	public void items(){
		this.calculate("items");
	}
	
	private void calculate(String toCalculate){
		rules.setProducts(products);
		rules.setPromoCode(promoCode);
		rules.calculate();
		if(toCalculate.equals("items")){
			System.out.println(rules.getItems());
		}else{
			System.out.println("$"+rules.getTotal());
		}
	}
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
}
