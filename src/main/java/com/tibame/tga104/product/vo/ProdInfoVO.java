package com.tibame.tga104.product.vo;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="prodInfo")
public class ProdInfoVO implements java.io.Serializable{
	
	private static final long serialVersionUID = -8107177340605184651L;
	@Id
	@Column(name="prodNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodNo;
	@Column(name="restaurantNo", nullable = false)
	private Integer restaurantNo;
	@Column(name="prodCategoryNo", nullable = false)
	private Integer prodCategoryNo;
	@Column(name="prodName", nullable = false)
	private String prodName;
	@Column(name="prodPrice", nullable = false)
	private Integer prodPrice;
	@Column(name="prodStock", nullable = false)
	private Integer prodStock;
	@Column(name="prodDescription")
	private String prodDescription;
	@Column(name="prodContent")
	private String prodContent;
	@Column(name="prodMainPic", columnDefinition = "longblob")
	private byte[] prodMainPic;
	@Column(name="prodCommentQty", nullable = false)
	private Integer prodCommentQty;
	@Column(name="totalCommentRating", nullable = false)
	private Integer totalCommentRating;
	@Transient
	private String prodMainPicStr;
	
	public Integer getProdNo() {
		return prodNo;
	}
	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}
	public Integer getRestaurantNo() {
		return restaurantNo;
	}
	public byte[] getProdMainPic() {
		return prodMainPic;
	}
	public void setProdMainPic(byte[] prodMainPic) {
		this.prodMainPic = prodMainPic;
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
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
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
	public Integer getProdCommentQty() {
		return prodCommentQty;
	}
	public void setProdCommentQty(Integer prodCommentQty) {
		this.prodCommentQty = prodCommentQty;
	}
	public Integer getTotalCommentRating() {
		return totalCommentRating;
	}
	public void setTotalCommentRating(Integer prodCommentRating) {
		this.totalCommentRating = prodCommentRating;
	}
	
	public String getProdMainPicStr() {
		return prodMainPicStr;
	}
	public void setProdMainPicStr(String prodPicMainPicStr) {
		this.prodMainPicStr = prodPicMainPicStr;
	}
	@Override
	public String toString() {
		return "ProdInfoVO [prodNo=" + prodNo + ", restaurantNo=" + restaurantNo + ", prodCategoryNo=" + prodCategoryNo
				+ ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodStock=" + prodStock
				+ ", prodDescription=" + prodDescription + ", prodContent=" + prodContent + ", prodMainPic="
				+ Arrays.toString(prodMainPic) + ", prodCommentQty=" + prodCommentQty + ", totalCommentRating="
				+ totalCommentRating + ", prodMainPicStr=" + prodMainPicStr + "]";
	}
	
}
