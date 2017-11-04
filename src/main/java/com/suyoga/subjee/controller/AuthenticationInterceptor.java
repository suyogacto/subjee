package com.suyoga.subjee.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContext;

import com.suyoga.subjee.dao.impl.LoginDaoImpl;
import com.suyoga.subjee.services.LoginService;
import com.suyoga.subjee.util.UrlValidation;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private LoginService loginService;
	
	 public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
	 public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
	 public static final String METHODS_NAME = "Access-Control-Allow-Methods";
	 public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
	 public static final String MAX_AGE_NAME = "Access-Control-Max-Age";
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//// final HttpSession session = webRequest.getSession();
		  response.setHeader(CREDENTIALS_NAME, "true");
		  response.setHeader(ORIGIN_NAME, "http://192.168.1.19:8080");
		  response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
		  response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
		  response.setHeader(MAX_AGE_NAME, "3600");
		  
		  
		String sessionId = null;
		String uri = request.getRequestURI();

		sessionId = request.getHeader("sessionId");
		if (validateUser(uri)) {
			if(sessionId!=null && !sessionId.equalsIgnoreCase("null")){
						
			
			try {
				HttpSession session = null;
				ServletContext ctx = null;
				UserDetails userDetails = null;
				ctx = request.getSession().getServletContext();
				if(ctx.getAttribute(sessionId)!= null) {
					return true;
				}else{	
				 Boolean sessionDetails=false;
			
				 sessionDetails=loginService.getsessionDetails(sessionId);	
				 if(sessionDetails){
					 return true; 
				 }else{
					 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not authorized to access it");
					 return false;
				 }
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not authorized to access it");
				return false;
			}
			}else{
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not authorized to access it");
				return false;
			}

		}

		return true;
	}

	public boolean validateUser(String url) {
		String [] uriDetails=url.split("/");
		String s1=uriDetails[1].toString();
		String s2=uriDetails[2].toString();
		String s3=uriDetails[3].toString();
		url="/"+s1+"/"+s2+"/"+s3;
		Map<String, Boolean> urlDetails = new HashMap<String, Boolean>();

		urlDetails = UrlValidation.getInstance();

		return urlDetails.get(url);

	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			/*	response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
				response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");*/		
		    /*response.addHeader("Access-Control-Allow-Origin", "*");
		    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		    response.addHeader("Access-Control-Max-Age", "3600");
		    response.addHeader("Access-Control-Allow-Headers", "x-requested-with");*/
		   
		/*System.out.println("Request URL::" + request.getRequestURL().toString()
				+ " Sent to Handler :: Current Time=" + System.currentTimeMillis());*/
		//we can add attributes in the modelAndView and use that in the view page
	}
	

}
