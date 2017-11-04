package com.suyoga.subjee.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UrlValidation {
	 private static Map<String, Boolean> urlDetails=new HashMap<String, Boolean>();
	
	private UrlValidation(){
		
	}
	
	  public static Map getInstance(){
	        if(urlDetails.isEmpty()){
	        	urlDetails.put("/Subjee/area/city", false);
	        	urlDetails.put("/Subjee/area/location", false);
	        	urlDetails.put("/Subjee/category/details", false);
	        	urlDetails.put("/Subjee/user/login", false);
	        	urlDetails.put("/Subjee/user/logout", true);
	        	urlDetails.put("/Subjee/user/passwordReset", false);
	        	urlDetails.put("/Subjee/user/passwordUpdate", true);
	        	urlDetails.put("/Subjee/user/Registration", false);
	        	urlDetails.put("/Subjee/product/Details", false);
	        	urlDetails.put("/Subjee/product/placeOrder", true);
	        	urlDetails.put("/Subjee/user/customerFeedback", false);
	        	urlDetails.put("/Subjee/product/userInvoiceDetails", true);
	        	urlDetails.put("/Subjee/product/updateInvoice", true);
	        	urlDetails.put("/Subjee/category/timeSolt", false);
	        	urlDetails.put("/Subjee/product/zipcodeDetails",true);
	        	urlDetails.put("/Subjee/product/details",true);
	        	urlDetails.put("/Subjee/product/globalSearch",false);
	        	urlDetails.put("/Subjee/user/updateUserDetails",true);
	        	urlDetails.put("/Subjee/user/customerPromocode", true);
	        }
	        return urlDetails;
	    }

}
