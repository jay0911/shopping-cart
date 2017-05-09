package com.shoppingcart.services;

import java.text.DecimalFormat;

import com.shoppingcart.ProductList;
import com.shoppingcart.models.Product;

/**
 * @see PricingRules
 * @since 2017
 * @author jay
 * this is an implementation of pricing rule for first month of Amaysim Shopping Cart   
 */
public class RuleOne extends PricingRules{
	private int unliOneGbToRemove = 0;
	private double totalAfterPricingRules = 0;
	private int bundleFree = 0;
	private boolean isHavingPromoCode = false;
	private boolean isHavingBulkDiscount = false;
	
	private int ult_small = 0;
	private int ult_medium = 0;
	private int ult_large = 0;
	private int onegb = 0;
	
	private static final double ULT_LARGE_PROMO = 39.90;
	private static final double DISCOUNT_PROMO_CODE = 0.10;
	
	@Override
	public void calculate() {
		// TODO Auto-generated method stub	
		init();
		
		threeForTwoDealChecker();
		countBundleFreeAndUltMedium();
		isHavingBulkDiscount = bulkDiscountChecker();
		isHavingPromoCode = withPromoCodeChecker();
		countOneGb();
		
		//for total items
		StringBuilder sb = new StringBuilder();
		expectedCartItems(sb);
		items = sb.toString();

		//for total price of the items
		DecimalFormat df = new DecimalFormat("#.##");      
		total = Double.valueOf(df.format(checkTotalPrice()));
		
	}
	
	/**
	 * initialize values
	 */
	public void init(){
		unliOneGbToRemove = 0;
		totalAfterPricingRules = 0;
		bundleFree = 0;
		isHavingPromoCode = false;
		isHavingBulkDiscount = false;
		ult_small = 0;
		ult_large = 0;
		ult_medium = 0;
		onegb = 0;
	}
	
	public double checkTotalPrice(){
		ult_small = ult_small - unliOneGbToRemove;
		totalAfterPricingRules = (ult_small * ProductList.getProductList().get("ult_small").getProductPrice())
				+ (ult_medium * ProductList.getProductList().get("ult_medium").getProductPrice())
				+ (onegb * ProductList.getProductList().get("1gb").getProductPrice());
		if(isHavingBulkDiscount){
			totalAfterPricingRules = totalAfterPricingRules + (ult_large * ULT_LARGE_PROMO);
		}else{
			totalAfterPricingRules = totalAfterPricingRules + (ult_large * ProductList.getProductList().get("ult_large").getProductPrice());
		}
		
		if(isHavingPromoCode){
			totalAfterPricingRules = totalAfterPricingRules - (totalAfterPricingRules * DISCOUNT_PROMO_CODE);
		}
		
		return totalAfterPricingRules;
	}
	
	public void expectedCartItems(StringBuilder sb){
		if(ult_small > 0){
			sb.append(ult_small + "x Unlimited 1 GB");
			sb.append("\n"); 
		}
		if(ult_medium > 0){
			sb.append(ult_medium + "x Unlimited 2 GB");
			sb.append("\n");  
		}
		if(ult_large > 0){
			sb.append(ult_large + "x Unlimited 5 GB");
			sb.append("\n"); 
		}
		if((onegb + bundleFree) > 0){
			sb.append((onegb + bundleFree) + "x 1 GB Data-pack");
			sb.append("\n");  
		}
	}
	
	/**
	 * A 3 for 2 deal on Unlimited 1GB Sims. So for example, if you buy 3 Unlimited 1GB Sims, you will pay the price of 2 only for the first
		month.
	 */
	private void threeForTwoDealChecker(){
		int itemCount = productCounter("ult_small");	
		ult_small = itemCount;
		if(itemCount <= 3){
			unliOneGbToRemove = itemCount / 3;
		}else{
			unliOneGbToRemove = 0;
		}
	}
	
	/**
	 * The Unlimited 5GB Sim will have a bulk discount applied; whereby the price will drop to $39.90 each for the first month, if the customer
		buys more than 3.
	 */
	private boolean bulkDiscountChecker(){
		int itemCount = productCounter("ult_large");
		ult_large = itemCount;
		if(itemCount > 3){
			return true;
		}
		return false;
	}
	
	/**
	 * We will bundle in a free 1 GB Data-pack free-of-charge with every Unlimited 2GB sold.
	 */
	private void countBundleFreeAndUltMedium(){
		ult_medium = productCounter("ult_medium");
	}
	
	/**
	 * Adding the promo code 'I<3AMAYSIM' will apply a 10% discount across the board.
	 */
	private boolean withPromoCodeChecker(){
		if(getPromoCode() == "I<3AMAYSIM"){
			return true;
		}
		return false;
	}
	/**
	 * count one gb products
	 */
	private void countOneGb(){
		onegb = productCounter("1gb");
	}
	
	/**
	 * use to count products using product code from the list
	 */
	private int productCounter(String productCode){
		int itemCount = 0;
		for(Product product:products){
			if(product.getProductCode()==ProductList.getProductList().get(productCode).getProductCode()){
				itemCount++;
			}
		}
		return itemCount;
	}

}
