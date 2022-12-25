package com.tibame.tga104.member.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tibame.tga104.core.vo.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//使用辣椒之後可對照下列setter/getter/無參數建構子/所有有參數之建構子
@Setter 
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class RestaurantRegistVO extends Message{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurantNo")
	private Integer restaurantNo;
	
	@Column(name = "restaurantName")
	private String restaurantName;
	
	@Column(name = "restaurantTel")
	private String restaurantTel;
	
	@Column(name = "restaurantAddr")
	private String restaurantAddr;
	
	@Column(name = "restaurantAccount")
	private String restaurantAccount;
	
	@Column(name = "restaurantPassword")
	private String restaurantPassword;
	
}
