package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sabji_users database table.
 * 
 */
@Entity
@Table(name="sabji_users")
@NamedQuery(name="SabjiUser.findAll", query="SELECT s FROM SabjiUser s")
public class SabjiUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	
	@Column(name="zipcode")
	private int zipcode;

	private String activation;

	

	private String email;



	@Temporal(TemporalType.TIMESTAMP)
	private Date lastresettime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastvisitdate;

	private String name;

	@Lob
	private String params;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="address")
    private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registerdate;



	private String username;

	//bi-directional many-to-one association to SabjiCart
	@OneToMany(mappedBy="sabjiUser")
	private List<SabjiCart> sabjiCarts;

	//bi-directional many-to-one association to SabjiUserAddress
	@OneToMany(mappedBy="sabjiUser")
	private List<SabjiUserAddress> sabjiUserAddresses;

	//bi-directional many-to-one association to SabjiUserUsergroupMap
	@OneToMany(mappedBy="sabjiUser")
	private List<SabjiUserUsergroupMap> sabjiUserUsergroupMaps;

	public SabjiUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivation() {
		return this.activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Date getLastresettime() {
		return this.lastresettime;
	}

	public void setLastresettime(Date lastresettime) {
		this.lastresettime = lastresettime;
	}

	public Date getLastvisitdate() {
		return this.lastvisitdate;
	}

	public void setLastvisitdate(Date lastvisitdate) {
		this.lastvisitdate = lastvisitdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Date getRegisterdate() {
		return this.registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SabjiCart> getSabjiCarts() {
		return this.sabjiCarts;
	}

	public void setSabjiCarts(List<SabjiCart> sabjiCarts) {
		this.sabjiCarts = sabjiCarts;
	}

	public SabjiCart addSabjiCart(SabjiCart sabjiCart) {
		getSabjiCarts().add(sabjiCart);
		sabjiCart.setSabjiUser(this);

		return sabjiCart;
	}

	public SabjiCart removeSabjiCart(SabjiCart sabjiCart) {
		getSabjiCarts().remove(sabjiCart);
		sabjiCart.setSabjiUser(null);

		return sabjiCart;
	}

	public List<SabjiUserAddress> getSabjiUserAddresses() {
		return this.sabjiUserAddresses;
	}

	public void setSabjiUserAddresses(List<SabjiUserAddress> sabjiUserAddresses) {
		this.sabjiUserAddresses = sabjiUserAddresses;
	}

	public SabjiUserAddress addSabjiUserAddress(SabjiUserAddress sabjiUserAddress) {
		getSabjiUserAddresses().add(sabjiUserAddress);
		sabjiUserAddress.setSabjiUser(this);

		return sabjiUserAddress;
	}

	public SabjiUserAddress removeSabjiUserAddress(SabjiUserAddress sabjiUserAddress) {
		getSabjiUserAddresses().remove(sabjiUserAddress);
		sabjiUserAddress.setSabjiUser(null);

		return sabjiUserAddress;
	}

	public List<SabjiUserUsergroupMap> getSabjiUserUsergroupMaps() {
		return this.sabjiUserUsergroupMaps;
	}

	public void setSabjiUserUsergroupMaps(List<SabjiUserUsergroupMap> sabjiUserUsergroupMaps) {
		this.sabjiUserUsergroupMaps = sabjiUserUsergroupMaps;
	}

	public SabjiUserUsergroupMap addSabjiUserUsergroupMap(SabjiUserUsergroupMap sabjiUserUsergroupMap) {
		getSabjiUserUsergroupMaps().add(sabjiUserUsergroupMap);
		sabjiUserUsergroupMap.setSabjiUser(this);

		return sabjiUserUsergroupMap;
	}

	public SabjiUserUsergroupMap removeSabjiUserUsergroupMap(SabjiUserUsergroupMap sabjiUserUsergroupMap) {
		getSabjiUserUsergroupMaps().remove(sabjiUserUsergroupMap);
		sabjiUserUsergroupMap.setSabjiUser(null);

		return sabjiUserUsergroupMap;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}