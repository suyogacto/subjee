package com.suyoga.subjee.dao;

import java.util.List;

import com.suyoga.subjee.json.City;
import com.suyoga.subjee.json.LocationList;

public interface AreaDao {
	public List<City> getCityList();
	 public List<LocationList> getLocationList(int id);
}
