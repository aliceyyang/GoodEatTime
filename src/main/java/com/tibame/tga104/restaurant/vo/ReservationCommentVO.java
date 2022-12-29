package com.tibame.tga104.restaurant.vo;

import java.sql.Timestamp;
import java.util.Arrays;

public class ReservationCommentVO {
	
	private Integer reserveNo;
	private String name;
	private byte[] memberPic;
	private Integer commentRating;
	private String commentContent;
	private byte[] commentPic;
	private java.sql.Timestamp restaurantCommentTime;
	private String restaurantRe;
	private java.sql.Timestamp restaurantReTime;
	private String memberPicStr;
	private String commentPicStr;
	
	
	public ReservationCommentVO() {
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "ReservationCommentVO [reserveNo=" + reserveNo + ", name=" + name + ", memberPic="
				+ Arrays.toString(memberPic) + ", commentRating=" + commentRating + ", commentContent=" + commentContent
				+ ", commentPic=" + Arrays.toString(commentPic) + ", restaurantCommentTime=" + restaurantCommentTime
				+ ", restaurantRe=" + restaurantRe + ", restaurantReTime=" + restaurantReTime + ", memberPicStr="
				+ memberPicStr + ", commentPicStr=" + commentPicStr + "]";
	}





	public ReservationCommentVO(Integer reserveNo, String name, byte[] memberPic, Integer commentRating,
			String commentContent, byte[] commentPic, Timestamp restaurantCommentTime, String restaurantRe,
			Timestamp restaurantReTime, String memberPicStr, String commentPicStr) {
		super();
		this.reserveNo = reserveNo;
		this.name = name;
		this.memberPic = memberPic;
		this.commentRating = commentRating;
		this.commentContent = commentContent;
		this.commentPic = commentPic;
		this.restaurantCommentTime = restaurantCommentTime;
		this.restaurantRe = restaurantRe;
		this.restaurantReTime = restaurantReTime;
		this.memberPicStr = memberPicStr;
		this.commentPicStr = commentPicStr;
	}





	public Integer getReserveNo() {
		return reserveNo;
	}


	public void setReserveNo(Integer reserveNo) {
		this.reserveNo = reserveNo;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getMemberPic() {
		return memberPic;
	}
	public void setMemberPic(byte[] memberPic) {
		this.memberPic = memberPic;
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
	public String getMemberPicStr() {
		return memberPicStr;
	}
	public void setMemberPicStr(String memberPicStr) {
		this.memberPicStr = memberPicStr;
	}
	public String getCommentPicStr() {
		return commentPicStr;
	}
	public void setCommentPicStr(String commentPicStr) {
		this.commentPicStr = commentPicStr;
	}
	
	
	

}
