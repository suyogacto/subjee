package com.suyoga.subjee.json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Product {
	
	public int productId;
	
	public String productCode;
	
	public String productName;
	
	public Number price;
	
	public int priceMinQuantity;
	
	public String brandname;
	
	
	public List<QuantityList> quantityList=new ArrayList<QuantityList>();
	
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

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



	public int getPriceMinQuantity() {
		return priceMinQuantity;
	}

	public void setPriceMinQuantity(int priceMinQuantity) {
		this.priceMinQuantity = priceMinQuantity;
	}

	public List<QuantityList> getQuantityList() {
		return quantityList;
	}

	public void setQuantityList(List<QuantityList> quantityList) {
		this.quantityList = quantityList;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	
	

}
