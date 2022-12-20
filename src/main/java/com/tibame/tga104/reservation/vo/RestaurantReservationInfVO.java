package com.tibame.tga104.reservation.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name= "v_restaurant_reservation")
public class RestaurantReservationInfVO {
	

	@Id
	@Column(name="reserveNo")
	private Integer reserveNo;
	
	@Column(name="restaurantNo")
	private Integer restaurantNo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="reserveDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone= "GMT+8")
	private java.sql.Date reserveDate;
	
	@Column(name="reserveTime")
	private String reserveTime;
	
	@Column(name="reserveNum")
	private Integer reserveNum;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="remark")
	private String remark;
	
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

	@Column(name="mail")
	private String mail;
	
	@Column(name="reserveStatus")
	private String reserveStatus;


	
	@Override
	public String toString() {
		return "RestaurantReservationInfVO [reserveNo=" + reserveNo + ", restaurantNo=" + restaurantNo + ", name="
				+ name + ", reserveDate=" + reserveDate + ", reserveTime=" + reserveTime + ", reserveNum=" + reserveNum
				+ ", tel=" + tel + ", remark=" + remark + ", mail=" + mail + ", reserveStatus=" + reserveStatus + "]";
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	
	
	
}
