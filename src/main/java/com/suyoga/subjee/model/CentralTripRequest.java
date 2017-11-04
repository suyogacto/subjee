package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the central_trip_request database table.
 * 
 */
@Entity
@Table(name="central_trip_request")
@NamedQuery(name="CentralTripRequest.findAll", query="SELECT c FROM CentralTripRequest c")
public class CentralTripRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte assigned;

	@Column(name="cancel_by")
	private String cancelBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cancel_on")
	private Date cancelOn;

	@Column(name="cancel_reason")
	private String cancelReason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_received")
	private Date requestReceived;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_send")
	private Date requestSend;

	@Column(name="transport_user_id")
	private int transportUserId;

	@Column(name="user_accepted")
	private byte userAccepted;

	//bi-directional many-to-one association to CentralTrip
	@ManyToOne
	@JoinColumn(name="trip_id")
	private CentralTrip centralTrip;

	public CentralTripRequest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAssigned() {
		return this.assigned;
	}

	public void setAssigned(byte assigned) {
		this.assigned = assigned;
	}

	public String getCancelBy() {
		return this.cancelBy;
	}

	public void setCancelBy(String cancelBy) {
		this.cancelBy = cancelBy;
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

	public Date getRequestReceived() {
		return this.requestReceived;
	}

	public void setRequestReceived(Date requestReceived) {
		this.requestReceived = requestReceived;
	}

	public Date getRequestSend() {
		return this.requestSend;
	}

	public void setRequestSend(Date requestSend) {
		this.requestSend = requestSend;
	}

	public int getTransportUserId() {
		return this.transportUserId;
	}

	public void setTransportUserId(int transportUserId) {
		this.transportUserId = transportUserId;
	}

	public byte getUserAccepted() {
		return this.userAccepted;
	}

	public void setUserAccepted(byte userAccepted) {
		this.userAccepted = userAccepted;
	}

	public CentralTrip getCentralTrip() {
		return this.centralTrip;
	}

	public void setCentralTrip(CentralTrip centralTrip) {
		this.centralTrip = centralTrip;
	}

}