package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the central_trip_invoice database table.
 * 
 */
@Entity
@Table(name="central_trip_invoice")
@NamedQuery(name="CentralTripInvoice.findAll", query="SELECT c FROM CentralTripInvoice c")
public class CentralTripInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="base_fare")
	private float baseFare;

	@Column(name="google_map_snapshot")
	private String googleMapSnapshot;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invoice_date")
	private Date invoiceDate;

	@Column(name="invoice_number")
	private String invoiceNumber;

	@Column(name="invoice_status")
	private String invoiceStatus;

	@Column(name="total_price")
	private float totalPrice;

	@Column(name="transport_user_id")
	private int transportUserId;

	@Column(name="trip_distance")
	private int tripDistance;

	@Column(name="trip_duration")
	private String tripDuration;

	@Column(name="trip_id")
	private int tripId;

	public CentralTripInvoice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBaseFare() {
		return this.baseFare;
	}

	public void setBaseFare(float baseFare) {
		this.baseFare = baseFare;
	}

	public String getGoogleMapSnapshot() {
		return this.googleMapSnapshot;
	}

	public void setGoogleMapSnapshot(String googleMapSnapshot) {
		this.googleMapSnapshot = googleMapSnapshot;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTransportUserId() {
		return this.transportUserId;
	}

	public void setTransportUserId(int transportUserId) {
		this.transportUserId = transportUserId;
	}

	public int getTripDistance() {
		return this.tripDistance;
	}

	public void setTripDistance(int tripDistance) {
		this.tripDistance = tripDistance;
	}

	public String getTripDuration() {
		return this.tripDuration;
	}

	public void setTripDuration(String tripDuration) {
		this.tripDuration = tripDuration;
	}

	public int getTripId() {
		return this.tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

}