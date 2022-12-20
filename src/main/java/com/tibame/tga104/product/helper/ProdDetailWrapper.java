package com.tibame.tga104.product.helper;

import java.util.List;
import java.util.Map;

import com.tibame.tga104.product.vo.ShowProdDetailVO;
import com.tibame.tga104.product.vo.ShowProdInMallVO;

public class ProdDetailWrapper {
	private ShowProdDetailVO showProdDetailVO;
	private List<Integer> prodPicList;
	private Map<Integer, Integer> shoppingCart;
	private List<ShowProdInMallVO> similarProdList;
	
	public ShowProdDetailVO getShowProdDetailVO() {
		return showProdDetailVO;
	}
	public void setShowProdDetailVO(ShowProdDetailVO showProdDetailVO) {
		this.showProdDetailVO = showProdDetailVO;
	}
	public List<Integer> getProdPicList() {
		return prodPicList;
	}
	public void setProdPicList(List<Integer> prodPicList) {
		this.prodPicList = prodPicList;
	}
	public Map<Integer, Integer> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(Map<Integer, Integer> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public List<ShowProdInMallVO> getSimilarProdList() {
		return similarProdList;
	}
	public void setSimilarProdList(List<ShowProdInMallVO> similarProdList) {
		this.similarProdList = similarProdList;
	}
}
