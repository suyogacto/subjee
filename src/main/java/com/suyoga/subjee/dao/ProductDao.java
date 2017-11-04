package com.suyoga.subjee.dao;

import java.util.List;

import com.suyoga.subjee.json.InvoiceDetails;
import com.suyoga.subjee.json.OrderInvoice;
import com.suyoga.subjee.json.PlaceOrder;
import com.suyoga.subjee.json.Product;
import com.suyoga.subjee.json.ProductDetails;
import com.suyoga.subjee.json.UpdateInvoice;
import com.suyoga.subjee.model.SabjiLocation;

public interface ProductDao {
	 public  List<Product>	getProduct(int categoryid,int subCategoryId);
	 
	 public OrderInvoice  placeOrder(PlaceOrder placeOrder);
	 public List<InvoiceDetails> getInvoiceDetails(String orderUserId);
	 public String updateInvoiceDetails(UpdateInvoice updateInvoice);
	 public SabjiLocation getzipcodeDetails(int zipcode);
	 
	 public ProductDetails getproduct(int orderid);
	 public  List<Product> getSearch(String searchValue);
		
		
}
