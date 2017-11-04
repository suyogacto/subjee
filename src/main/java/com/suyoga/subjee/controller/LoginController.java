package com.suyoga.subjee.controller;



import java.math.BigDecimal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.suyoga.subjee.services.LoginService;
import com.suyoga.subjee.util.SubjeeResponseCodes;
import com.suyoga.subjee.util.SubjeeUtil;

@Controller
@RequestMapping("/user")
public class LoginController {
  private static final Logger logger = Logger.getLogger(LoginController.class);
  
  @Autowired
  private LoginService loginService	;
  
  @Autowired
  private ServletContext servletContext;

 @RequestMapping(value="/login",method=RequestMethod.POST)	
 public @ResponseBody ResponseEntity<UserDetails> userLogin(@RequestBody User user,HttpServletRequest request, HttpServletResponse response){
	 UserDetails userDetails=new UserDetails();
	 String validation="";
	 validation=loginService.checkLoginValidation(user);
	 if(validation!=null && validation.equals("valid")){
	
	 userDetails=loginService.getUser(user);
	 
	 if(userDetails!=null && userDetails.getMobileNumber()!=null ){
		 HttpSession session=request.getSession(true);
		 userDetails.setSessionId(session.getId());
		 servletContext.setAttribute(session.getId(), userDetails);
		 loginService.createUserSession(userDetails); 
	     userDetails.setMessage("Login Successfully.");
	 }else if(userDetails.getMessage()!=null && userDetails.getMessage().equalsIgnoreCase("UNR")){
		 userDetails.setMessage("User is not registered.");
		 logger.warn("User is not registered.");
	     return new ResponseEntity(userDetails,HttpStatus.UNAUTHORIZED);
	 }else{
	  userDetails.setMessage("Login failed.");
	  logger.warn("Login failed.");
     return new ResponseEntity(userDetails,HttpStatus.UNAUTHORIZED); 
	 }
	 
	 }else{
		 userDetails.setMessage(validation);
	   return new ResponseEntity(userDetails,HttpStatus.BAD_REQUEST);  
	 }
	
 return new ResponseEntity(userDetails,HttpStatus.OK);
 }
 
 @RequestMapping(value="/Registration",method=RequestMethod.POST)
 public @ResponseBody ResponseEntity<UserDetails> userRegistration (@RequestBody UserRegistration userRegistration,HttpServletRequest request, HttpServletResponse response){
	 String message="";
	 UserDetails userDetails=new UserDetails();
	 Integer i=0;
	 String validation="";
	 validation=loginService.checkRegValidation(userRegistration);
	 if(validation!=null && validation.equals("valid")){			 
	 i=loginService.registration(userRegistration);
	 if(i==1){
		 HttpSession session=request.getSession(true);
		 userDetails.setEmail(userRegistration.getEmail());
		 userDetails.setMobileNumber(userRegistration.getPhoneNubmer());
		 userDetails.setUserName(userRegistration.getName());
		 userDetails.setSessionId(session.getId());
		 userDetails.setAddress(userRegistration.getAddress());
		 userDetails.setZipcode(userRegistration.getZipcode());
		 servletContext.setAttribute(session.getId(), userDetails);
		 loginService.createUserSession(userDetails);
		 message="add successfully";
	 }else if(i==2){
		 userDetails.setMessage("User already exist with this Mobile Number!");
		 logger.warn(userRegistration.getPhoneNubmer()+"  User already exist with this Mobile Number!");
	 }else if(i==3){
		 
		 userDetails.setMessage("User already exists.");
		 logger.warn(userRegistration.getPhoneNubmer()+"  User already exists!");
	 }
	 
	 }else{
	  userDetails.setMessage(validation); 
	 }
	 
  return new ResponseEntity(userDetails,HttpStatus.OK); 
 }
 
 @RequestMapping(value="/passwordReset",method=RequestMethod.POST)	
 public @ResponseBody ResponseEntity<ResetPassword> passwordReset(@RequestBody PasswordReset passwordReset){
	 ResetPassword resetPassword=new ResetPassword();	
	 
	         resetPassword=loginService.userResetPassword(passwordReset);
	 
		 if(resetPassword!=null && resetPassword.getPassowrd()!=null ){
			 
			 resetPassword.setMessage("Your Password has been Changed Successfully.");	
			 
		 }else{
			 
			 resetPassword.setMessage("User not available.");
			 logger.warn(passwordReset.getUserName()+"  User not available!");
		 }
		 
     return new ResponseEntity(resetPassword,HttpStatus.OK); 
	 }
 
 @RequestMapping(value="/passwordUpdate",method=RequestMethod.PUT)	
 public @ResponseBody ResponseEntity<ResetPassword> updatePassword(@RequestBody UpdatePassword updatePassword){
	 PasswordUpdate passwordUpdate=new PasswordUpdate();	
	 String validation="";
	 
	 validation=loginService.checkUpdateValidation(updatePassword);
	 
	 if(validation!=null && validation.equals("valid")){
		 
		 passwordUpdate=loginService.updatePassword(updatePassword);
	 }else{
		 
		 passwordUpdate.setMessage(validation);
		 return new ResponseEntity(passwordUpdate,HttpStatus.BAD_REQUEST);
	 }
     return new ResponseEntity(passwordUpdate,HttpStatus.OK); 
	 }
 
    @RequestMapping(value="/customerFeedback",method=RequestMethod.POST)	
     public @ResponseBody ResponseEntity<ResetPassword> customerFeedback(@RequestBody CustomerFeedback customerFeedback){
	 String message="";
	 
	     message=loginService.customerFeedback(customerFeedback);
	 
	         JSONObject obj = new JSONObject();
	         obj.put("status", message);
		 
     return new ResponseEntity(obj,HttpStatus.OK); 
	 }
    @RequestMapping(value="/updateUserDetails",method=RequestMethod.PUT)
    public @ResponseBody ResponseEntity<UserDetails> updateUserDetails(@RequestBody UserDetails userDetails){
    	 String message="";
    	 message=loginService.updateDetails(userDetails);
    	 if(message!=null && !message.equals("") && message.equalsIgnoreCase("update")){
    		 userDetails.setMessage("Updated Successfully"); 
    	 }else{
    		 userDetails.setMessage("Please check record");  
    	 }
    	
    return new ResponseEntity(userDetails,HttpStatus.OK); 
    }
    @RequestMapping(value="/customerPromocode",method=RequestMethod.POST)	
    public @ResponseBody ResponseEntity<PromocodeDetails> getPromocode(@RequestBody Promocode promocode){
	 String message="";
	 PromocodeDetails promocodeDetails=new PromocodeDetails();
	 promocodeDetails=loginService.checkPromocode(promocode); 

		 
    return new ResponseEntity(promocodeDetails,HttpStatus.OK); 
	 }
 
    @RequestMapping(value="/logout",method=RequestMethod.POST)	
    public @ResponseBody ResponseEntity<JSONObject> logout(@RequestBody Userlogout userlogout,HttpServletRequest request, HttpServletResponse response){
	
	loginService.logoutUser(userlogout); 
	try {
		servletContext = request.getSession().getServletContext();
		servletContext.removeAttribute(userlogout.getSessionid().trim());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JSONObject obj = new JSONObject();
    obj.put("message", "logout Successfully");
		 
    return new ResponseEntity(obj,HttpStatus.OK);
	 }
 
}
