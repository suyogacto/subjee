package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the central_trip_pickup_drops database table.
 * 
 */
@Entity
@Table(name="central_trip_pickup_drops")
@NamedQuery(name="CentralTripPickupDrop.findAll", query="SELECT c FROM CentralTripPickupDrop c")
public class CentralTripPickupDrop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="actual_drop_time")
	private Date actualDropTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="actual_pickup_time")
	private Date actualPickupTime;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="drop_location")
	private String dropLocation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="drop_time")
	private Date dropTime;

	@Column(name="extra_notes")
	private String extraNotes;

	@Column(name="pickup_location")
	private String pickupLocation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pickup_time")
	private Date pickupTime;

	private String status;

	//bi-directional many-to-one association to CentralTrip
	@ManyToOne
	@JoinColumn(name="trip_id")
	private CentralTrip centralTrip;

	public CentralTripPickupDrop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActualDropTime() {
		return this.actualDropTime;
	}

	public void setActualDropTime(Date actualDropTime) {
		this.actualDropTime = actualDropTime;
	}

	public Date getActualPickupTime() {
		return this.actualPickupTime;
	}

	public void setActualPickupTime(Date actualPickupTime) {
		this.actualPickupTime = actualPickupTime;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDropLocation() {
		return this.dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public Date getDropTime() {
		return this.dropTime;
	}

	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}

	public String getExtraNotes() {
		return this.extraNotes;
	}

	public void setExtraNotes(String extraNotes) {
		this.extraNotes = extraNotes;
	}

	public String getPickupLocation() {
		return this.pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Date getPickupTime() {
		return this.pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CentralTrip getCentralTrip() {
		return this.centralTrip;
	}

	public void setCentralTrip(CentralTrip centralTrip) {
		this.centralTrip = centralTrip;
	}

}