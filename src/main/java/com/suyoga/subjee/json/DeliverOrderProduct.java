package com.suyoga.subjee.json;

public class DeliverOrderProduct {
	public int orderProductId;
	public int orderId;
	public int productId;
	public String orderProductQuantity;
	public String orderProductName;
	public String orderProductCode;
	public String orderProductPrice;
	public String brandName;
	
	public int getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderProductQuantity() {
		return orderProductQuantity;
	}
	public void setOrderProductQuantity(String orderProductQuantity) {
		this.orderProductQuantity = orderProductQuantity;
	}
	public String getOrderProductName() {
		return orderProductName;
	}
	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}
	public String getOrderProductCode() {
		return orderProductCode;
	}
	public void setOrderProductCode(String orderProductCode) {
		this.orderProductCode = orderProductCode;
	}
	public String getOrderProductPrice() {
		return orderProductPrice;
	}
	public void setOrderProductPrice(String orderProductPrice) {
		this.orderProductPrice = orderProductPrice;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
