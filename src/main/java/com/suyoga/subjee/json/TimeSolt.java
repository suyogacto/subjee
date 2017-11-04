package com.suyoga.subjee.json;

import java.util.ArrayList;
import java.util.List;

public class TimeSolt {	
  public String dateDay;  
  List<Time> time=new ArrayList<Time>();
  
	public String getDateDay() {
		return dateDay;
	}
	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}
	public List<Time> getTime() {
		return time;
	}
	public void setTime(List<Time> time) {
		this.time = time;
	}

}
