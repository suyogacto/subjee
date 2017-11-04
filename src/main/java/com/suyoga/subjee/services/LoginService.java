package com.suyoga.subjee.services;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyoga.subjee.controller.LoginController;
import com.suyoga.subjee.dao.LoginDao;
import com.suyoga.subjee.json.CustomerFeedback;
import com.suyoga.subjee.json.PasswordReset;
import com.suyoga.subjee.json.PasswordUpdate;
import com.suyoga.subjee.json.Promocode;
import com.suyoga.subjee.json.PromocodeDetails;
import com.suyoga.subjee.json.ResetPassword;
import com.suyoga.subjee.json.UpdatePassword;
import com.suyoga.subjee.json.User;
import com.suyoga.subjee.json.UserDetails;
import com.suyoga.subjee.json.UserRegistration;
import com.suyoga.subjee.json.Userlogout;
import com.suyoga.subjee.model.SabjiUser;
import com.suyoga.subjee.util.RandomPasswordGenerator;
import com.suyoga.subjee.util.RandomSmsSystem;
import com.suyoga.subjee.util.SubjeeResponseCodes;
import com.suyoga.subjee.util.SubjeeUtil;
import com.suyoga.subjee.model.SabjiPromocode;

@Service
public class LoginService {
 private static final Logger logger = Logger.getLogger(LoginController.class);
 private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
 @Autowired
 
 private LoginDao loginDao;
 
 public UserDetails getUser(User user){
	 
	 return loginDao.getUser(user);
 }
 
 
 public Integer registration(UserRegistration userRegistration){ 
	 
	 int status=0;
	 status=loginDao.registration(userRegistration);
	 if(status==1){
		 String messageSMS="Thank%20You%20for%20registering%20with%20Suyoga%20Sabjee.%20You%20can%20login%20to%20your%20account%20using%20your%20registered%20%20email%20id%20or%20mobile%20number.%0A%0A";
			
		RandomSmsSystem.smsSystem(userRegistration.getPhoneNubmer(),messageSMS); 
	 }
	 return status;
 }
 
