package com.suyoga.subjee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyoga.subjee.dao.AreaDao;
import com.suyoga.subjee.json.City;
import com.suyoga.subjee.json.LocationList;

@Service
public class AreaService {
	@Autowired
	private AreaDao areaDao;
	
 public List<City> getCityList(){
	
	 List<City>	cityList=new ArrayList<City>();
	 
	 
	 cityList=areaDao.getCityList();
	 
	 return cityList;
 }
 public List<LocationList> getLocationList(int id){
		
	 List<LocationList>	locationListList=new ArrayList<LocationList>();
	 
	 
	 locationListList=areaDao.getLocationList(id);
	 
	 return locationListList;
 }
	
}
