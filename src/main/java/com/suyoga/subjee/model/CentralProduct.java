package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the central_product database table.
 * 
 */
@Entity
@Table(name="central_product")
@NamedQuery(name="CentralProduct.findAll", query="SELECT c FROM CentralProduct c")
public class CentralProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	@Column(name="product_brand")
	private String productBrand;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_contact")
	private short productContact;

	@Column(name="product_created")
	private int productCreated;

	@Lob
	@Column(name="product_description")
	private String productDescription;

	@Column(name="product_dimension_unit")
	private String productDimensionUnit;

	@Column(name="product_height")
	private BigDecimal productHeight;

	@Column(name="product_length")
	private BigDecimal productLength;

	@Column(name="product_modified")
	private int productModified;

	@Column(name="product_msrp")
	private BigDecimal productMsrp;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_published")
	private byte productPublished;

	@Column(name="product_quantity")
	private int productQuantity;

	@Column(name="product_sale_end")
	private int productSaleEnd;

	@Column(name="product_sale_start")
	private int productSaleStart;

	@Column(name="product_type")
	private String productType;

	@Column(name="product_vendor")
	private String productVendor;

	@Column(name="product_weight")
	private BigDecimal productWeight;

	@Column(name="product_weight_unit")
	private String productWeightUnit;

	@Column(name="product_width")
	private BigDecimal productWidth;

	//bi-directional many-to-one association to CentralFile
	@OneToMany(mappedBy="centralProduct")
	private List<CentralFile> centralFiles;

	//bi-directional many-to-one association to CentralPrice
	@OneToMany(mappedBy="centralProduct")
	private List<CentralPrice> centralPrices;

	//bi-directional many-to-one association to CentralProductCategory
	@OneToMany(mappedBy="centralProduct")
	private List<CentralProductCategory> centralProductCategories;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="subcategory_id")
	private int subcategoryId;
	
	@Column(name="brand_name")
	private String brandname;		

	public CentralProduct() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductBrand() {
		return this.productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public short getProductContact() {
		return this.productContact;
	}

	public void setProductContact(short productContact) {
		this.productContact = productContact;
	}

	public int getProductCreated() {
		return this.productCreated;
	}

	public void setProductCreated(int productCreated) {
		this.productCreated = productCreated;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductDimensionUnit() {
		return this.productDimensionUnit;
	}

	public void setProductDimensionUnit(String productDimensionUnit) {
		this.productDimensionUnit = productDimensionUnit;
	}

	public BigDecimal getProductHeight() {
		return this.productHeight;
	}

	public void setProductHeight(BigDecimal productHeight) {
		this.productHeight = productHeight;
	}

	public BigDecimal getProductLength() {
		return this.productLength;
	}

	public void setProductLength(BigDecimal productLength) {
		this.productLength = productLength;
	}

	public int getProductModified() {
		return this.productModified;
	}

	public void setProductModified(int productModified) {
		this.productModified = productModified;
	}

	public BigDecimal getProductMsrp() {
		return this.productMsrp;
	}

	public void setProductMsrp(BigDecimal productMsrp) {
		this.productMsrp = productMsrp;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public byte getProductPublished() {
		return this.productPublished;
	}

	public void setProductPublished(byte productPublished) {
		this.productPublished = productPublished;
	}

	public int getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductSaleEnd() {
		return this.productSaleEnd;
	}

	public void setProductSaleEnd(int productSaleEnd) {
		this.productSaleEnd = productSaleEnd;
	}

	public int getProductSaleStart() {
		return this.productSaleStart;
	}

	public void setProductSaleStart(int productSaleStart) {
		this.productSaleStart = productSaleStart;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductVendor() {
		return this.productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public BigDecimal getProductWeight() {
		return this.productWeight;
	}

	public void setProductWeight(BigDecimal productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductWeightUnit() {
		return this.productWeightUnit;
	}

	public void setProductWeightUnit(String productWeightUnit) {
		this.productWeightUnit = productWeightUnit;
	}

	public BigDecimal getProductWidth() {
		return this.productWidth;
	}

	public void setProductWidth(BigDecimal productWidth) {
		this.productWidth = productWidth;
	}

	public List<CentralFile> getCentralFiles() {
		return this.centralFiles;
	}

	public void setCentralFiles(List<CentralFile> centralFiles) {
		this.centralFiles = centralFiles;
	}

	public CentralFile addCentralFile(CentralFile centralFile) {
		getCentralFiles().add(centralFile);
		centralFile.setCentralProduct(this);

		return centralFile;
	}

	public CentralFile removeCentralFile(CentralFile centralFile) {
		getCentralFiles().remove(centralFile);
		centralFile.setCentralProduct(null);

		return centralFile;
	}

	public List<CentralPrice> getCentralPrices() {
		return this.centralPrices;
	}

	public void setCentralPrices(List<CentralPrice> centralPrices) {
		this.centralPrices = centralPrices;
	}

	public CentralPrice addCentralPrice(CentralPrice centralPrice) {
		getCentralPrices().add(centralPrice);
		centralPrice.setCentralProduct(this);

		return centralPrice;
	}

	public CentralPrice removeCentralPrice(CentralPrice centralPrice) {
		getCentralPrices().remove(centralPrice);
		centralPrice.setCentralProduct(null);

		return centralPrice;
	}

	public List<CentralProductCategory> getCentralProductCategories() {
		return this.centralProductCategories;
	}

	public void setCentralProductCategories(List<CentralProductCategory> centralProductCategories) {
		this.centralProductCategories = centralProductCategories;
	}

	public CentralProductCategory addCentralProductCategory(CentralProductCategory centralProductCategory) {
		getCentralProductCategories().add(centralProductCategory);
		centralProductCategory.setCentralProduct(this);

		return centralProductCategory;
	}

	public CentralProductCategory removeCentralProductCategory(CentralProductCategory centralProductCategory) {
		getCentralProductCategories().remove(centralProductCategory);
		centralProductCategory.setCentralProduct(null);

		return centralProductCategory;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

}