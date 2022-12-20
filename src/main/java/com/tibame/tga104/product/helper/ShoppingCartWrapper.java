package com.tibame.tga104.product.helper;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCartWrapper {
	private Integer restaurantNo;
	private String restaurantName;
	private Set<ShoppingCartItem> cart;
	
	public ShoppingCartWrapper() {
		this.cart = new HashSet<ShoppingCartItem>();
	}
	public ShoppingCartWrapper(Integer restaurantNo, String restaurantName) {
		this.restaurantNo = restaurantNo;
		this.restaurantName = restaurantName;
		this.cart = new HashSet<ShoppingCartItem>();
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShoppingCartWrapper target = (ShoppingCartWrapper) o;
		return this.restaurantNo.equals(target.restaurantNo);
	}
	public Integer getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Set<ShoppingCartItem> getCart() {
		return cart;
	}
	public void setCart(Set<ShoppingCartItem> cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "ShoppingCartWrapper [restaurantNo=" + restaurantNo + ", restaurantName=" + restaurantName + ", cart="
				+ cart + "]";
	}
}
