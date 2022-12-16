package com.tibame.tga104.order.vo;

import java.io.Serializable;

public class ProdOrderDetailPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer prodOrderNo;
	private Integer prodNo;
	
	public ProdOrderDetailPK() {
		
	}
	
	public ProdOrderDetailPK(Integer prodOrderNo, Integer prodNo) {
		this.prodOrderNo = prodOrderNo;
		this.prodNo = prodNo;
	}

	@Override
	public String toString() {
		return "ProdOrderDetailPK [prodOrderNo=" + prodOrderNo + ", prodNo=" + prodNo + "]";
	}
	
	public Integer getProdOrderNo() {
		return prodOrderNo;
	}
	public void setProdOrderNo(Integer prodOrderNo) {
		this.prodOrderNo = prodOrderNo;
	}
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProdOrderDetailPK prodOrderDetailPK = (ProdOrderDetailPK) o;
		return prodOrderNo.equals(prodOrderDetailPK.prodOrderNo) && prodNo.equals(prodOrderDetailPK.prodNo);
	}
	
	
}
