package com.suyoga.subjee.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyoga.subjee.controller.LoginController;
import com.suyoga.subjee.dao.ProductDao;
import com.suyoga.subjee.json.InvoiceDetails;
import com.suyoga.subjee.json.OrderInvoice;
import com.suyoga.subjee.json.PlaceOrder;
import com.suyoga.subjee.json.Product;
import com.suyoga.subjee.json.ProductDetails;
import com.suyoga.subjee.json.ProductList;
import com.suyoga.subjee.json.UpdateInvoice;
import com.suyoga.subjee.model.SabjiLocation;
import com.suyoga.subjee.util.RandomEmail;
import com.suyoga.subjee.util.RandomSmsSystem;
import com.suyoga.subjee.util.SubjeeResponseCodes;
import com.suyoga.subjee.util.SubjeeUtil;



@Service
public class ProductService {
	  private static final Logger logger = Logger.getLogger(ProductService.class);
	@Autowired
	private ProductDao productDao;
	 private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	 public  List<Product>	getProduct(int categoryid,int subCategoryId){
		 
		 return productDao.getProduct(categoryid,subCategoryId);
		 
	 }
	public OrderInvoice placeOrder(PlaceOrder placeOrder){
		 OrderInvoice orderInvoice=new OrderInvoice();
		String invoiceNo="";
		//UUID uniqueKey = UUID.randomUUID();
		///placeOrder.setInvoiceId(uniqueKey.toString());
		orderInvoice=productDao.placeOrder(placeOrder);
		logger.info(orderInvoice.getOrderNumber()+" Order Created");
		if(!orderInvoice.getOrderNumber().equals("")){
			
	    ///String message="Order%20Received%20%3A%20We%20have%20received%20order%20id%20"+orderInvoice.getOrderNumber()+"%20amounting%20to%20Rs."+orderInvoice.getTotalPrice();
	   String message="Order%20Received%20%3A%20We%20have%20received%20order%20id%20"+orderInvoice.getOrderNumber()+"%20%20amounting%20to%20Rs.%20"+orderInvoice.getTotalPrice()+".%20we%20will%20deliver%20them%20within%2024-hours.%0A%0A%0A%0A";
	   RandomSmsSystem.smsSystem(placeOrder.getMobileNumber(),message);
	   ///
	   placeOrderMail(placeOrder,orderInvoice);
		}
		
		return orderInvoice;
	}
	
	public void placeOrderMail(PlaceOrder placeOrder,OrderInvoice orderInvoice){
		
		List<ProductList> productList=placeOrder.getProductList();	
		BigDecimal price=new BigDecimal(0.00);
		String msgText1 ="";
		
		msgText1="<html><head></head><body>";
		msgText1 = msgText1+"<p class=MsoNormal><b><span style='font-size:10.0pt;font-family:'Verdana''>Dear Customer,</span></b><span style='font-size:12.0pt;font-family:'Verdana''><o:p></o:p></span></p>";
		msgText1 = msgText1+"<p class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto; text-align:justify'><span style='font-size:13.0pt;font-family:'Verdana''>Your order "+orderInvoice.getOrderNumber()+" has been successfully placed . We will deliver them within 24-hours. </span></p>"; 
		
		
		
		msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> DELIVERY ADDRESS :</b>&nbsp;&nbsp;<br><br>";
		msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> "+placeOrder.getBillingAddress()+" </b>&nbsp;&nbsp;<br>";
		
		msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> Order Details: </b>&nbsp;&nbsp;<br>";
		
		msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<table style='margin-left:50px;' ><thead><tr><th>Product Name</th> <th>Quantity</th> <th>Price</th> </tr> </thead>";
		
	   for (ProductList productList2 : productList) {
			
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td>"+productList2.getProductName()+"</td><td>"+productList2.getQuantity()+"</td> <td>"+productList2.getPrice()+"</td></tr>";
		  price=price.add(new BigDecimal(productList2.getPrice()));
	   }
	   BigDecimal total=new BigDecimal(0.00);
	   total=new BigDecimal(orderInvoice.getTotalPrice());
	   if(price.compareTo(new BigDecimal(orderInvoice.getMinAmount()))>0){
		   
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td></td><td>Sub Total </td><td>"+price+"</td></tr>"; 
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td></td><td>Delivery charges  </td><td>00.00</td></tr>"; 
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td></td><td>Total </td><td>"+total+"</td></tr>"; 
	   }else{
		   
		  
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td></td><td>Sub Total</td><td>"+price+"</td></tr>"; 
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td></td><td>Delivery charges  </td><td>"+orderInvoice.getDeliveryCharges()+".00</td></tr>"; 
		   msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td></td><td>Total </td><td>"+new BigDecimal(orderInvoice.getMinAmount())+"</td></tr>"; 
		   
		   ///msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<tr><td>Total price</td><td>(Delivery charges Rs.20 + "+total+" )</td><td>"+TotalPrice+"</td></tr>";  
	   }
	   
		
		msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</table>";
		
		
		
		msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><b>Thank you beeing with us.</b>&nbsp;&nbsp;<br><br>";
		
		msgText1=msgText1+"</body></html>";
		
	  RandomEmail.emailSystem(placeOrder.getEmail(), placeOrder.getBillingAddress(), msgText1,orderInvoice.getOrderNumber() );
		
	}
	
	
	
	
	
	
	public List<InvoiceDetails> getInvoiceDetails(String orderUserId){
		
		
	return productDao.getInvoiceDetails(orderUserId);
	}
	
