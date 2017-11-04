package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sabji_order_product database table.
 * 
 */
@Entity
@Table(name="sabji_order_product")
@NamedQuery(name="SabjiOrderProduct.findAll", query="SELECT s FROM SabjiOrderProduct s")
public class SabjiOrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="order_product_id")
	private int orderProductId;

	@Column(name="order_product_code")
	private String orderProductCode;

	@Column(name="order_product_name")
	private String orderProductName;

	@Lob
	@Column(name="order_product_options")
	private String orderProductOptions;

	@Column(name="order_product_price")
	private BigDecimal orderProductPrice;

	@Column(name="order_product_quantity")
	private String orderProductQuantity;

	@Column(name="order_product_tax")
	private BigDecimal orderProductTax;

	@Lob
	@Column(name="order_product_tax_info")
	private String orderProductTaxInfo;

	@Column(name="product_id")
	private int productId;
	
	@Column(name="brand_name")
	private String brandname;
	
	@Column(name="item_return")
	private Boolean itemReturn;

	//bi-directional many-to-one association to SabjiOrder
	@ManyToOne
	@JoinColumn(name="order_id")
	private SabjiOrder sabjiOrder;	
	

	public SabjiOrderProduct() {
	}

	public int getOrderProductId() {
		return this.orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public String getOrderProductCode() {
		return this.orderProductCode;
	}

	public void setOrderProductCode(String orderProductCode) {
		this.orderProductCode = orderProductCode;
	}

	public String getOrderProductName() {
		return this.orderProductName;
	}

	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}

	public String getOrderProductOptions() {
		return this.orderProductOptions;
	}

	public void setOrderProductOptions(String orderProductOptions) {
		this.orderProductOptions = orderProductOptions;
	}

	public BigDecimal getOrderProductPrice() {
		return this.orderProductPrice;
	}

	public void setOrderProductPrice(BigDecimal orderProductPrice) {
		this.orderProductPrice = orderProductPrice;
	}

	public String getOrderProductQuantity() {
		return this.orderProductQuantity;
	}

	public void setOrderProductQuantity(String orderProductQuantity) {
		this.orderProductQuantity = orderProductQuantity;
	}

	public BigDecimal getOrderProductTax() {
		return this.orderProductTax;
	}

	public void setOrderProductTax(BigDecimal orderProductTax) {
		this.orderProductTax = orderProductTax;
	}

	public String getOrderProductTaxInfo() {
		return this.orderProductTaxInfo;
	}

	public void setOrderProductTaxInfo(String orderProductTaxInfo) {
		this.orderProductTaxInfo = orderProductTaxInfo;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public SabjiOrder getSabjiOrder() {
		return this.sabjiOrder;
	}

	public void setSabjiOrder(SabjiOrder sabjiOrder) {
		this.sabjiOrder = sabjiOrder;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Boolean getItemReturn() {
		return itemReturn;
	}

	public void setItemReturn(Boolean itemReturn) {
		this.itemReturn = itemReturn;
	}

}