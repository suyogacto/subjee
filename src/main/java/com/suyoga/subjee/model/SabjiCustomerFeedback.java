package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_customer_feedback database table.
 * 
 */
@Entity
@Table(name="sabji_customer_feedback")
@NamedQuery(name="SabjiCustomerFeedback.findAll", query="SELECT s FROM SabjiCustomerFeedback s")
public class SabjiCustomerFeedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String date;

	@Lob
	private String feedback;

	private String mobileNumber;

	private String userName;

	public SabjiCustomerFeedback() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}