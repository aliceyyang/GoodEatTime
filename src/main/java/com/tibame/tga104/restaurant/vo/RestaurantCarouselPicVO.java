package com.tibame.tga104.restaurant.vo;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.stereotype.Component;


public class RestaurantCarouselPicVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer carouselPicNo;
	private Integer restaurantNo;
	private byte[] carouselPic;
	private String carouselPicStr;
	
	
	
	public RestaurantCarouselPicVO(Integer carouselPicNo, Integer restaurantNo, byte[] carouselPic,
			String carouselPicStr) {
		super();
		this.carouselPicNo = carouselPicNo;
		this.restaurantNo = restaurantNo;
		this.carouselPic = carouselPic;
		this.carouselPicStr = carouselPicStr;
	}

	@Override
	public String toString() {
		return "RestaurantCarouselPicVO [carouselPicNo=" + carouselPicNo + ", restaurantNo=" + restaurantNo
				+ ", carouselPic=" + Arrays.toString(carouselPic) + "]";
	}

	public RestaurantCarouselPicVO() {
		
	}

	public Integer getCarouselPicNo() {
		return carouselPicNo;
	}

	public void setCarouselPicNo(Integer carouselPicNo) {
		this.carouselPicNo = carouselPicNo;
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public byte[] getCarouselPic() {
		return carouselPic;
	}

	public void setCarouselPic(byte[] carouselPic) {
		this.carouselPic = carouselPic;
	}

	public String getCarouselPicStr() {
		return carouselPicStr;
	}

	public void setCarouselPicStr(String carouselPicStr) {
		this.carouselPicStr = carouselPicStr;
	}
	
	
	
	

}
