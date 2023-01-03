package com.tibame.tga104.order.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="v_ProdCommentReply")
@IdClass(ProdOrderDetailPK.class)
public class ProdCommentReplyVO implements Serializable{
	private static final long serialVersionUID = -5639086244675674091L;
	
	@Id
	@Column(name="prodOrderNo")
	private Integer prodOrderNo;
	@Id
	@Column(name="prodNo")
	private Integer prodNo;
	@Column(name="prodQty")
	private Integer prodQty;
	@Column(name="prodCommentRating")
	private Integer prodCommentRating;
	@Column(name="prodCommentContent")
	private String prodCommentContent;	
	@Column(name="prodCommentPic", columnDefinition = "longblob")
	private byte[] prodCommentPic;
	@Column(name="prodCommentTime")
	private java.sql.Timestamp prodCommentTime;
	@Column(name="restaurantReply")
	private String restaurantReply;
	@Column(name="restaurantReplyTime")
	private java.sql.Timestamp restaurantReplyTime;
	@Column(name="prodName")
	private String prodName;
	@Column(name="restaurantNo")
	private Integer restaurantNo;
	@Column(name="memberNo")
	private Integer memberNo;
	@Column(name="name")
	private String name;
	
	public ProdOrderDetailPK getId() {
		return new ProdOrderDetailPK(prodOrderNo, prodNo);
	}
	public void setId(ProdOrderDetailPK id) {
		this.prodOrderNo = id.getProdOrderNo();
		this.prodNo = id.getProdNo();
	}

	@Override
	public String toString() {
		return "ProdCommentReplyVO [prodOrderNo=" + prodOrderNo + ", prodNo=" + prodNo + ", prodQty=" + prodQty
				+ ", prodCommentRating=" + prodCommentRating + ", prodCommentContent=" + prodCommentContent
				+ ", prodCommentPic=" + Arrays.toString(prodCommentPic) + ", prodCommentTime=" + prodCommentTime
				+ ", restaurantReply=" + restaurantReply + ", restaurantReplyTime=" + restaurantReplyTime
				+ ", prodName=" + prodName + ", restaurantNo=" + restaurantNo + ", memberNo=" + memberNo + ", name="
				+ name + "]";
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
	public String getRestaurantReply() {
		return restaurantReply;
	}
	public void setRestaurantReply(String restaurantReply) {
		this.restaurantReply = restaurantReply;
	}
	public java.sql.Timestamp getRestaurantReplyTime() {
		return restaurantReplyTime;
	}
	public void setRestaurantReplyTime(java.sql.Timestamp restaurantReplyTime) {
		this.restaurantReplyTime = restaurantReplyTime;
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
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
