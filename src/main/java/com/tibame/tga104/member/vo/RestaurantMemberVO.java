package com.tibame.tga104.member.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tibame.tga104.core.vo.Message;


@Entity
@Table(name = "restaurant")

public class RestaurantMemberVO extends Message {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurantNo")
	private Integer restaurantNo;
	
	@Column(name = "restaurantAccount")
	private String restaurantAccount;
	
	@Column(name = "restaurantPassword")
	private String restaurantPassword;
	
	@Column(name = "restaurantName")
	private String restaurantName;

	@Override
	public String toString() {
		return "RestaurantMemberVO [restaurantNo=" + restaurantNo + ", restaurantAccount=" + restaurantAccount
				+ ", restaurantPassword=" + restaurantPassword + ", restaurantName=" + restaurantName + "]";
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantAccount() {
		return restaurantAccount;
	}

	public void setRestaurantAccount(String restaurantAccount) {
		this.restaurantAccount = restaurantAccount;
	}

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	
	
	
	
	

}
