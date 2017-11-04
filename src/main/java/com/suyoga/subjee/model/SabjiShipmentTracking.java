package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sabji_shipment_tracking database table.
 * 
 */
@Entity
@Table(name="sabji_shipment_tracking")
@NamedQuery(name="SabjiShipmentTracking.findAll", query="SELECT s FROM SabjiShipmentTracking s")
public class SabjiShipmentTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String event;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="event_time")
	private Date eventTime;

	@Column(name="tracking_id")
	private String trackingId;

	public SabjiShipmentTracking() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

}