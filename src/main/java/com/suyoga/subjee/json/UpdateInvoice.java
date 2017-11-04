package com.suyoga.subjee.json;

public class UpdateInvoice {
	
	public int orderId;
	
	public String orderNumber;
	
	public String totalAmount;
	
	public String userMobileNo;
	
	public String reasonTocancel; 
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public String getReasonTocancel() {
		return reasonTocancel;
	}

	public void setReasonTocancel(String reasonTocancel) {
		this.reasonTocancel = reasonTocancel;
	}
	
	
	

}
