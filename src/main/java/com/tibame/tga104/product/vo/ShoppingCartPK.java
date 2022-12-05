package com.tibame.tga104.product.vo;

import java.io.Serializable;

/** 參照Hibernate規格書2.6.4. Composite identifiers with @IdClass 寫的*/
public class ShoppingCartPK implements Serializable{
	private static final long serialVersionUID = 3762440187905611200L;
	
	private Integer memberNo;
	private Integer prodNo;
	public ShoppingCartPK (Integer memberNo, Integer prodNo) {
		this.memberNo = memberNo;
		this.prodNo = prodNo;
	}
	private ShoppingCartPK() {
		
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
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
		ShoppingCartPK pk = (ShoppingCartPK) o;
		return memberNo.equals(pk.memberNo) && prodNo.equals(pk.prodNo);
	}
}
