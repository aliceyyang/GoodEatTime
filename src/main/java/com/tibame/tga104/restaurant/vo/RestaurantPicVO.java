package com.tibame.tga104.restaurant.vo;

import java.io.Serializable;
import java.util.Arrays;

public class RestaurantPicVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer restaurantPicNo;
	private Integer restaurantNo;
	private byte[] restaurantPic;
	private String restaurantPicRemark;
	private String restaurantPicStr;
	
	public RestaurantPicVO() {
		
	}

	@Override
	public String toString() {
		return "RestaurantPicVo [restaurantPicNo=" + restaurantPicNo + ", restaurantNo=" + restaurantNo
				+ ", restaurantPic=" + Arrays.toString(restaurantPic) + ", restaurantPicRemark=" + restaurantPicRemark
				+ "]";
	}
	

	public Integer getRestaurantPicNo() {
		return restaurantPicNo;
	}

	public void setRestaurantPicNo(Integer restaurantPicNo) {
		this.restaurantPicNo = restaurantPicNo;
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public byte[] getRestaurantPic() {
		return restaurantPic;
	}

	public void setRestaurantPic(byte[] restaurantPic) {
		this.restaurantPic = restaurantPic;
	}

	public String getRestaurantPicRemark() {
		return restaurantPicRemark;
	}

	public void setRestaurantPicRemark(String restaurantPicRemark) {
		this.restaurantPicRemark = restaurantPicRemark;
	}

	public String getRestaurantPicStr() {
		return restaurantPicStr;
	}

	public void setRestaurantPicStr(String restaurantPicStr) {
		this.restaurantPicStr = restaurantPicStr;
	}
}