	public String updateInvoiceDetails(UpdateInvoice updateInvoice){
		String message="";
		message=productDao.updateInvoiceDetails(updateInvoice);
		if(message.equalsIgnoreCase("update")){
			message="Update Successfully";
			 String messageSMS="Your%20Oculus%20order%20number%20"+updateInvoice.getOrderNumber()+"%20has%20been%20cancelled";
				
			RandomSmsSystem.smsSystem(updateInvoice.getUserMobileNo(),messageSMS);
			logger.info(updateInvoice.getOrderNumber()+" Order cancelled");
		}else if(message.equalsIgnoreCase("NoDataFound")){
			message="No Data Found";
		}else{
			message="DB Error";
		}
		
	return 	message;
	}
	 
   public String checkValidation(PlaceOrder placeOrder){	   
	   String message="valid"; 
	   
	   if( placeOrder.getZipcode()==null || !placeOrder.getZipcode().matches("^([0-9]{6})$")){		   
		 //message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE005);
		 message="ZipCode is not valid Please enter valid Zipcode";
	   
	   }else if(placeOrder.getBillingMobile()==null || !placeOrder.getBillingMobile().matches("^([0-9]{10})$")){
		   
		//message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE006); 
		message="Mobile no is not valid Please enter valid mobile no.";
		   
	   }/*else if(placeOrder.getBillingAddress()==null || ! placeOrder.getBillingAddress().matches(EMAIL_PATTERN)){
		  
		message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE007);
		
	   }*/
	      
	   return message;
   }

	@SuppressWarnings("unchecked")
	public JSONObject getzipcodeDetails(int zipcode){
		 JSONObject obj = new JSONObject(); 
		SabjiLocation sabjiLocation=null;
		sabjiLocation=productDao.getzipcodeDetails(zipcode);
		
		if(sabjiLocation!=null){
			obj.put("paymentStatus", sabjiLocation.getPaymentType());
			obj.put("minAmount", sabjiLocation.getMinAmount());
			obj.put("deliveryCharges", sabjiLocation.getDeliveryCharges());			
   		    obj.put("status", true);
		}else{
			 obj.put("paymentStatus", "COD");
			 obj.put("minAmount", 250);
			 obj.put("deliveryCharges", 20);	
    		 obj.put("status", false);
		}
		
		return obj;	
	}
	
	   public ProductDetails getproduct(int orderid){
	    	
	    return productDao.getproduct(orderid);	
	   }
	   
	   
	   public  List<Product> getSearch(String searchValue){
			 
	    return productDao.getSearch(searchValue);
	    }  

}
