package com.suyoga.subjee.json;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails {
	
	
	List<ReturnOrderProduct> returnOrderProduct=new ArrayList<ReturnOrderProduct>();
    List<DeliverOrderProduct> deliverOrderProduct=new ArrayList<DeliverOrderProduct>();
    
    
	public List<ReturnOrderProduct> getReturnOrderProduct() {
		return returnOrderProduct;
	}
	public void setReturnOrderProduct(List<ReturnOrderProduct> returnOrderProduct) {
		this.returnOrderProduct = returnOrderProduct;
	}
	public List<DeliverOrderProduct> getDeliverOrderProduct() {
		return deliverOrderProduct;
	}
	public void setDeliverOrderProduct(List<DeliverOrderProduct> deliverOrderProduct) {
		this.deliverOrderProduct = deliverOrderProduct;
	}

}
