package com.tibame.tga104.product.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_showprodinmall")
public class ShowProdInMallVO implements java.io.Serializable{
	private static final long serialVersionUID = -7111782836201647606L;

	@Id
	@Column(name = "prodNo")
	private Integer prodNo;
	@Column(name = "prodName")
	private String prodName;
	@Column(name = "restaurantNo")
	private Integer restaurantNo;
	@Column(name = "restaurantName")
	private String restaurantName;
	@Column(name = "prodCategoryNo")
	private Integer prodCategoryNo;
	@Column(name = "prodCategory")
	private String prodCategory;
	@Column(name = "prodPrice")
	private Integer prodPrice;
	@Column(name = "totalCommentRating")
	private Integer totalCommentRating;
	@Column(name = "prodCommentQty")
	private Integer prodCommentQty;
	
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
	public Integer getProdCategoryNo() {
		return prodCategoryNo;
	}
	public void setProdCategoryNo(Integer prodCategoryNo) {
		this.prodCategoryNo = prodCategoryNo;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public Integer getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}
	public Integer getTotalCommentRating() {
		return totalCommentRating;
	}
	public void setTotalCommentRating(Integer totalCommentRating) {
		this.totalCommentRating = totalCommentRating;
	}
	public Integer getProdCommentQty() {
		return prodCommentQty;
	}
	public void setProdCommentQty(Integer prodCommentQty) {
		this.prodCommentQty = prodCommentQty;
	}
	@Override
	public String toString() {
		return "ShowProdInMallVO [prodNo=" + prodNo + ", prodName=" + prodName + ", restaurantNo=" + restaurantNo
				+ ", restaurantName=" + restaurantName + ", prodCategoryNo=" + prodCategoryNo + ", prodCategory="
				+ prodCategory + ", prodPrice=" + prodPrice + ", totalCommentRating=" + totalCommentRating
				+ ", prodCommentQty=" + prodCommentQty + "]";
	}
	
	
}
