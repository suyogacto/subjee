package com.suyoga.subjee.json;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrder {
	
 public List<ProductList> productList=new ArrayList<ProductList>();
 
 public String email;
 public String billingMobile;
 public String billingAddress;
 public String mobileNumber;
 public String totalAmount;
 public String payMode;
 public String zipcode;
 public String timeSlot;
 public String promocode;
 public String discountAmount;
 
 
public List<ProductList> getProductList() {
	return productList;
}
public void setProductList(List<ProductList> productList) {
	this.productList = productList;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getBillingAddress() {
	return billingAddress;
}
public void setBillingAddress(String billingAddress) {
	this.billingAddress = billingAddress;
}
public String getBillingMobile() {
	return billingMobile;
}
public void setBillingMobile(String billingMobile) {
	this.billingMobile = billingMobile;
}
public String getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(String totalAmount) {
	this.totalAmount = totalAmount;
}
public String getPayMode() {
	return payMode;
}
public void setPayMode(String payMode) {
	this.payMode = payMode;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getTimeSlot() {
	return timeSlot;
}
public void setTimeSlot(String timeSlot) {
	this.timeSlot = timeSlot;
}
public String getPromocode() {
	return promocode;
}
public void setPromocode(String promocode) {
	this.promocode = promocode;
}
public String getDiscountAmount() {
	return discountAmount;
}
public void setDiscountAmount(String discountAmount) {
	this.discountAmount = discountAmount;
}

}
