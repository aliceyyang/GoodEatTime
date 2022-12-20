package com.tibame.tga104.product.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="v_showproddetail")
public class ShowProdDetailVO implements Serializable{
	private static final long serialVersionUID = -2906441782209523792L;
	
	@Id
	@Column(name = "prodNo")
	private Integer prodNo;
	@Column(name = "prodName")
	private String prodName;
	@Column(name = "restaurantName")
	private String restaurantName;
	@Column(name = "prodCategory")
	private String prodCategory;
	@Column(name = "prodPrice")
	private Integer prodPrice;
	@Column(name = "prodStock")
	private Integer prodStock;
	@Column(name="restaurantNo")
	private Integer restaurantNo;
	@Column(name="prodCategoryNo")
	private Integer prodCategoryNo;
	@Column(name="prodDescription")
	private String prodDescription;
	@Column(name="prodContent")
	private String prodContent;
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
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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
	public Integer getProdStock() {
		return prodStock;
	}
	public void setProdStock(Integer prodStock) {
		this.prodStock = prodStock;
	}
	public Integer getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public Integer getProdCategoryNo() {
		return prodCategoryNo;
	}
	public void setProdCategoryNo(Integer prodCategoryNo) {
		this.prodCategoryNo = prodCategoryNo;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
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
		return "ShowProdDetailVO [prodNo=" + prodNo + ", prodName=" + prodName + ", restaurantName=" + restaurantName
				+ ", prodCategory=" + prodCategory + ", prodPrice=" + prodPrice + ", prodStock=" + prodStock
				+ ", restaurantNo=" + restaurantNo + ", prodCategoryNo=" + prodCategoryNo + ", prodDescription="
				+ prodDescription + ", prodContent=" + prodContent + ", totalCommentRating=" + totalCommentRating
				+ ", prodCommentQty=" + prodCommentQty + "]";
	}
	
}
