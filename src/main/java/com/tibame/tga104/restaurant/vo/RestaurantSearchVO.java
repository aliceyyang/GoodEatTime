package com.tibame.tga104.restaurant.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_restaurantpic")
public class RestaurantSearchVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="restaurantNo")
	private Integer restaurantNo;

	@Column(name = "restaurantPic")
	private byte[] restaurantPic;
	
	@Column(name = "restaurantName")
	private String restaurantName;
	
	@Column(name = "restaurantTel")
	private Integer restaurantTel;
	
	@Column(name = "restaurantAddr")
	private String restaurantAddr;
	
	@Column(name = "restaurantBusinessHour")
	private String restaurantBusinessHour;
	
	@Column(name = "restaurantCommentQuantity")
	private Integer restaurantCommentQuantity;
	
	@Column(name = "totalCommentRating")
	private Integer totalCommentRating;

	@Override
	public String toString() {
		return "RestaurantSearchVO [restaurantPic=" + Arrays.toString(restaurantPic) + ", restaurantName="
				+ restaurantName + ", restaurantTel=" + restaurantTel + ", restaurantAddr=" + restaurantAddr
				+ ", restaurantBusinessHour=" + restaurantBusinessHour + ", restaurantCommentQuantity="
				+ restaurantCommentQuantity + ", totalCommentRating=" + totalCommentRating + "]";
	}

	public byte[] getRestaurantPic() {
		return restaurantPic;
	}

	public void setRestaurantPic(byte[] restaurantPic) {
		this.restaurantPic = restaurantPic;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRestaurantTel() {
		return restaurantTel;
	}

	public void setRestaurantTel(Integer restaurantTel) {
		this.restaurantTel = restaurantTel;
	}

	public String getRestaurantAddr() {
		return restaurantAddr;
	}

	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}

	public String getRestaurantBusinessHour() {
		return restaurantBusinessHour;
	}

	public void setRestaurantBusinessHour(String restaurantBusinessHour) {
		this.restaurantBusinessHour = restaurantBusinessHour;
	}

	public Integer getRestaurantCommentQuantity() {
		return restaurantCommentQuantity;
	}

	public void setRestaurantCommentQuantity(Integer restaurantCommentQuantity) {
		this.restaurantCommentQuantity = restaurantCommentQuantity;
	}

	public Integer getTotalCommentRating() {
		return totalCommentRating;
	}

	public void setTotalCommentRating(Integer totalCommentRating) {
		this.totalCommentRating = totalCommentRating;
	}
	
	
}
