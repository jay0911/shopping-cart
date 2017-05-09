package com.shoppingcart.models;

public class Product {
	public Product(){}
	
	public Product(String prodCode,String prodName,double prodPrice){
		this.productCode = prodCode;
		this.productName = prodName;
		this.productPrice = prodPrice;
	}
	
	public Product(String prodCode){
		this.productCode = prodCode;
	}

	private String productCode;
	private String productName;
	private double productPrice;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
