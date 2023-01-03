package com.tibame.tga104.order.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="v_RestCommentReply")
public class RestCommentReplyVO implements Serializable{
	private static final long serialVersionUID = -4849471799267054454L;
	
	@Id
	@Column(name = "reserveNo")
	private Integer reserveNo;
	@Column(name = "memberNo")
	private Integer memberNo;
	@Column(name = "reserveStatus")
	private String reserveStatus;
	@Column(name = "restaurantNo")
	private Integer restaurantNo;
	@Column(name = "reserveNum")
	private Integer reserveNum;
	@Column(name = "reserveDate")
	private java.sql.Date reserveDate;
	@Column(name = "reserveTime")
	private String reserveTime;
	@Column(name = "remark")
	private String remark;
	@Column(name = "commentRating")
	private Integer commentRating;
	@Column(name = "commentContent")
	private String commentContent;
	@Column(name = "commentPic", columnDefinition = "longblob")
	private byte[] commentPic;
	@Column(name = "restaurantCommentTime")
	private java.sql.Timestamp restaurantCommentTime;
	@Column(name = "restaurantRe")
	private String restaurantRe;
	@Column(name = "restaurantReTime")
	private java.sql.Timestamp restaurantReTime;
	@Column(name = "restaurantName")
	private String restaurantName;
	@Column(name = "name")
	private String name;
	@Override
	public String toString() {
		return "RestCommentReplyVO [reserveNo=" + reserveNo + ", memberNo=" + memberNo + ", reserveStatus="
				+ reserveStatus + ", restaurantNo=" + restaurantNo + ", reserveNum=" + reserveNum + ", reserveDate="
				+ reserveDate + ", reserveTime=" + reserveTime + ", remark=" + remark + ", commentRating="
				+ commentRating + ", commentContent=" + commentContent + ", commentPic=" + Arrays.toString(commentPic)
				+ ", restaurantCommentTime=" + restaurantCommentTime + ", restaurantRe=" + restaurantRe
				+ ", restaurantReTime=" + restaurantReTime + ", restaurantName=" + restaurantName + ", name=" + name
				+ "]";
	}
	public Integer getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(Integer reserveNo) {
		this.reserveNo = reserveNo;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public Integer getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public Integer getReserveNum() {
		return reserveNum;
	}
	public void setReserveNum(Integer reserveNum) {
		this.reserveNum = reserveNum;
	}
	public java.sql.Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(java.sql.Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCommentRating() {
		return commentRating;
	}
	public void setCommentRating(Integer commentRating) {
		this.commentRating = commentRating;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public byte[] getCommentPic() {
		return commentPic;
	}
	public void setCommentPic(byte[] commentPic) {
		this.commentPic = commentPic;
	}
	public java.sql.Timestamp getRestaurantCommentTime() {
		return restaurantCommentTime;
	}
	public void setRestaurantCommentTime(java.sql.Timestamp restaurantCommentTime) {
		this.restaurantCommentTime = restaurantCommentTime;
	}
	public String getRestaurantRe() {
		return restaurantRe;
	}
	public void setRestaurantRe(String restaurantRe) {
		this.restaurantRe = restaurantRe;
	}
	public java.sql.Timestamp getRestaurantReTime() {
		return restaurantReTime;
	}
	public void setRestaurantReTime(java.sql.Timestamp restaurantReTime) {
		this.restaurantReTime = restaurantReTime;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

