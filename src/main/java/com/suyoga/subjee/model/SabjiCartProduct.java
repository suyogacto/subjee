package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_cart_product database table.
 * 
 */
@Entity
@Table(name="sabji_cart_product")
@NamedQuery(name="SabjiCartProduct.findAll", query="SELECT s FROM SabjiCartProduct s")
public class SabjiCartProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_product_id")
	private int cartProductId;

	@Column(name="cart_product_modified")
	private int cartProductModified;

	@Column(name="cart_product_quantity")
	private int cartProductQuantity;

	@Column(name="cart_product_wishlist_id")
	private int cartProductWishlistId;

	@Column(name="product_id")
	private int productId;

	//bi-directional many-to-one association to SabjiCart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private SabjiCart sabjiCart;

	public SabjiCartProduct() {
	}

	public int getCartProductId() {
		return this.cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public int getCartProductModified() {
		return this.cartProductModified;
	}

	public void setCartProductModified(int cartProductModified) {
		this.cartProductModified = cartProductModified;
	}

	public int getCartProductQuantity() {
		return this.cartProductQuantity;
	}

	public void setCartProductQuantity(int cartProductQuantity) {
		this.cartProductQuantity = cartProductQuantity;
	}

	public int getCartProductWishlistId() {
		return this.cartProductWishlistId;
	}

	public void setCartProductWishlistId(int cartProductWishlistId) {
		this.cartProductWishlistId = cartProductWishlistId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public SabjiCart getSabjiCart() {
		return this.sabjiCart;
	}

	public void setSabjiCart(SabjiCart sabjiCart) {
		this.sabjiCart = sabjiCart;
	}

}