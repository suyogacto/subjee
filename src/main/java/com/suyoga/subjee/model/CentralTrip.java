package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the central_trip database table.
 * 
 */
@Entity
@Table(name="central_trip")
@NamedQuery(name="CentralTrip.findAll", query="SELECT c FROM CentralTrip c")
public class CentralTrip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cancel_on")
	private Date cancelOn;

	@Column(name="cancel_reason")
	private String cancelReason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pickup_date")
	private Date pickupDate;

	@Column(name="tracking_id")
	private String trackingId;

	@Column(name="trip_assigned_by")
	private int tripAssignedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="trip_assigned_on")
	private Date tripAssignedOn;

	@Column(name="trip_assigned_to")
	private int tripAssignedTo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="trip_created")
	private Date tripCreated;

	@Column(name="trip_description")
	private String tripDescription;

	@Column(name="trip_from_address")
	private String tripFromAddress;

	@Column(name="trip_from_postcode")
	private String tripFromPostcode;

	@Column(name="trip_status")
	private String tripStatus;

	@Column(name="trip_to_address")
	private String tripToAddress;

	@Column(name="trip_to_postcode")
	private String tripToPostcode;

	//bi-directional many-to-one association to CentralTripPickupDrop
	@OneToMany(mappedBy="centralTrip")
	private List<CentralTripPickupDrop> centralTripPickupDrops;

	//bi-directional many-to-one association to CentralTripProductMap
	@OneToMany(mappedBy="centralTrip")
	private List<CentralTripProductMap> centralTripProductMaps;

	//bi-directional many-to-one association to CentralTripRequest
	@OneToMany(mappedBy="centralTrip")
	private List<CentralTripRequest> centralTripRequests;

	public CentralTrip() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCancelOn() {
		return this.cancelOn;
	}

	public void setCancelOn(Date cancelOn) {
		this.cancelOn = cancelOn;
	}

	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getPickupDate() {
		return this.pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public int getTripAssignedBy() {
		return this.tripAssignedBy;
	}

	public void setTripAssignedBy(int tripAssignedBy) {
		this.tripAssignedBy = tripAssignedBy;
	}

	public Date getTripAssignedOn() {
		return this.tripAssignedOn;
	}

	public void setTripAssignedOn(Date tripAssignedOn) {
		this.tripAssignedOn = tripAssignedOn;
	}

	public int getTripAssignedTo() {
		return this.tripAssignedTo;
	}

	public void setTripAssignedTo(int tripAssignedTo) {
		this.tripAssignedTo = tripAssignedTo;
	}

	public Date getTripCreated() {
		return this.tripCreated;
	}

	public void setTripCreated(Date tripCreated) {
		this.tripCreated = tripCreated;
	}

	public String getTripDescription() {
		return this.tripDescription;
	}

	public void setTripDescription(String tripDescription) {
		this.tripDescription = tripDescription;
	}

	public String getTripFromAddress() {
		return this.tripFromAddress;
	}

	public void setTripFromAddress(String tripFromAddress) {
		this.tripFromAddress = tripFromAddress;
	}

	public String getTripFromPostcode() {
		return this.tripFromPostcode;
	}

	public void setTripFromPostcode(String tripFromPostcode) {
		this.tripFromPostcode = tripFromPostcode;
	}

	public String getTripStatus() {
		return this.tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public String getTripToAddress() {
		return this.tripToAddress;
	}

	public void setTripToAddress(String tripToAddress) {
		this.tripToAddress = tripToAddress;
	}

	public String getTripToPostcode() {
		return this.tripToPostcode;
	}

	public void setTripToPostcode(String tripToPostcode) {
		this.tripToPostcode = tripToPostcode;
	}

	public List<CentralTripPickupDrop> getCentralTripPickupDrops() {
		return this.centralTripPickupDrops;
	}

	public void setCentralTripPickupDrops(List<CentralTripPickupDrop> centralTripPickupDrops) {
		this.centralTripPickupDrops = centralTripPickupDrops;
	}

	public CentralTripPickupDrop addCentralTripPickupDrop(CentralTripPickupDrop centralTripPickupDrop) {
		getCentralTripPickupDrops().add(centralTripPickupDrop);
		centralTripPickupDrop.setCentralTrip(this);

		return centralTripPickupDrop;
	}

	public CentralTripPickupDrop removeCentralTripPickupDrop(CentralTripPickupDrop centralTripPickupDrop) {
		getCentralTripPickupDrops().remove(centralTripPickupDrop);
		centralTripPickupDrop.setCentralTrip(null);

		return centralTripPickupDrop;
	}

	public List<CentralTripProductMap> getCentralTripProductMaps() {
		return this.centralTripProductMaps;
	}

	public void setCentralTripProductMaps(List<CentralTripProductMap> centralTripProductMaps) {
		this.centralTripProductMaps = centralTripProductMaps;
	}

	public CentralTripProductMap addCentralTripProductMap(CentralTripProductMap centralTripProductMap) {
		getCentralTripProductMaps().add(centralTripProductMap);
		centralTripProductMap.setCentralTrip(this);

		return centralTripProductMap;
	}

	public CentralTripProductMap removeCentralTripProductMap(CentralTripProductMap centralTripProductMap) {
		getCentralTripProductMaps().remove(centralTripProductMap);
		centralTripProductMap.setCentralTrip(null);

		return centralTripProductMap;
	}

	public List<CentralTripRequest> getCentralTripRequests() {
		return this.centralTripRequests;
	}

	public void setCentralTripRequests(List<CentralTripRequest> centralTripRequests) {
		this.centralTripRequests = centralTripRequests;
	}

	public CentralTripRequest addCentralTripRequest(CentralTripRequest centralTripRequest) {
		getCentralTripRequests().add(centralTripRequest);
		centralTripRequest.setCentralTrip(this);

		return centralTripRequest;
	}

	public CentralTripRequest removeCentralTripRequest(CentralTripRequest centralTripRequest) {
		getCentralTripRequests().remove(centralTripRequest);
		centralTripRequest.setCentralTrip(null);

		return centralTripRequest;
	}

}