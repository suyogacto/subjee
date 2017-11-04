package com.suyoga.subjee.dao;

import java.util.List;

import com.suyoga.subjee.json.CustomerFeedback;
import com.suyoga.subjee.json.PasswordUpdate;
import com.suyoga.subjee.json.Promocode;
import com.suyoga.subjee.json.UpdatePassword;
import com.suyoga.subjee.json.User;
import com.suyoga.subjee.json.UserDetails;
import com.suyoga.subjee.json.UserRegistration;
import com.suyoga.subjee.json.Userlogout;
import com.suyoga.subjee.model.SabjiPromocode;
import com.suyoga.subjee.model.SabjiUser;



public interface LoginDao {
	public Integer registration(UserRegistration userRegistration);
	public UserDetails getUser(User user);
	public void createUserSession(UserDetails userDetails);
	public Boolean getsessionDetails(String sessionId);
	
	public List<SabjiUser> getUser(String userName);
	
	public void passwordUpdate(int id,String userName,String passowrd);
	 public PasswordUpdate updatePassword(UpdatePassword updatePassword);
	 public String customerFeedback(CustomerFeedback customerFeedback);
	 public String updateDetails(UserDetails userDetails);
	 public SabjiPromocode checkPromocode(Promocode promocode);
	 public void logoutUser(Userlogout userlogout);
}
