package com.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.models.Product;

/**
 * @since 2017
 * @author jay
 * Extend this class to create implementation of your new rule
 *  	
 */
public abstract class PricingRules {
	private String promoCode;
	protected List<Product> products= new ArrayList<Product>();;
	protected String items;
	protected double total;
	
	public abstract void calculate();
	
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
