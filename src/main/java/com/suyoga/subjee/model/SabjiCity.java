package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sabji_city database table.
 * 
 */
@Entity
@Table(name="sabji_city")
@NamedQuery(name="SabjiCity.findAll", query="SELECT s FROM SabjiCity s")
public class SabjiCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cityname;

	//bi-directional many-to-one association to SabjiLocation
	@OneToMany(mappedBy="sabjiCity")
	private List<SabjiLocation> sabjiLocations;

	public SabjiCity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public List<SabjiLocation> getSabjiLocations() {
		return this.sabjiLocations;
	}

	public void setSabjiLocations(List<SabjiLocation> sabjiLocations) {
		this.sabjiLocations = sabjiLocations;
	}

	public SabjiLocation addSabjiLocation(SabjiLocation sabjiLocation) {
		getSabjiLocations().add(sabjiLocation);
		sabjiLocation.setSabjiCity(this);

		return sabjiLocation;
	}

	public SabjiLocation removeSabjiLocation(SabjiLocation sabjiLocation) {
		getSabjiLocations().remove(sabjiLocation);
		sabjiLocation.setSabjiCity(null);

		return sabjiLocation;
	}

}