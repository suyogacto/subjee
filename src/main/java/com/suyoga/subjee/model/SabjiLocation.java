package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_location database table.
 * 
 */
@Entity
@Table(name="sabji_location")
@NamedQuery(name="SabjiLocation.findAll", query="SELECT s FROM SabjiLocation s")
public class SabjiLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name="minAmount")
	private int minAmount;
	
	@Column(name="deliveryCharges")
	private int deliveryCharges;

	private String locationname;

	private int zipcode;
	
    @Column(name="paymentType")
	private String paymentType;

	//bi-directional many-to-one association to SabjiCity
	@ManyToOne
	@JoinColumn(name="cityid")
	private SabjiCity sabjiCity;

	public SabjiLocation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationname() {
		return this.locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public SabjiCity getSabjiCity() {
		return this.sabjiCity;
	}

	public void setSabjiCity(SabjiCity sabjiCity) {
		this.sabjiCity = sabjiCity;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

}