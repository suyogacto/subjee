package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the central_category database table.
 * 
 */
@Entity
@Table(name="central_category")
@NamedQuery(name="CentralCategory.findAll", query="SELECT c FROM CentralCategory c")
public class CentralCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="category_created")
	private int categoryCreated;

	@Lob
	@Column(name="category_description")
	private String categoryDescription;

	@Column(name="category_modified")
	private int categoryModified;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="category_ordering")
	private int categoryOrdering;

	@Column(name="category_parent_id")
	private int categoryParentId;

	@Column(name="category_published")
	private int categoryPublished;

	//bi-directional many-to-one association to CentralSubcategory
	@OneToMany(mappedBy="centralCategory")
	@OrderBy("priority DESC")
	private List<CentralSubcategory> centralSubcategories;
	
	@Column(name="priority")
	private int priority;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public CentralCategory() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryCreated() {
		return this.categoryCreated;
	}

	public void setCategoryCreated(int categoryCreated) {
		this.categoryCreated = categoryCreated;
	}

	public String getCategoryDescription() {
		return this.categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public int getCategoryModified() {
		return this.categoryModified;
	}

	public void setCategoryModified(int categoryModified) {
		this.categoryModified = categoryModified;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryOrdering() {
		return this.categoryOrdering;
	}

	public void setCategoryOrdering(int categoryOrdering) {
		this.categoryOrdering = categoryOrdering;
	}

	public int getCategoryParentId() {
		return this.categoryParentId;
	}

	public void setCategoryParentId(int categoryParentId) {
		this.categoryParentId = categoryParentId;
	}

	public int getCategoryPublished() {
		return this.categoryPublished;
	}

	public void setCategoryPublished(int categoryPublished) {
		this.categoryPublished = categoryPublished;
	}

	public List<CentralSubcategory> getCentralSubcategories() {
		return this.centralSubcategories;
	}

	public void setCentralSubcategories(List<CentralSubcategory> centralSubcategories) {
		this.centralSubcategories = centralSubcategories;
	}

	public CentralSubcategory addCentralSubcategory(CentralSubcategory centralSubcategory) {
		getCentralSubcategories().add(centralSubcategory);
		centralSubcategory.setCentralCategory(this);

		return centralSubcategory;
	}

	public CentralSubcategory removeCentralSubcategory(CentralSubcategory centralSubcategory) {
		getCentralSubcategories().remove(centralSubcategory);
		centralSubcategory.setCentralCategory(null);

		return centralSubcategory;
	}

}