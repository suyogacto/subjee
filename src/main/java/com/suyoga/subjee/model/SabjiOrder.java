package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sabji_order database table.
 * 
 */
@Entity
@Table(name="sabji_order")
@NamedQuery(name="SabjiOrder.findAll", query="SELECT s FROM SabjiOrder s")
public class SabjiOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private int orderId;

	@Lob
	@Column(name="order_billing_address")
	private String orderBillingAddress;

	@Column(name="order_billing_mobile")
	private BigInteger orderBillingMobile;

	@Column(name="order_discount_code")
	private String orderDiscountCode;

	@Column(name="order_discount_price")
	private BigDecimal orderDiscountPrice;

	@Column(name="order_discount_tax")
	private BigDecimal orderDiscountTax;

	@Column(name="order_full_price")
	private BigDecimal orderFullPrice;

	@Column(name="order_invoice_number")
	private String orderInvoiceNumber;

	@Column(name="order_ip")
	private String orderIp;

	@Column(name="order_number")
	private String orderNumber;

	@Column(name="order_payment_id")
	private String orderPaymentId;

	@Column(name="order_payment_method")
	private String orderPaymentMethod;

	@Lob
	@Column(name="order_payment_params")
	private String orderPaymentParams;

	@Column(name="order_payment_price")
	private BigDecimal orderPaymentPrice;

	@Column(name="order_payment_tax")
	private BigDecimal orderPaymentTax;

	@Column(name="order_shipping_id")
	private String orderShippingId;

	@Column(name="order_shipping_method")
	private String orderShippingMethod;

	@Lob
	@Column(name="order_shipping_params")
	private String orderShippingParams;

	@Column(name="order_shipping_price")
	private BigDecimal orderShippingPrice;

	@Column(name="order_shipping_tax")
	private BigDecimal orderShippingTax;

	@Column(name="order_site_id")
	private String orderSiteId;

	@Column(name="order_status")
	private String orderStatus;

	@Lob
	@Column(name="order_tax_info")
	private String orderTaxInfo;

	@Column(name="order_tracking_id")
	private String orderTrackingId;

	@Column(name="order_type")
	private String orderType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="order_user_id")
	private BigInteger orderUserId;	
	
	@Column(name="order_feedback")
	private String feedback; 
	
	@Column(name="venderId")
	private String venderId;
	
	@Column(name="timeslot")
	private String timeSlot;
	
	@Column(name="promoCode")
	private String promoCode;
	
	@Column(name="discountAmount")
	private BigDecimal discountAmount;

	//bi-directional many-to-one association to SabjiOrderProduct
	@OneToMany(mappedBy="sabjiOrder")
	private List<SabjiOrderProduct> sabjiOrderProducts;

	public SabjiOrder() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderBillingAddress() {
		return this.orderBillingAddress;
	}

	public void setOrderBillingAddress(String orderBillingAddress) {
		this.orderBillingAddress = orderBillingAddress;
	}

	public BigInteger getOrderBillingMobile() {
		return this.orderBillingMobile;
	}

	public void setOrderBillingMobile(BigInteger orderBillingMobile) {
		this.orderBillingMobile = orderBillingMobile;
	}

	public String getOrderDiscountCode() {
		return this.orderDiscountCode;
	}

	public void setOrderDiscountCode(String orderDiscountCode) {
		this.orderDiscountCode = orderDiscountCode;
	}

	public BigDecimal getOrderDiscountPrice() {
		return this.orderDiscountPrice;
	}

	public void setOrderDiscountPrice(BigDecimal orderDiscountPrice) {
		this.orderDiscountPrice = orderDiscountPrice;
	}

	public BigDecimal getOrderDiscountTax() {
		return this.orderDiscountTax;
	}

	public void setOrderDiscountTax(BigDecimal orderDiscountTax) {
		this.orderDiscountTax = orderDiscountTax;
	}

	public BigDecimal getOrderFullPrice() {
		return this.orderFullPrice;
	}

	public void setOrderFullPrice(BigDecimal orderFullPrice) {
		this.orderFullPrice = orderFullPrice;
	}

	public String getOrderInvoiceNumber() {
		return this.orderInvoiceNumber;
	}

	public void setOrderInvoiceNumber(String orderInvoiceNumber) {
		this.orderInvoiceNumber = orderInvoiceNumber;
	}

	public String getOrderIp() {
		return this.orderIp;
	}

	public void setOrderIp(String orderIp) {
		this.orderIp = orderIp;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderPaymentId() {
		return this.orderPaymentId;
	}

	public void setOrderPaymentId(String orderPaymentId) {
		this.orderPaymentId = orderPaymentId;
	}

	public String getOrderPaymentMethod() {
		return this.orderPaymentMethod;
	}

	public void setOrderPaymentMethod(String orderPaymentMethod) {
		this.orderPaymentMethod = orderPaymentMethod;
	}

	public String getOrderPaymentParams() {
		return this.orderPaymentParams;
	}

	public void setOrderPaymentParams(String orderPaymentParams) {
		this.orderPaymentParams = orderPaymentParams;
	}

	public BigDecimal getOrderPaymentPrice() {
		return this.orderPaymentPrice;
	}

	public void setOrderPaymentPrice(BigDecimal orderPaymentPrice) {
		this.orderPaymentPrice = orderPaymentPrice;
	}

	public BigDecimal getOrderPaymentTax() {
		return this.orderPaymentTax;
	}

	public void setOrderPaymentTax(BigDecimal orderPaymentTax) {
		this.orderPaymentTax = orderPaymentTax;
	}

	public String getOrderShippingId() {
		return this.orderShippingId;
	}

	public void setOrderShippingId(String orderShippingId) {
		this.orderShippingId = orderShippingId;
	}

	public String getOrderShippingMethod() {
		return this.orderShippingMethod;
	}

	public void setOrderShippingMethod(String orderShippingMethod) {
		this.orderShippingMethod = orderShippingMethod;
	}

	public String getOrderShippingParams() {
		return this.orderShippingParams;
	}

	public void setOrderShippingParams(String orderShippingParams) {
		this.orderShippingParams = orderShippingParams;
	}

	public BigDecimal getOrderShippingPrice() {
		return this.orderShippingPrice;
	}

	public void setOrderShippingPrice(BigDecimal orderShippingPrice) {
		this.orderShippingPrice = orderShippingPrice;
	}

	public BigDecimal getOrderShippingTax() {
		return this.orderShippingTax;
	}

	public void setOrderShippingTax(BigDecimal orderShippingTax) {
		this.orderShippingTax = orderShippingTax;
	}

	public String getOrderSiteId() {
		return this.orderSiteId;
	}

	public void setOrderSiteId(String orderSiteId) {
		this.orderSiteId = orderSiteId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderTaxInfo() {
		return this.orderTaxInfo;
	}

	public void setOrderTaxInfo(String orderTaxInfo) {
		this.orderTaxInfo = orderTaxInfo;
	}

	public String getOrderTrackingId() {
		return this.orderTrackingId;
	}

	public void setOrderTrackingId(String orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigInteger getOrderUserId() {
		return this.orderUserId;
	}

	public void setOrderUserId(BigInteger orderUserId) {
		this.orderUserId = orderUserId;
	}

	public List<SabjiOrderProduct> getSabjiOrderProducts() {
		return this.sabjiOrderProducts;
	}

	public void setSabjiOrderProducts(List<SabjiOrderProduct> sabjiOrderProducts) {
		this.sabjiOrderProducts = sabjiOrderProducts;
	}

	public SabjiOrderProduct addSabjiOrderProduct(SabjiOrderProduct sabjiOrderProduct) {
		getSabjiOrderProducts().add(sabjiOrderProduct);
		sabjiOrderProduct.setSabjiOrder(this);

		return sabjiOrderProduct;
	}

	public SabjiOrderProduct removeSabjiOrderProduct(SabjiOrderProduct sabjiOrderProduct) {
		getSabjiOrderProducts().remove(sabjiOrderProduct);
		sabjiOrderProduct.setSabjiOrder(null);

		return sabjiOrderProduct;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getVenderId() {
		return venderId;
	}

	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

}