package com.tibame.tga104.order.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="prodOrderDetail")
@IdClass(ProdOrderDetailPK.class)
public class ProdOrderDetailVO implements Serializable{
	private static final long serialVersionUID = -8609218714494802116L;
	
		@Id
		@Column(name="prodOrderNo")
		@NotNull
		private Integer prodOrderNo;
		@Id
		@Column(name="prodNo")
		@NotNull
		private Integer prodNo;
		@Column(name="prodQty")
		@NotNull
		private Integer prodQty;
//		@Column(name="prodPrice")
//		@NotNull
//		private Integer prodPrice;	
		@Column(name="prodCommentRating")
		private Integer prodCommentRating;
		@Column(name="prodCommentContent")
		private String prodCommentContent;	
		@Column(name="prodCommentPic", columnDefinition = "longblob")
		private byte[] prodCommentPic;
		@Column(name="prodCommentTime")
		private java.sql.Timestamp prodCommentTime;
		@Column(name="restaurantReplyTime")
		private java.sql.Timestamp restaurantReplyTime;
		
		public ProdOrderDetailPK getId() {
			return new ProdOrderDetailPK(prodOrderNo, prodNo);
		}
		public void setId(ProdOrderDetailPK id) {
			this.prodOrderNo = id.getProdOrderNo();
			this.prodNo = id.getProdNo();
		}
		
		@Override
		public String toString() {
			return "ProdOrderDetailVO [prodOrderNo=" + prodOrderNo + ", prodNo=" + prodNo
					+ ", prodQty=" + prodQty + ", prodCommentRating=" + prodCommentRating + ", prodCommentContent="
					+ prodCommentContent + ", prodCommentPic=" + Arrays.toString(prodCommentPic) + ", prodCommentTime="
					+ prodCommentTime + ", restaurantReplyTime=" + restaurantReplyTime + "]";
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
		public Integer getProdQty() {
			return prodQty;
		}
		public void setProdQty(Integer prodQty) {
			this.prodQty = prodQty;
		}
//		public Integer getProdPrice() {
//			return prodPrice;
//		}
//		public void setProdPrice(Integer prodPrice) {
//			this.prodPrice = prodPrice;
//		}
		public Integer getProdCommentRating() {
			return prodCommentRating;
		}
		public void setProdCommentRating(Integer prodCommentRating) {
			this.prodCommentRating = prodCommentRating;
		}
		public String getProdCommentContent() {
			return prodCommentContent;
		}
		public void setProdCommentContent(String prodCommentContent) {
			this.prodCommentContent = prodCommentContent;
		}
		public byte[] getProdCommentPic() {
			return prodCommentPic;
		}
		public void setProdCommentPic(byte[] prodCommentPic) {
			this.prodCommentPic = prodCommentPic;
		}
		public java.sql.Timestamp getProdCommentTime() {
			return prodCommentTime;
		}
		public void setProdCommentTime(java.sql.Timestamp prodCommentTime) {
			this.prodCommentTime = prodCommentTime;
		}
		public java.sql.Timestamp getRestaurantReplyTime() {
			return restaurantReplyTime;
		}
		public void setRestaurantReplyTime(java.sql.Timestamp restaurantReplyTime) {
			this.restaurantReplyTime = restaurantReplyTime;
		}

}

