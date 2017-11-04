package com.suyoga.subjee.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suyoga.subjee.json.Category;
import com.suyoga.subjee.json.City;
import com.suyoga.subjee.json.TimeSolt;
import com.suyoga.subjee.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/details/{cId}",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Category>>  getCategory(@PathVariable("cId") int categoryid) {
		
		 List<Category>	categoryList=new ArrayList<Category>();	
		
		 categoryList=categoryService.getCategory(categoryid);
		
		return new ResponseEntity(categoryList,HttpStatus.OK);
	}
	
	
    @RequestMapping(value="/timeSolt",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<TimeSolt>>  getTimeSolt() {
	List<JSONObject>	timeDaySolt=new ArrayList<JSONObject>();
	
	timeDaySolt=categoryService.getTimeDaySolt();
		
	return new ResponseEntity(timeDaySolt,HttpStatus.OK);	
	}
	

}
