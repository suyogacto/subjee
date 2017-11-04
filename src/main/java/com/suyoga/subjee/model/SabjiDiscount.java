package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sabji_discount database table.
 * 
 */
@Entity
@Table(name="sabji_discount")
@NamedQuery(name="SabjiDiscount.findAll", query="SELECT s FROM SabjiDiscount s")
public class SabjiDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="discount_id")
	private int discountId;

	@Column(name="discount_catagory_id")
	private String discountCatagoryId;

	@Column(name="discount_code")
	private String discountCode;

	@Column(name="discount_end")
	private int discountEnd;

	@Column(name="discount_flat_amount")
	private BigDecimal discountFlatAmount;

	@Column(name="discount_minimum_order")
	private BigDecimal discountMinimumOrder;

	@Column(name="discount_percent_amount")
	private BigDecimal discountPercentAmount;

	@Column(name="discount_product_id")
	private String discountProductId;

	@Column(name="discount_published")
	private byte discountPublished;

	@Column(name="discount_quota")
	private int discountQuota;

	@Column(name="discount_quota_per_user")
	private int discountQuotaPerUser;

	@Column(name="discount_start")
	private int discountStart;

	@Column(name="discount_type")
	private String discountType;

	@Column(name="discount_used_times")
	private int discountUsedTimes;

	public SabjiDiscount() {
	}

	public int getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountCatagoryId() {
		return this.discountCatagoryId;
	}

	public void setDiscountCatagoryId(String discountCatagoryId) {
		this.discountCatagoryId = discountCatagoryId;
	}

	public String getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public int getDiscountEnd() {
		return this.discountEnd;
	}

	public void setDiscountEnd(int discountEnd) {
		this.discountEnd = discountEnd;
	}

	public BigDecimal getDiscountFlatAmount() {
		return this.discountFlatAmount;
	}

	public void setDiscountFlatAmount(BigDecimal discountFlatAmount) {
		this.discountFlatAmount = discountFlatAmount;
	}

	public BigDecimal getDiscountMinimumOrder() {
		return this.discountMinimumOrder;
	}

	public void setDiscountMinimumOrder(BigDecimal discountMinimumOrder) {
		this.discountMinimumOrder = discountMinimumOrder;
	}

	public BigDecimal getDiscountPercentAmount() {
		return this.discountPercentAmount;
	}

	public void setDiscountPercentAmount(BigDecimal discountPercentAmount) {
		this.discountPercentAmount = discountPercentAmount;
	}

	public String getDiscountProductId() {
		return this.discountProductId;
	}

	public void setDiscountProductId(String discountProductId) {
		this.discountProductId = discountProductId;
	}

	public byte getDiscountPublished() {
		return this.discountPublished;
	}

	public void setDiscountPublished(byte discountPublished) {
		this.discountPublished = discountPublished;
	}

	public int getDiscountQuota() {
		return this.discountQuota;
	}

	public void setDiscountQuota(int discountQuota) {
		this.discountQuota = discountQuota;
	}

	public int getDiscountQuotaPerUser() {
		return this.discountQuotaPerUser;
	}

	public void setDiscountQuotaPerUser(int discountQuotaPerUser) {
		this.discountQuotaPerUser = discountQuotaPerUser;
	}

	public int getDiscountStart() {
		return this.discountStart;
	}

	public void setDiscountStart(int discountStart) {
		this.discountStart = discountStart;
	}

	public String getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public int getDiscountUsedTimes() {
		return this.discountUsedTimes;
	}

	public void setDiscountUsedTimes(int discountUsedTimes) {
		this.discountUsedTimes = discountUsedTimes;
	}

}