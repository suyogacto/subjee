package com.suyoga.subjee.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sabji_usersession database table.
 * 
 */
@Entity
@Table(name="sabji_usersession")
@NamedQuery(name="SabjiUsersession.findAll", query="SELECT s FROM SabjiUsersession s")
public class SabjiUsersession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int deviceBadge;

	private String deviceToken;

	private String sessionid;

	private Timestamp timestamp;

	private BigInteger userid;

	public SabjiUsersession() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeviceBadge() {
		return this.deviceBadge;
	}

	public void setDeviceBadge(int deviceBadge) {
		this.deviceBadge = deviceBadge;
	}

	public String getDeviceToken() {
		return this.deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public BigInteger getUserid() {
		return userid;
	}

	public void setUserid(BigInteger userid) {
		this.userid = userid;
	}



}