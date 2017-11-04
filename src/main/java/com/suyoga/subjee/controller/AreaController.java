package com.suyoga.subjee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suyoga.subjee.json.City;
import com.suyoga.subjee.json.CityDetails;
import com.suyoga.subjee.json.LocationList;
import com.suyoga.subjee.services.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/city",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<City>> getCity() {
	 List<City>	cityList=new ArrayList<City>();		
	 cityList=areaService.getCityList();

	 return new ResponseEntity(cityList,HttpStatus.OK);
	}
	@RequestMapping(value="/location",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<LocationList>> getLocation(@RequestParam("id") int id) {
	 List<LocationList>	locationListList=new ArrayList<LocationList>();
		
	 locationListList=areaService.getLocationList(id);

	 return new ResponseEntity(locationListList,HttpStatus.OK);
	}
}
