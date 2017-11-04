package com.suyoga.subjee.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyoga.subjee.dao.CategoryDao;
import com.suyoga.subjee.json.Category;
import com.suyoga.subjee.json.Time;
import com.suyoga.subjee.json.TimeSolt;

@Service
public class CategoryService {

 @Autowired
 private CategoryDao categoryDao;
 private static final DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy");
 
 public List<Category> getCategory(int categoryid) {
	 
	return  categoryDao.getCategory(categoryid);
	 
 }
	public List<JSONObject> getTimeDaySolt(){
		 DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  Date date = new Date();
		  String day=dateFormat1.format(date);
		  String time1=day.substring(10, 13);
	List<JSONObject>	timeDaySolt=new ArrayList<JSONObject>();
	  List<Time> time=new ArrayList<Time>();
	
		    Time timeslot=new Time();
		    timeslot.setMorningTime("8 AM - 11 AM");
		    timeslot.setEveningTime("4 PM - 8 PM");
		    time.add(timeslot);
	 
	 
	   Date currentDate = new Date();
       System.out.println(dateFormat.format(currentDate)+">>>>>>>>>>>>>>>>>>>"+time1);
	
   for(int i=0 ; i<4; i++){
	   JSONObject obj=new JSONObject(); 
	   Calendar c = Calendar.getInstance();
       c.setTime(currentDate);
       c.add(Calendar.DATE, i);
       Date currentDatePlusOne = c.getTime();
       
      // timeSolt.setDateDay(dateFormat.format(currentDatePlusOne).toString());
       obj.put("dateDay",dateFormat.format(currentDatePlusOne).toString());
       if(i==0 && Integer.parseInt(time1.trim()) < 15){
    	   
    	   obj.put("time", getTodayTime());    	 
    	   timeDaySolt.add(obj);
       }else if(i!=0){
    	   ///timeSolt.setTime(time); 
    	   obj.put("time", time);
    	   timeDaySolt.add(obj);
       }
       
     
   }
	
		
		
	return timeDaySolt;
	}
	
	
  public JSONArray getTodayTime(){
	  JSONArray arr = new JSONArray();  
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	  String day=dateFormat.format(date);
	  String time1=day.substring(10, 13);
	  
	  JSONObject obj=new JSONObject(); 
	  
	  Time timeslot=new Time();
	   if(Integer.parseInt(time1.trim())< 7){
		   obj.put("morningTime","8 AM - 11 AM"); 
	   }
	   
	   if(Integer.parseInt(time1.trim())< 15){
		   obj.put("eveningTime","4 PM - 8 PM");
	   }
	   arr.add(obj);
	   // time.add(timeslot);
	    
	    
  return arr;
  }

}
