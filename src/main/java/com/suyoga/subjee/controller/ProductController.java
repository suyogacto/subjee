package com.suyoga.subjee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suyoga.subjee.json.InvoiceDetails;
import com.suyoga.subjee.json.OrderInvoice;
import com.suyoga.subjee.json.PlaceOrder;
import com.suyoga.subjee.json.Product;
import com.suyoga.subjee.json.ProductDetails;
import com.suyoga.subjee.json.ProductList;
import com.suyoga.subjee.json.UpdateInvoice;
import com.suyoga.subjee.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
  @RequestMapping(value="/Details/{cId}/{subId}",method=RequestMethod.GET)
 public @ResponseBody ResponseEntity<List<Product>>	getProduct(@PathVariable("cId") int categoryid ,@PathVariable("subId") int subCategoryId ){
	 
	 List<Product> product=new ArrayList<Product>();
	 ObjectMapper mapper = new ObjectMapper();
	 String productDetails="";
	 product=productService.getProduct(categoryid,subCategoryId);
	 
	 try {
		 productDetails=mapper.writeValueAsString(product);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
/*	 PlaceOrder placeOrder=new PlaceOrder();
	 List<ProductList> list=new ArrayList<ProductList>();
	 ProductList productList=new ProductList();
	 list.add(productList);
	 
	 placeOrder.setProductList(list);*/
	 
	return new ResponseEntity(productDetails,HttpStatus.OK); 
 }
     @RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	 public @ResponseBody ResponseEntity<OrderInvoice> placeOrder(@RequestBody PlaceOrder placeOrder){
    	 OrderInvoice orderInvoice=new OrderInvoice();
    	 String orderNumber=""; 
    	 String validation="";
    	 validation=productService.checkValidation(placeOrder);
    	 if(validation!=null && validation.equals("valid")){
    	 orderInvoice=productService.placeOrder(placeOrder);
    	 
		if(orderInvoice!=null && !orderInvoice.getOrderNumber().equals("")){
			///orderInvoice.setOrderNumber(orderNumber);
			orderInvoice.setMessage("Order place successfully");
		}
    	}else{
    		orderInvoice.setOrderNumber("");
    		orderInvoice.setMessage(validation);
    		return new ResponseEntity(orderInvoice,HttpStatus.BAD_REQUEST);
    	}
	return new ResponseEntity(orderInvoice,HttpStatus.OK);
 }
     
     @RequestMapping(value="/userInvoiceDetails/{orderUserId}",method=RequestMethod.GET) 
     public @ResponseBody ResponseEntity<InvoiceDetails> invoiceDetails(@PathVariable("orderUserId") String orderUserId){
    	 List<InvoiceDetails> detailsList=new ArrayList<InvoiceDetails>();
    	 
    	 detailsList=productService.getInvoiceDetails(orderUserId);
    	 
      return new ResponseEntity(detailsList,HttpStatus.OK);
    	 
     }
     
     @RequestMapping(value="/updateInvoice",method=RequestMethod.PUT) 
     public @ResponseBody ResponseEntity<InvoiceDetails> updateInvoiceStatus(@RequestBody UpdateInvoice updateInvoice){
    	String status="";
    	 
    	status=productService.updateInvoiceDetails(updateInvoice);
    	
    	JSONObject obj = new JSONObject();
        obj.put("status", status);
        
      return new ResponseEntity(obj,HttpStatus.OK);
    	 
     }
     
     @SuppressWarnings("unchecked")
	@RequestMapping(value="/zipcodeDetails/{zipcode}",method=RequestMethod.GET) 
     public @ResponseBody ResponseEntity<String> zipcodeDetails(@PathVariable("zipcode") int zipcode){
    	
    	 JSONObject obj = new JSONObject(); 
    	 obj=productService.getzipcodeDetails(zipcode);
   
    	 
      return new ResponseEntity(obj,HttpStatus.OK);
    	 
     }
     
     @SuppressWarnings("unchecked")
     @RequestMapping(value="/details/{OId}",method=RequestMethod.GET)
     public @ResponseBody ResponseEntity<ProductDetails> getOrder(@PathVariable("OId") int orderid){
     	ProductDetails productList=new ProductDetails();
     	
     	productList=productService.getproduct(orderid);
     	
          JSONObject obj = new JSONObject();
          obj.put("data", productList);
     	return new ResponseEntity(obj,HttpStatus.OK); 
     }
     
     @RequestMapping(value="/globalSearch",method=RequestMethod.GET)
     public @ResponseBody ResponseEntity<List<Product>>	getGlobalSearch(@RequestParam("searchValue") String searchValue){
    	 
    	 List<Product> product=new ArrayList<Product>();    
    	
    	 product=productService.getSearch(searchValue);
    	 
    /*	 try {
    		 productDetails=mapper.writeValueAsString(product);
    	} catch (JsonProcessingException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}*/
    /*	 PlaceOrder placeOrder=new PlaceOrder();
    	 List<ProductList> list=new ArrayList<ProductList>();
    	 ProductList productList=new ProductList();
    	 list.add(productList);
    	 
    	 placeOrder.setProductList(list);*/
    	 
    	return new ResponseEntity(product,HttpStatus.OK); 
     }
}
