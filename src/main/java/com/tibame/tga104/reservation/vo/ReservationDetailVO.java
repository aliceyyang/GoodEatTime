package com.tibame.tga104.reservation.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="v_reservation")
public class ReservationDetailVO {
	@Id
	@Column(name = "restaurantNo")
	private Integer restaurantNo;
	
	@Column(name="reserveDate")
	private java.sql.Date reserveDate;
	
	@Column(name="reserveTime")
	private String reserveTime;
	
	@Column(name="allowReserveNum")
	private Integer allowReserveNum;
	
	@Column(name="totalReserveNum")
	private Integer totalReserveNum;
	
	@Column(name="availableSeats")
	private Integer availableSeats;

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
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

	public Integer getAllowReserveNum() {
		return allowReserveNum;
	}

	public void setAllowReserveNum(Integer allowReserveNum) {
		this.allowReserveNum = allowReserveNum;
	}

	public Integer getTotalReserveNum() {
		return totalReserveNum;
	}

	public void setTotalReserveNum(Integer totalReserveNum) {
		this.totalReserveNum = totalReserveNum;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	
}
