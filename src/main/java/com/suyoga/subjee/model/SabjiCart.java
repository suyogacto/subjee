package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sabji_cart database table.
 * 
 */
@Entity
@Table(name="sabji_cart")
@NamedQuery(name="SabjiCart.findAll", query="SELECT s FROM SabjiCart s")
public class SabjiCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_id")
	private int cartId;

	@Column(name="cart_coupon")
	private String cartCoupon;

	@Column(name="cart_modified")
	private int cartModified;

	@Column(name="cart_name")
	private String cartName;

	@Lob
	@Column(name="cart_params")
	private String cartParams;

	@Column(name="cart_type")
	private String cartType;

	@Column(name="session_id")
	private String sessionId;

	//bi-directional many-to-one association to SabjiUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private SabjiUser sabjiUser;

	//bi-directional many-to-one association to SabjiCartProduct
	@OneToMany(mappedBy="sabjiCart")
	private List<SabjiCartProduct> sabjiCartProducts;

	public SabjiCart() {
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartCoupon() {
		return this.cartCoupon;
	}

	public void setCartCoupon(String cartCoupon) {
		this.cartCoupon = cartCoupon;
	}

	public int getCartModified() {
		return this.cartModified;
	}

	public void setCartModified(int cartModified) {
		this.cartModified = cartModified;
	}

	public String getCartName() {
		return this.cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public String getCartParams() {
		return this.cartParams;
	}

	public void setCartParams(String cartParams) {
		this.cartParams = cartParams;
	}

	public String getCartType() {
		return this.cartType;
	}

	public void setCartType(String cartType) {
		this.cartType = cartType;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public SabjiUser getSabjiUser() {
		return this.sabjiUser;
	}

	public void setSabjiUser(SabjiUser sabjiUser) {
		this.sabjiUser = sabjiUser;
	}

	public List<SabjiCartProduct> getSabjiCartProducts() {
		return this.sabjiCartProducts;
	}

	public void setSabjiCartProducts(List<SabjiCartProduct> sabjiCartProducts) {
		this.sabjiCartProducts = sabjiCartProducts;
	}

	public SabjiCartProduct addSabjiCartProduct(SabjiCartProduct sabjiCartProduct) {
		getSabjiCartProducts().add(sabjiCartProduct);
		sabjiCartProduct.setSabjiCart(this);

		return sabjiCartProduct;
	}

	public SabjiCartProduct removeSabjiCartProduct(SabjiCartProduct sabjiCartProduct) {
		getSabjiCartProducts().remove(sabjiCartProduct);
		sabjiCartProduct.setSabjiCart(null);

		return sabjiCartProduct;
	}

}