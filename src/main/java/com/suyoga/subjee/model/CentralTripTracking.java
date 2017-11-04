package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the central_trip_tracking database table.
 * 
 */
@Entity
@Table(name="central_trip_tracking")
@NamedQuery(name="CentralTripTracking.findAll", query="SELECT c FROM CentralTripTracking c")
public class CentralTripTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String event;

	@Column(name="event_location")
	private String eventLocation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="event_time")
	private Date eventTime;

	@Column(name="extra_notes")
	private String extraNotes;

	@Column(name="tracking_id")
	private String trackingId;

	public CentralTripTracking() {
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

	public String getEventLocation() {
		return this.eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Date getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getExtraNotes() {
		return this.extraNotes;
	}

	public void setExtraNotes(String extraNotes) {
		this.extraNotes = extraNotes;
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

}