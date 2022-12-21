package com.tibame.tga104.product.helper;

public class ShoppingCartItem {
	private Integer prodNo;
	private String prodName;
	private Integer prodQty;
	private Integer prodPrice;

	private ShoppingCartItem() {

	}

	private ShoppingCartItem(ShoppingCartItem.Builder builder) {
		this.prodNo = builder.prodNo;
		this.prodName = builder.prodName;
		this.prodQty = builder.prodQty;
		this.prodPrice = builder.prodPrice;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [prodNo=" + prodNo + ", prodName=" + prodName + ", prodQty=" + prodQty + ", prodPrice="
				+ prodPrice + "]";
	}

	public static class Builder {
		private Integer prodNo;
		private String prodName;
		private Integer prodQty;
		private Integer prodPrice;

		public ShoppingCartItem.Builder setProdNo(Integer prodNo) {
			this.prodNo = prodNo;
			return this;
		}

		public ShoppingCartItem.Builder setProdName(String prodName) {
			this.prodName = prodName;
			return this;
		}

		public ShoppingCartItem.Builder setProdQty(Integer prodQty) {
			this.prodQty = prodQty;
			return this;
		}

		public ShoppingCartItem.Builder setProdPrice(Integer prodPrice) {
			this.prodPrice = prodPrice;
			return this;
		}

		public ShoppingCartItem build() {
			return new ShoppingCartItem(this);
		}

	}

	public Integer getProdNo() {
		return prodNo;
	}

	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Integer getProdQty() {
		return prodQty;
	}

	public void setProdQty(Integer prodQty) {
		this.prodQty = prodQty;
	}

	public Integer getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}

}
