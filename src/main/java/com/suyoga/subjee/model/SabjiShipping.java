package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sabji_shipping database table.
 * 
 */
@Entity
@Table(name="sabji_shipping")
@NamedQuery(name="SabjiShipping.findAll", query="SELECT s FROM SabjiShipping s")
public class SabjiShipping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="shipping_id")
	private int shippingId;

	@Lob
	@Column(name="shipping_description")
	private String shippingDescription;

	@Column(name="shipping_images")
	private String shippingImages;

	@Column(name="shipping_name")
	private String shippingName;

	@Column(name="shipping_ordering")
	private int shippingOrdering;

	@Lob
	@Column(name="shipping_params")
	private String shippingParams;

	@Column(name="shipping_price")
	private BigDecimal shippingPrice;

	@Column(name="shipping_published")
	private byte shippingPublished;

	@Column(name="shipping_type")
	private String shippingType;

	public SabjiShipping() {
	}

	public int getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingDescription() {
		return this.shippingDescription;
	}

	public void setShippingDescription(String shippingDescription) {
		this.shippingDescription = shippingDescription;
	}

	public String getShippingImages() {
		return this.shippingImages;
	}

	public void setShippingImages(String shippingImages) {
		this.shippingImages = shippingImages;
	}

	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public int getShippingOrdering() {
		return this.shippingOrdering;
	}

	public void setShippingOrdering(int shippingOrdering) {
		this.shippingOrdering = shippingOrdering;
	}

	public String getShippingParams() {
		return this.shippingParams;
	}

	public void setShippingParams(String shippingParams) {
		this.shippingParams = shippingParams;
	}

	public BigDecimal getShippingPrice() {
		return this.shippingPrice;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public byte getShippingPublished() {
		return this.shippingPublished;
	}

	public void setShippingPublished(byte shippingPublished) {
		this.shippingPublished = shippingPublished;
	}

	public String getShippingType() {
		return this.shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

}