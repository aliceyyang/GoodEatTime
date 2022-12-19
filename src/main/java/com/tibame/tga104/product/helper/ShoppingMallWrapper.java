package com.tibame.tga104.product.helper;

import java.util.List;
import java.util.Map;

import com.tibame.tga104.product.vo.ProdCategoryVO;
import com.tibame.tga104.product.vo.ShowProdInMallVO;

public class ShoppingMallWrapper {
	private List<ShowProdInMallVO> prodList;
	private List<ProdCategoryVO> prodCategoryList;
	private Map<Integer, Integer> shoppingCart;

	private ShoppingMallWrapper() {

	}

	private ShoppingMallWrapper(ShoppingMallWrapper.Builder builder) {
		this.prodList = builder.prodList;
		this.prodCategoryList = builder.prodCategoryList;
		this.shoppingCart = builder.shoppingCart;
	}

	public static class Builder {
		private List<ShowProdInMallVO> prodList;
		private List<ProdCategoryVO> prodCategoryList;
		private Map<Integer, Integer> shoppingCart;

		public ShoppingMallWrapper.Builder setProdList(List<ShowProdInMallVO> prodList) {
			this.prodList = prodList;
			return this;
		}

		public ShoppingMallWrapper.Builder setProdCategoryList(List<ProdCategoryVO> prodCategoryList) {
			this.prodCategoryList = prodCategoryList;
			return this;
		}

		public ShoppingMallWrapper.Builder setShoppingCart(Map<Integer, Integer> shoppingCart) {
			this.shoppingCart = shoppingCart;
			return this;
		}

		public ShoppingMallWrapper build() {
			return new ShoppingMallWrapper(this);
		}
	}

	public List<ShowProdInMallVO> getProdList() {
		return prodList;
	}

	public void setProdList(List<ShowProdInMallVO> prodList) {
		this.prodList = prodList;
	}

	public List<ProdCategoryVO> getProdCategoryList() {
		return prodCategoryList;
	}

	public void setProdCategoryList(List<ProdCategoryVO> prodCategoryList) {
		this.prodCategoryList = prodCategoryList;
	}

	public Map<Integer, Integer> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Map<Integer, Integer> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
