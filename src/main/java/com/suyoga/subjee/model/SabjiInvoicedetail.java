package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sabji_invoicedetails database table.
 * 
 */
@Entity
@Table(name="sabji_invoicedetails")
@NamedQuery(name="SabjiInvoicedetail.findAll", query="SELECT s FROM SabjiInvoicedetail s")
public class SabjiInvoicedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_id")
	private int invoiceId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invoice_date")
	private Date invoiceDate;

	@Column(name="invoice_name")
	private String invoiceName;

	private BigDecimal price;
	
	@Column(name="orderNumber")
	private Integer orderNumber;

	public SabjiInvoicedetail() {
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceName() {
		return this.invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

}