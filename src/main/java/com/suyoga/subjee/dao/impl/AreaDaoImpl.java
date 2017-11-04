package com.suyoga.subjee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suyoga.subjee.dao.AreaDao;
import com.suyoga.subjee.json.City;
import com.suyoga.subjee.json.LocationList;
import com.suyoga.subjee.model.SabjiCity;
import com.suyoga.subjee.model.SabjiLocation;

@Repository
public class AreaDaoImpl implements AreaDao{
	private static final Logger logger = Logger.getLogger(AreaDaoImpl.class);
	@Autowired
	 SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<City> getCityList(){
		List<City>	cityList=new ArrayList<City>();
		Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      List<SabjiCity> list =null;
	      try {
			tx = session.beginTransaction();
			
			list=session.createQuery("from SabjiCity").list();
			
			for (SabjiCity sabjiCity : list) {
				City city=new City();
				city.setId(sabjiCity.getId());
				city.setCityName(sabjiCity.getCityname());
				cityList.add(city);
			}			
			
		   tx.commit();		  
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			logger.warn(e.getMessage());
		}finally {
	         session.close(); 
	     }
		
		return cityList;
	}
	
	 public List<LocationList> getLocationList(int id){
		 List<LocationList>	locationListList=new ArrayList<LocationList>();
		 
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      List<SabjiLocation> list =null;
	      try {
			tx = session.beginTransaction();
			Query q=session.createQuery("from SabjiLocation where cityid=:id");
			q.setParameter("id", id);
			
			list=q.list();
			for (SabjiLocation sabjiLocation : list) {
				LocationList locationList=new LocationList();
				locationList.setId(sabjiLocation.getId());
				locationList.setLocationName(sabjiLocation.getZipcode());
				locationListList.add(locationList);
			}	
			
		   tx.commit();		  
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			logger.warn(e.getMessage());
		}finally {
	         session.close(); 
	     }		 
		 
		 return locationListList;
	 }
	 
	
}
