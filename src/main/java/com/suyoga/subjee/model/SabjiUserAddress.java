package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_user_address database table.
 * 
 */
@Entity
@Table(name="sabji_user_address")
@NamedQuery(name="SabjiUserAddress.findAll", query="SELECT s FROM SabjiUserAddress s")
public class SabjiUserAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	private int addressId;

	@Column(name="address_city")
	private String addressCity;

	@Column(name="address_country")
	private String addressCountry;

	@Column(name="address_default")
	private byte addressDefault;

	@Column(name="address_fax")
	private String addressFax;

	@Column(name="address_firstname")
	private String addressFirstname;

	@Column(name="address_lastname")
	private String addressLastname;

	@Column(name="address_middle_name")
	private String addressMiddleName;

	@Column(name="address_post_code")
	private String addressPostCode;

	@Column(name="address_published")
	private byte addressPublished;

	@Column(name="address_state")
	private String addressState;

	@Column(name="address_street")
	private String addressStreet;

	@Column(name="address_street2")
	private String addressStreet2;

	@Column(name="address_telephone")
	private String addressTelephone;

	@Column(name="address_telephone2")
	private String addressTelephone2;

	//bi-directional many-to-one association to SabjiUser
	@ManyToOne
	@JoinColumn(name="address_user_id")
	private SabjiUser sabjiUser;

	public SabjiUserAddress() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCountry() {
		return this.addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public byte getAddressDefault() {
		return this.addressDefault;
	}

	public void setAddressDefault(byte addressDefault) {
		this.addressDefault = addressDefault;
	}

	public String getAddressFax() {
		return this.addressFax;
	}

	public void setAddressFax(String addressFax) {
		this.addressFax = addressFax;
	}

	public String getAddressFirstname() {
		return this.addressFirstname;
	}

	public void setAddressFirstname(String addressFirstname) {
		this.addressFirstname = addressFirstname;
	}

	public String getAddressLastname() {
		return this.addressLastname;
	}

	public void setAddressLastname(String addressLastname) {
		this.addressLastname = addressLastname;
	}

	public String getAddressMiddleName() {
		return this.addressMiddleName;
	}

	public void setAddressMiddleName(String addressMiddleName) {
		this.addressMiddleName = addressMiddleName;
	}

	public String getAddressPostCode() {
		return this.addressPostCode;
	}

	public void setAddressPostCode(String addressPostCode) {
		this.addressPostCode = addressPostCode;
	}

	public byte getAddressPublished() {
		return this.addressPublished;
	}

	public void setAddressPublished(byte addressPublished) {
		this.addressPublished = addressPublished;
	}

	public String getAddressState() {
		return this.addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressStreet() {
		return this.addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressStreet2() {
		return this.addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	public String getAddressTelephone() {
		return this.addressTelephone;
	}

	public void setAddressTelephone(String addressTelephone) {
		this.addressTelephone = addressTelephone;
	}

	public String getAddressTelephone2() {
		return this.addressTelephone2;
	}

	public void setAddressTelephone2(String addressTelephone2) {
		this.addressTelephone2 = addressTelephone2;
	}

	public SabjiUser getSabjiUser() {
		return this.sabjiUser;
	}

	public void setSabjiUser(SabjiUser sabjiUser) {
		this.sabjiUser = sabjiUser;
	}

}