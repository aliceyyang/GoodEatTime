package com.tibame.tga104.product.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingCart")
@IdClass(ShoppingCartPK.class)
public class ShoppingCartVO implements Serializable {
	private static final long serialVersionUID = 7540519549556132607L;
	@Id
	@Column(name = "memberNo", nullable = false)
	private Integer memberNo;
	@Id
	@Column(name = "prodNo", nullable = false)
	private Integer prodNo;
	@Column(name = "prodQty", nullable = false)
	private Integer prodQty;
	
	public ShoppingCartPK getId() {
		return new ShoppingCartPK(memberNo, prodNo);
	}
	public void setId(ShoppingCartPK id) {
		this.memberNo = id.getMemberNo();
		this.prodNo = id.getProdNo();
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
	public Integer getProdQty() {
		return prodQty;
	}
	public void setProdQty(Integer prodQty) {
		this.prodQty = prodQty;
	}
	@Override
	public String toString() {
		return "ShoppingCartVO [memberNo=" + memberNo + ", prodNo=" + prodNo + ", prodQty=" + prodQty + "]";
	}
}
