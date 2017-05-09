package com.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import com.shoppingcart.models.Product;
/**
 * 
 * singleton class for the product list of Amaysim Shopping Cart 
 * @author jay
 *
 */
public class ProductList {
	private ProductList(){}
	private static Map<String,Product> products = new HashMap<String,Product>();
	public static void initProducts(){
		products.put("ult_small", new Product("ult_small","Unlimited 1GB",24.90));
		products.put("ult_medium", new Product("ult_medium","Unlimited 2GB",29.90));
		products.put("ult_large", new Product("ult_large","Unlimited 5GB",44.90));
		products.put("1gb", new Product("1gb","1 GB Data-pack",9.90));
	}
	public static Map<String,Product> getProductList(){
		return products;
	}
}