 public void createUserSession(UserDetails userDetails){
	 loginDao.createUserSession(userDetails);
 }
 public Boolean getsessionDetails(String sessionId){
	 
	return loginDao.getsessionDetails(sessionId);
 }
 
 
 public ResetPassword userResetPassword(PasswordReset passwordReset){
	 ResetPassword resetPassword=new ResetPassword();
	 if(passwordReset.getUserName()!=null && !passwordReset.getUserName().trim().equals("")){
		 
	 List<SabjiUser> sabjiUser=loginDao.getUser(passwordReset.getUserName());
	 if(!sabjiUser.isEmpty()){
		    try {
				int noOfCAPSAlpha = 1;
				int noOfDigits = 1;
				int noOfSplChars = 1;
				int minLen = 4;
				int maxLen = 5;
				char[] pswd = RandomPasswordGenerator.generatePswd(minLen, maxLen,
				        noOfCAPSAlpha, noOfDigits, noOfSplChars);
		      String password=new String(pswd); 
		      
		      String base64encodedString = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
		   
		      for(SabjiUser sabjiUser2 : sabjiUser) {
		    	  loginDao.passwordUpdate(sabjiUser2.getId(),sabjiUser2.getUsername(),base64encodedString);
		    	  
		    	  String messageSMS="You%20have%20just%20requested%20to%20reset%20your%20password.%20New%20Password%20is%20"+password;
					
				RandomSmsSystem.smsSystem(sabjiUser2.getPhoneNumber(),messageSMS);
		     }
		    
		      resetPassword.setPassowrd(password); 
		      
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }else{
		 
	 }
	 
	 }
  return resetPassword; 
	 
 }
 
 public PasswordUpdate updatePassword(UpdatePassword updatePassword){
	 
	 PasswordUpdate passwordUpdate=new PasswordUpdate();
	 
	 passwordUpdate=loginDao.updatePassword(updatePassword);
	 
	 if(passwordUpdate!=null && passwordUpdate.getPasswordStatus()!=null && passwordUpdate.getPasswordStatus().equalsIgnoreCase("success")){
		 
		 passwordUpdate.setMessage("Your Password has been Changed Successfully.");
		 
		 String messageSMS="Your%20Password%20has%20been%20Changed%20Successfully";
			
			RandomSmsSystem.smsSystem(updatePassword.getMobileNumber(),messageSMS);
		 
	 }else{
		 
		 passwordUpdate.setMessage("The passwords you typed do not match.");
	 }
	
	return  passwordUpdate;
 }
		 public String checkRegValidation(UserRegistration userRegistration){
			   String message="valid";
			       if(userRegistration.getName()==null || userRegistration.getName().trim().equals("")){
			    	   
			    	   //message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE014); 
			    	   message="please Enter valid Name";
			    	   
			       }else if( userRegistration.getZipcode()==null || !userRegistration.getZipcode().matches("^([0-9]{6})$")){	
			    	  
					 //message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE005);
			    	   message="ZipCode is not valid Please enter valid Zipcode.";
				   
				   }else if(userRegistration.getPhoneNubmer()==null || !userRegistration.getPhoneNubmer().matches("^([0-9]{10})$")){
					   
					//message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE006);  
					   message="Mobile no is not valid Please enter valid mobile no.";
					   
				   }else if(userRegistration.getEmail()==null || ! userRegistration.getEmail().matches(EMAIL_PATTERN)){
					  
					//message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE007);
					   message="Email Address is not Valid.";
					
				   }else if(userRegistration.getPassword()==null || userRegistration.getPassword().equals("") || userRegistration.getPassword().length() < 6 ){
					   
					//message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE012); 
					   message="Password should be contain min 6.";
				   }else if(userRegistration.getConfirmPassword()==null || userRegistration.getConfirmPassword().trim().equals("") ){
					   
					   //message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE012); 
					   message="Password should be contain min 6.";
					
				   }else if(!userRegistration.getPassword().equals(userRegistration.getConfirmPassword())){
					   
					//message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE013); 
					   message="password and Confirm Password do not mach.";
					
				   }else if(userRegistration.getAddress()==null || userRegistration.getAddress().trim().equals("")){
					   //message=SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE015);  
					   message="Please Enter valid Address.";
				   }
			   
		 return message;  
		 }
		 
		 public String checkUpdateValidation(UpdatePassword updatePassword){
			 String message="valid";
			 if(updatePassword.getNewPassword()==null || updatePassword.getNewPassword().equals("") || updatePassword.getNewPassword().length() < 6 ){
				   
					message="Password should be contain min 6"; 
					   
			   }else if(updatePassword.getConfirmPassword()==null || !updatePassword.getConfirmPassword().equals(updatePassword.getConfirmPassword())){
					   
					message="password and Confirm Password do not mach."; 
					
			  }else if(updatePassword.getOldPassword()==null && updatePassword.getOldPassword().equals("")){
				  
				  message="Please Enter valid Old Password.";   
			  }
			 
			 
			 return message;
		 }
		 
		   
		   
		   public String checkLoginValidation(User user){
			   
			   String message="valid";
			   
			   if(user.getUsername()==null || user.getUsername().trim().equals("")){
				   
				   message=SubjeeUtil.subjeeErrMsg("Please Enter UserName.");
				   
			   } else if(user.getPassword()==null || user.getPassword().trim().equals("")){
				   
				   message=SubjeeUtil.subjeeErrMsg("Please Enter Password."); 
			   }
			   
			   
			   return message;
		   }
		   
	public String customerFeedback(CustomerFeedback customerFeedback){
		
		
	return loginDao.customerFeedback(customerFeedback);	
	}
    
	public String updateDetails(UserDetails userDetails){
		
		
    return loginDao.updateDetails(userDetails);	
	}
	
    public PromocodeDetails checkPromocode(Promocode promocode){
    PromocodeDetails promocodeDetails=new PromocodeDetails();
    SabjiPromocode sabjiPromocode=null;
    Date today=new Date();
    sabjiPromocode=loginDao.checkPromocode(promocode);
    BigDecimal maxDiscountAmount=new BigDecimal(0.00);
    try {
		if(sabjiPromocode!=null){
			if(today.after(sabjiPromocode.getStartDate()) && today.before(sabjiPromocode.getEndDate())){
		      if(sabjiPromocode.getZipcode()==0){
		    	if(sabjiPromocode.getMinamount().compareTo(new BigDecimal(promocode.getTotalAmount()))<0){
		    	 if(sabjiPromocode.getTotalAmount()!=null){
		    		 promocodeDetails.setStatus(true);
		    		 promocodeDetails.setDiscountAmount(sabjiPromocode.getTotalAmount());
		    		 promocodeDetails.setMessage("Promo Code Applied Succesfully"); 
		    	 }else{
		    		 promocodeDetails.setStatus(true);
		    		 maxDiscountAmount=new BigDecimal(promocode.getTotalAmount()).multiply(new BigDecimal(sabjiPromocode.getPercentage())).divide((new BigDecimal(100)));
		    		 if(sabjiPromocode.getMaxAmount().compareTo(maxDiscountAmount)<0){
		    			 promocodeDetails.setDiscountAmount(sabjiPromocode.getMaxAmount());  
		    		 }else{
		    			 promocodeDetails.setDiscountAmount(maxDiscountAmount);  
		    		 }
		    		
		    		 promocodeDetails.setMessage("Promo Code Applied Succesfully"); 
		    	 }
		    	}else{
		    		promocodeDetails.setMessage("Minimum Purchase "+sabjiPromocode.getMinamount()+" is required");  
		    	}
		    	  
		      }else if(sabjiPromocode.getZipcode()==promocode.getZipcode()){

			    	if(sabjiPromocode.getMinamount().compareTo(new BigDecimal(promocode.getTotalAmount()))<0){
			    	 if(sabjiPromocode.getTotalAmount()!=null){
			    		 promocodeDetails.setStatus(true);
			    		 promocodeDetails.setDiscountAmount(sabjiPromocode.getTotalAmount());
			    		 promocodeDetails.setMessage("Promo Code Applied Succesfully"); 
			    	 }else{
			    		 promocodeDetails.setStatus(true);
			    		 maxDiscountAmount=new BigDecimal(promocode.getTotalAmount()).multiply(new BigDecimal(sabjiPromocode.getPercentage())).divide((new BigDecimal(100)));
			    		 if(sabjiPromocode.getMaxAmount().compareTo(maxDiscountAmount)<0){
			    			 promocodeDetails.setDiscountAmount(sabjiPromocode.getMaxAmount());  
			    		 }else{
			    			 promocodeDetails.setDiscountAmount(maxDiscountAmount);  
			    		 }
			    		
			    		 promocodeDetails.setMessage("Promo Code Applied Succesfully"); 
			    	 }
			    	}else{
			    		promocodeDetails.setMessage("Minimum Purchase "+sabjiPromocode.getMinamount()+" is required");  
			    	}
		    	  
		      }else{
		    	  promocodeDetails.setMessage("Promo Code is not Valide for Zipcode");   
		      }
			}else{
			promocodeDetails.setMessage("Promo Code is not Valide");	
			}
		}else{
			promocodeDetails.setMessage("Promo Code is not Valide");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		promocodeDetails.setMessage("Promo Code is not Valide");
	}
    	
    	
	return promocodeDetails;	  
	}
	public void logoutUser(Userlogout userlogout){
		loginDao.logoutUser(userlogout);
	}
 
}
