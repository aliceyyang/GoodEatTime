package com.tibame.tga104.restaurant.vo;

import java.io.Serializable;
import java.util.Arrays;

public class RestaurantPostVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer restaurantPostNo;
	private Integer restaurantNo;
	private String postType;
	private byte[] postPic;
	private String postPicStr;
	private String postTitle;
	private String postContent;
	
	public RestaurantPostVO() {
		
	}
	

	
	
	public RestaurantPostVO(Integer restaurantPostNo, Integer restaurantNo, String postType, byte[] postPic,
			String postPicStr, String postTitle, String postContent) {
		super();
		this.restaurantPostNo = restaurantPostNo;
		this.restaurantNo = restaurantNo;
		this.postType = postType;
		this.postPic = postPic;
		this.postPicStr = postPicStr;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}
	@Override
	public String toString() {
		return "RestaurantPostVO [restaurantPostNo=" + restaurantPostNo + ", restaurantNo=" + restaurantNo
				+ ", postType=" + postType + ", postPic=" + Arrays.toString(postPic) + ", postPicStr=" + postPicStr
				+ ", postTitle=" + postTitle + ", postContent=" + postContent + "]";
	}
	
	public Integer getRestaurantPostNo() {
		return restaurantPostNo;
	}
	public void setRestaurantPostNo(Integer restaurantPostNo) {
		this.restaurantPostNo = restaurantPostNo;
	}
	public Integer getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public byte[] getPostPic() {
		return postPic;
	}
	public void setPostPic(byte[] postPic) {
		this.postPic = postPic;
	}
	public String getPostPicStr() {
		return postPicStr;
	}
	public void setPostPicStr(String postPicStr) {
		this.postPicStr = postPicStr;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	
	

}
