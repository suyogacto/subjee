package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the central_trip_product_map database table.
 * 
 */
@Entity
@Table(name="central_trip_product_map")
@NamedQuery(name="CentralTripProductMap.findAll", query="SELECT c FROM CentralTripProductMap c")
public class CentralTripProductMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="expected_quality")
	private String expectedQuality;

	@Column(name="expected_quantity")
	private float expectedQuantity;

	@Column(name="extra_notes")
	private String extraNotes;

	@Column(name="product_id")
	private int productId;

	@Column(name="product_quality")
	private String productQuality;

	@Column(name="product_quantity")
	private float productQuantity;

	@Column(name="product_status")
	private String productStatus;

	@Column(name="quantity_unit")
	private String quantityUnit;

	@Column(name="received_at_place")
	private String receivedAtPlace;

	@Column(name="received_from")
	private String receivedFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="received_on")
	private Date receivedOn;

	//bi-directional many-to-one association to CentralTrip
	@ManyToOne
	@JoinColumn(name="trip_id")
	private CentralTrip centralTrip;

	public CentralTripProductMap() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpectedQuality() {
		return this.expectedQuality;
	}

	public void setExpectedQuality(String expectedQuality) {
		this.expectedQuality = expectedQuality;
	}

	public float getExpectedQuantity() {
		return this.expectedQuantity;
	}

	public void setExpectedQuantity(float expectedQuantity) {
		this.expectedQuantity = expectedQuantity;
	}

	public String getExtraNotes() {
		return this.extraNotes;
	}

	public void setExtraNotes(String extraNotes) {
		this.extraNotes = extraNotes;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductQuality() {
		return this.productQuality;
	}

	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}

	public float getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(float productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getQuantityUnit() {
		return this.quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getReceivedAtPlace() {
		return this.receivedAtPlace;
	}

	public void setReceivedAtPlace(String receivedAtPlace) {
		this.receivedAtPlace = receivedAtPlace;
	}

	public String getReceivedFrom() {
		return this.receivedFrom;
	}

	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	public Date getReceivedOn() {
		return this.receivedOn;
	}

	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}

	public CentralTrip getCentralTrip() {
		return this.centralTrip;
	}

	public void setCentralTrip(CentralTrip centralTrip) {
		this.centralTrip = centralTrip;
	}

}