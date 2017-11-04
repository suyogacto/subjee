package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the central_subcategory database table.
 * 
 */
@Entity
@Table(name="central_subcategory")
@NamedQuery(name="CentralSubcategory.findAll", query="SELECT c FROM CentralSubcategory c")
public class CentralSubcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subcategory_id")
	private int subcategoryId;

	@Lob
	@Column(name="subcategory_description")
	private String subcategoryDescription;

	@Column(name="subcategory_name")
	private String subcategoryName;
	
	@Column(name="priority")
	private int priority;

	//bi-directional many-to-one association to CentralCategory
	@ManyToOne
	@JoinColumn(name="category_id")
	private CentralCategory centralCategory;

	public CentralSubcategory() {
	}

	public int getSubcategoryId() {
		return this.subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryDescription() {
		return this.subcategoryDescription;
	}

	public void setSubcategoryDescription(String subcategoryDescription) {
		this.subcategoryDescription = subcategoryDescription;
	}

	public String getSubcategoryName() {
		return this.subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public CentralCategory getCentralCategory() {
		return this.centralCategory;
	}

	public void setCentralCategory(CentralCategory centralCategory) {
		this.centralCategory = centralCategory;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}