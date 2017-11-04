package com.suyoga.subjee.json;

import java.math.BigDecimal;

public class PromocodeDetails {
	
 public Boolean status=false;
 
 public String message;
 
 public BigDecimal discountAmount=new BigDecimal(0.00);

public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public BigDecimal getDiscountAmount() {
	return discountAmount;
}

public void setDiscountAmount(BigDecimal discountAmount) {
	this.discountAmount = discountAmount;
}
	

}
