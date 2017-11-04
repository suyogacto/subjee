package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the central_product_category database table.
 * 
 */
@Entity
@Table(name="central_product_category")
@NamedQuery(name="CentralProductCategory.findAll", query="SELECT c FROM CentralProductCategory c")
public class CentralProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_category_id")
	private int productCategoryId;

	private int ordering;

	//bi-directional many-to-one association to CentralCategory
	@ManyToOne
	@JoinColumn(name="category_id")
	private CentralCategory centralCategory;

	//bi-directional many-to-one association to CentralProduct
	@ManyToOne
	@JoinColumn(name="product_id")
	private CentralProduct centralProduct;

	public CentralProductCategory() {
	}

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public int getOrdering() {
		return this.ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	public CentralCategory getCentralCategory() {
		return this.centralCategory;
	}

	public void setCentralCategory(CentralCategory centralCategory) {
		this.centralCategory = centralCategory;
	}

	public CentralProduct getCentralProduct() {
		return this.centralProduct;
	}

	public void setCentralProduct(CentralProduct centralProduct) {
		this.centralProduct = centralProduct;
	}

}