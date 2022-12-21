package com.tibame.tga104.reservation.vo;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reservation")
public class ReservationVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserveNo")
	private Integer reserveNo;

	@Column(name = "memberNo")
	private Integer memberNo;

	@Column(name = "reserveStatus", insertable = false)
	private String reserveStatus;

	@Column(name = "restaurantNo")
	private Integer restaurantNo;

	@Column(name = "reserveNum")
	private Integer reserveNum;

	@Column(name = "reserveDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone= "GMT+8")
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
	private java.sql.Timestamp restaurantCommentTime;

	@Column(name = "restaurantRe")
	private String restaurantRe;

	@Column(name = "restaurantReTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
	private java.sql.Timestamp restaurantReTime;

	public ReservationVO() {

	}

	@Override
	public String toString() {
		return "ReservationVO [reserveNo=" + reserveNo + ", memberNo=" + memberNo + ", reserveStatus=" + reserveStatus
				+ ", restaurantNo=" + restaurantNo + ", reserveNum=" + reserveNum + ", reserveDate=" + reserveDate
				+ ", reserveTime=" + reserveTime + ", remark=" + remark + ", commentRating=" + commentRating
				+ ", commentContent=" + commentContent + ", commentPic=" + Arrays.toString(commentPic)
				+ ", restaurantCommentTime=" + restaurantCommentTime + ", restaurantRe=" + restaurantRe
				+ ", restaurantReTime=" + restaurantReTime + "]";
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

	public java.util.Date getRestaurantCommentTime() {
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

	public java.util.Date getRestaurantReTime() {
		return restaurantReTime;
	}

	public void setRestaurantReTime(java.sql.Timestamp restaurantReTime) {
		this.restaurantReTime = restaurantReTime;
	}

}
