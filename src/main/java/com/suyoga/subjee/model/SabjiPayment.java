package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_payment database table.
 * 
 */
@Entity
@Table(name="sabji_payment")
@NamedQuery(name="SabjiPayment.findAll", query="SELECT s FROM SabjiPayment s")
public class SabjiPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_id")
	private int paymentId;

	@Lob
	@Column(name="payment_description")
	private String paymentDescription;

	@Lob
	@Column(name="payment_images")
	private String paymentImages;

	@Column(name="payment_name")
	private String paymentName;

	@Column(name="payment_ordering")
	private int paymentOrdering;

	@Lob
	@Column(name="payment_params")
	private String paymentParams;

	@Column(name="payment_published")
	private byte paymentPublished;

	@Column(name="payment_type")
	private String paymentType;

	public SabjiPayment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDescription() {
		return this.paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public String getPaymentImages() {
		return this.paymentImages;
	}

	public void setPaymentImages(String paymentImages) {
		this.paymentImages = paymentImages;
	}

	public String getPaymentName() {
		return this.paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public int getPaymentOrdering() {
		return this.paymentOrdering;
	}

	public void setPaymentOrdering(int paymentOrdering) {
		this.paymentOrdering = paymentOrdering;
	}

	public String getPaymentParams() {
		return this.paymentParams;
	}

	public void setPaymentParams(String paymentParams) {
		this.paymentParams = paymentParams;
	}

	public byte getPaymentPublished() {
		return this.paymentPublished;
	}

	public void setPaymentPublished(byte paymentPublished) {
		this.paymentPublished = paymentPublished;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}