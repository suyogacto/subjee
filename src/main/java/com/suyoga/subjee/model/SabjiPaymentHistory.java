package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_payment_history database table.
 * 
 */
@Entity
@Table(name="sabji_payment_history")
@NamedQuery(name="SabjiPaymentHistory.findAll", query="SELECT s FROM SabjiPaymentHistory s")
public class SabjiPaymentHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="history_id")
	private int historyId;

	@Column(name="history_amount")
	private String historyAmount;

	@Column(name="history_created")
	private int historyCreated;

	@Lob
	@Column(name="history_data")
	private String historyData;

	@Column(name="history_ip")
	private String historyIp;

	@Column(name="history_new_status")
	private String historyNewStatus;

	@Column(name="history_notified")
	private byte historyNotified;

	@Column(name="history_order_id")
	private int historyOrderId;

	@Column(name="history_package_id")
	private int historyPackageId;

	@Column(name="history_payment_id")
	private String historyPaymentId;

	@Lob
	@Column(name="history_reason")
	private String historyReason;

	@Column(name="history_type")
	private String historyType;

	@Column(name="history_user_id")
	private int historyUserId;

	public SabjiPaymentHistory() {
	}

	public int getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public String getHistoryAmount() {
		return this.historyAmount;
	}

	public void setHistoryAmount(String historyAmount) {
		this.historyAmount = historyAmount;
	}

	public int getHistoryCreated() {
		return this.historyCreated;
	}

	public void setHistoryCreated(int historyCreated) {
		this.historyCreated = historyCreated;
	}

	public String getHistoryData() {
		return this.historyData;
	}

	public void setHistoryData(String historyData) {
		this.historyData = historyData;
	}

	public String getHistoryIp() {
		return this.historyIp;
	}

	public void setHistoryIp(String historyIp) {
		this.historyIp = historyIp;
	}

	public String getHistoryNewStatus() {
		return this.historyNewStatus;
	}

	public void setHistoryNewStatus(String historyNewStatus) {
		this.historyNewStatus = historyNewStatus;
	}

	public byte getHistoryNotified() {
		return this.historyNotified;
	}

	public void setHistoryNotified(byte historyNotified) {
		this.historyNotified = historyNotified;
	}

	public int getHistoryOrderId() {
		return this.historyOrderId;
	}

	public void setHistoryOrderId(int historyOrderId) {
		this.historyOrderId = historyOrderId;
	}

	public int getHistoryPackageId() {
		return this.historyPackageId;
	}

	public void setHistoryPackageId(int historyPackageId) {
		this.historyPackageId = historyPackageId;
	}

	public String getHistoryPaymentId() {
		return this.historyPaymentId;
	}

	public void setHistoryPaymentId(String historyPaymentId) {
		this.historyPaymentId = historyPaymentId;
	}

	public String getHistoryReason() {
		return this.historyReason;
	}

	public void setHistoryReason(String historyReason) {
		this.historyReason = historyReason;
	}

	public String getHistoryType() {
		return this.historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public int getHistoryUserId() {
		return this.historyUserId;
	}

	public void setHistoryUserId(int historyUserId) {
		this.historyUserId = historyUserId;
	}

}