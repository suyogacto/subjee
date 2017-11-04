package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sabji_service_areas database table.
 * 
 */
@Entity
@Table(name="sabji_service_areas")
@NamedQuery(name="SabjiServiceArea.findAll", query="SELECT s FROM SabjiServiceArea s")
public class SabjiServiceArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="area_name")
	private String areaName;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String postcode;

	public SabjiServiceArea() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}