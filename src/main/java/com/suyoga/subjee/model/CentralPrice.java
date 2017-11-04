package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the central_price database table.
 * 
 */
@Entity
@Table(name="central_price")
@NamedQuery(name="CentralPrice.findAll", query="SELECT c FROM CentralPrice c")
public class CentralPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="price_id")
	private int priceId;

	@Column(name="price_min_quantity")
	private int priceMinQuantity;

	@Column(name="price_value")
	private BigDecimal priceValue;

	//bi-directional many-to-one association to CentralProduct
	@ManyToOne
	@JoinColumn(name="price_product_id")
	private CentralProduct centralProduct;

	public CentralPrice() {
	}

	public int getPriceId() {
		return this.priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getPriceMinQuantity() {
		return this.priceMinQuantity;
	}

	public void setPriceMinQuantity(int priceMinQuantity) {
		this.priceMinQuantity = priceMinQuantity;
	}

	public BigDecimal getPriceValue() {
		return this.priceValue;
	}

	public void setPriceValue(BigDecimal priceValue) {
		this.priceValue = priceValue;
	}

	public CentralProduct getCentralProduct() {
		return this.centralProduct;
	}

	public void setCentralProduct(CentralProduct centralProduct) {
		this.centralProduct = centralProduct;
	}

}