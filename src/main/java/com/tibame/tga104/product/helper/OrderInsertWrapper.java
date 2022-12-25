package com.tibame.tga104.product.helper;

import java.util.List;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;
import com.tibame.tga104.order.vo.ProdOrderVO;

public class OrderInsertWrapper {
	private ProdOrderVO prodOrderVO;
	private List<ProdOrderDetailVO> orderDetailList;
	private String message;
	
	public ProdOrderVO getProdOrderVO() {
		return prodOrderVO;
	}
	public void setProdOrderVO(ProdOrderVO prodOrderVO) {
		this.prodOrderVO = prodOrderVO;
	}
	public List<ProdOrderDetailVO> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<ProdOrderDetailVO> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
