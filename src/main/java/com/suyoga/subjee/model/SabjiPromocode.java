package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sabji_promocode database table.
 * 
 */
@Entity
@Table(name="sabji_promocode")
@NamedQuery(name="SabjiPromocode.findAll", query="SELECT s FROM SabjiPromocode s")
public class SabjiPromocode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="promo_id")
	private int promoId;

	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	private BigDecimal minamount;
	
	private BigDecimal maxAmount;

	@Column(name="per_user")
	private int perUser;

	private int percentage;

	@Column(name="promo_code")
	private String promoCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	private BigDecimal totalAmount;

	private int zipcode;

	public SabjiPromocode() {
	}

	public int getPromoId() {
		return this.promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getMinamount() {
		return this.minamount;
	}

	public void setMinamount(BigDecimal minamount) {
		this.minamount = minamount;
	}

	public int getPerUser() {
		return this.perUser;
	}

	public void setPerUser(int perUser) {
		this.perUser = perUser;
	}

	public int getPercentage() {
		return this.percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

}