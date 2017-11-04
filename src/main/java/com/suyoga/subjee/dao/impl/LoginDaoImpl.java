package com.suyoga.subjee.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suyoga.subjee.controller.LoginController;
import com.suyoga.subjee.dao.LoginDao;
import com.suyoga.subjee.json.CustomerFeedback;
import com.suyoga.subjee.json.PasswordUpdate;
import com.suyoga.subjee.json.Promocode;
import com.suyoga.subjee.json.UpdatePassword;
import com.suyoga.subjee.json.User;
import com.suyoga.subjee.json.UserDetails;
import com.suyoga.subjee.json.UserRegistration;
import com.suyoga.subjee.json.Userlogout;
import com.suyoga.subjee.model.CentralProduct;
import com.suyoga.subjee.model.SabjiCustomerFeedback;
import com.suyoga.subjee.model.SabjiLocation;
import com.suyoga.subjee.model.SabjiPromocode;
import com.suyoga.subjee.model.SabjiUser;
import com.suyoga.subjee.model.SabjiUsersession;

@Repository
public class LoginDaoImpl implements LoginDao{
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);	
	 
	@Autowired
	 SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public UserDetails getUser(User user){
		
		UserDetails userDetails=new UserDetails();
		 List<SabjiUser> userList=null;
		 SabjiUser sabjiEmptyUser=null;
		 Session session = sessionFactory.openSession();
		 SabjiLocation sabjiLocation=null;
	      Transaction tx = null;
	      try {
			tx = session.beginTransaction();
			
			  Query prod2=session.createQuery("from SabjiUser where (email=:email or phoneNumber=:phoneNumber)");
				prod2.setParameter("email", user.getUsername());
				prod2.setParameter("phoneNumber", user.getUsername());
				sabjiEmptyUser=(SabjiUser) prod2.uniqueResult();				
				if(sabjiEmptyUser!=null){
					  Query prod=session.createQuery("from SabjiUser where password=:password and (email=:email or phoneNumber=:phoneNumber)");
						prod.setParameter("email", user.getUsername());
						prod.setParameter("phoneNumber", user.getUsername());
						prod.setParameter("password", user.getPassword());
						userList=prod.list();				
						for (SabjiUser sabjiUser : userList) {
							 userDetails.setId(sabjiUser.getId());
							 userDetails.setEmail(sabjiUser.getEmail());
							 userDetails.setUserName(sabjiUser.getName());
							 userDetails.setMobileNumber(sabjiUser.getPhoneNumber());
							 userDetails.setAddress(sabjiUser.getAddress());
							 userDetails.setZipcode(String.valueOf(sabjiUser.getZipcode()));
							 Query prod1=session.createQuery("from SabjiLocation where zipcode=:zipcode");
								   prod1.setParameter("zipcode", sabjiUser.getZipcode());
								   sabjiLocation=(SabjiLocation) prod1.uniqueResult();
								   if(sabjiLocation!=null && sabjiLocation.getPaymentType()!=null){
									   userDetails.setPaymentType(sabjiLocation.getPaymentType());  
									   userDetails.setMinAmount(sabjiLocation.getMinAmount());
								   }else{
									   userDetails.setPaymentType("COD");  
									   userDetails.setMinAmount(250);
								   }
						}	
				}else{
					userDetails.setMessage("UNR");
				}
				tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
			if (tx!=null) tx.rollback();
		
		}finally {
	         session.close(); 
	     }
		  
	return userDetails; 
	}
	public Integer registration(UserRegistration userRegistration){		
		Integer i=0;
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try {
			tx = session.beginTransaction();
			 List list=session.createSQLQuery("select * from sabji_users where email='"+userRegistration.getEmail()+"' or phone_number='"+userRegistration.getPhoneNubmer()+"'").list();
			
			if(list.isEmpty()){
				SabjiUser sabjiUser=new SabjiUser();
				sabjiUser.setName(userRegistration.getName());
				sabjiUser.setEmail(userRegistration.getEmail());
				sabjiUser.setPhoneNumber(userRegistration.getPhoneNubmer());
				sabjiUser.setPassword(userRegistration.getPassword());
				sabjiUser.setAddress(userRegistration.getAddress());
				sabjiUser.setUsername(userRegistration.getEmail());
				sabjiUser.setRegisterdate(new Date());
				sabjiUser.setZipcode(Integer.parseInt(userRegistration.getZipcode()));
				session.save(sabjiUser);
				i=1;
			}else{
				i=2;
			}
			
			
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i=3;
			e.printStackTrace();
			logger.warn(e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		
		}finally {
	         session.close(); 
	     }
	      
		
	return i;
	}
	public void createUserSession(UserDetails userDetails){
		
		 Session session = sessionFactory.openSession();
	     Transaction tx = null;
	     try {
		tx = session.beginTransaction();
		
		session.createSQLQuery("delete from sabji_usersession where userid="+userDetails.getMobileNumber()).executeUpdate();
		
		SabjiUsersession sabjiUsersession=new SabjiUsersession();
		sabjiUsersession.setDeviceBadge(0);
		sabjiUsersession.setDeviceToken(userDetails.getEmail());
		sabjiUsersession.setSessionid(userDetails.getSessionId());
		sabjiUsersession.setUserid(new BigInteger(userDetails.getMobileNumber()));
		////sabjiUsersession.setTimestamp(new );
		session.save(sabjiUsersession);
		tx.commit();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
			if (tx!=null) tx.rollback();
		
		}finally {
	         session.close(); 
	     }
	}
    public Boolean getsessionDetails(String sessionId){
		 
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      Boolean sessionDetails=false;
	      try {
				tx = session.beginTransaction();
				
				List sessionList=session.createSQLQuery("select * from sabji_usersession where sessionid='"+sessionId+"'").list();
				if(sessionList!=null && !sessionList.isEmpty()){
					sessionDetails=true;
				}else{
					sessionDetails=false;	
				}
				tx.commit();
	      } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if (tx!=null) tx.rollback();
				logger.warn(e.getMessage());
			}finally {
		         session.close(); 
		     }
		 return sessionDetails;
	 }
    
    public List<SabjiUser> getUser(String userName){
   	 List<SabjiUser> userList=null;
	 Session session = sessionFactory.openSession();
      Transaction tx = null;
      
  	  try {
		tx = session.beginTransaction();
		  Query prod=session.createQuery("from SabjiUser where (email=:email or phoneNumber=:phoneNumber)");
			prod.setParameter("email", userName);
			prod.setParameter("phoneNumber", userName);			
			userList=prod.list();
			tx.commit();
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		if (tx!=null) tx.rollback();
		logger.warn(e.getMessage());
	}finally {
         session.close(); 
     }
		return userList;
    }
    public void passwordUpdate(int id,String userName,String passowrd){
    	 Session session = sessionFactory.openSession();
         Transaction tx = null;
         try {
			tx = session.beginTransaction();
			  session.createSQLQuery("update sabji_users set password='"+passowrd+"' where id="+id+"").executeUpdate();
			 tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
			if (tx!=null) tx.rollback();
			
		}finally {
	         session.close(); 
	     }
    }
    public PasswordUpdate updatePassword(UpdatePassword updatePassword){
    	PasswordUpdate passwordUpdate=new PasswordUpdate();
    	 Session session = sessionFactory.openSession();
         Transaction tx = null;
         try {
			tx = session.beginTransaction();
			List list=session.createSQLQuery("select * from sabji_users where phone_number="+updatePassword.getMobileNumber()+" and password='"+updatePassword.getOldPassword()+"'").list();
			if(!list.isEmpty()){
				 session.createSQLQuery("update sabji_users set password='"+updatePassword.getNewPassword()+"' where phone_number="+updatePassword.getMobileNumber()+" ").executeUpdate();	
				 passwordUpdate.setPasswordStatus("success");
			}else{
				passwordUpdate.setPasswordStatus("failure");				
			}
			tx.commit();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			logger.warn(e.getMessage());
 			if (tx!=null) tx.rollback();
 			
 		}finally {
 	         session.close(); 
 	     }
    	return passwordUpdate;
    }
    public String customerFeedback(CustomerFeedback customerFeedback){
    	String message="";
    	 Session session = sessionFactory.openSession();
         Transaction tx = null;
         
         try {
			tx = session.beginTransaction();
			 SabjiCustomerFeedback sabjiCustomerFeedback=new SabjiCustomerFeedback();
			 sabjiCustomerFeedback.setFeedback(customerFeedback.getFeedback());
			 sabjiCustomerFeedback.setMobileNumber(customerFeedback.getMobileNumber());
			 sabjiCustomerFeedback.setUserName(customerFeedback.getMobileNumber());
			 ////sabjiCustomerFeedback.setDate(new Date());
			 session.save(sabjiCustomerFeedback);			 
			 tx.commit();
			 message="Thanks For your support";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
         if (tx!=null) tx.rollback();
         message="Thanks For your support"; 			
 		}finally {
 	         session.close(); 
 	     }
    	
    	return message;
    }
    
    public String updateDetails(UserDetails userDetails){
    String message="";
	Session session = sessionFactory.openSession();
	Transaction tx = null;
	SabjiUser sabjiUser=null;
    try {    
    	tx = session.beginTransaction();
    	 Query prod2=session.createQuery("from SabjiUser where id=:id ");
			prod2.setParameter("id", userDetails.getId());			
			sabjiUser=(SabjiUser) prod2.uniqueResult();
			sabjiUser.setAddress(userDetails.getAddress());
			sabjiUser.setPhoneNumber(userDetails.getMobileNumber());   
			sabjiUser.setEmail(userDetails.getEmail());
			sabjiUser.setZipcode(Integer.parseInt(userDetails.getZipcode()));
			session.save(sabjiUser);		
		tx.commit();
		message="update";
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		logger.warn(e.getMessage());
		message="Error";
		if (tx!=null) tx.rollback();
       		
		}finally {
	         session.close(); 
	     }	
    return message;	
    }
    public SabjiPromocode checkPromocode(Promocode promocode){
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	
    	SabjiPromocode sabjiPromocode=null;
    	try {
		   tx = session.beginTransaction();
		   Query prod=session.createQuery("from SabjiPromocode where promoCode=:promoCode and city=:city ");
			prod.setParameter("promoCode", promocode.getPromoCode());
			prod.setParameter("city", promocode.getCity());			
			sabjiPromocode=(SabjiPromocode) prod.uniqueResult();
		   tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
		}finally {
	       session.close(); 
		}
    return sabjiPromocode;
    }
    public void logoutUser(Userlogout userlogout){
    	 Session session = sessionFactory.openSession();
	     Transaction tx = null;
	     int count=0;
	     try {
		tx = session.beginTransaction();
		
		count=session.createSQLQuery("delete from sabji_usersession where sessionid='"+userlogout.getSessionid().trim()+"'").executeUpdate();
		tx.commit();
		} catch (Exception e) {
				// TODO Auto-generated catch block
		 e.printStackTrace();
		 logger.warn(e.getMessage());
		}finally {
		  session.close(); 
		}
	     
	  }
}
