package com.tibame.tga104.reservation.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="v_reservation")
public class ReservationDetailVO implements Serializable{
	@Id
	@Column(name = "restaurantNo")
	private Integer restaurantNo;
	
	@Column(name="weekDay")
	private Integer weekDay;
	@Id
	@Column(name="reserveDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone= "GMT+8")
	private java.sql.Date reserveDate;
	@Id
	@Column(name="reserveTime")
	private String reserveTime;
	
	@Column(name="allowReserveNum")
	private Integer allowReserveNum;
	
	@Column(name="totalReserveNum", columnDefinition = "decimal")
	private Integer totalReserveNum;
	
	@Column(name="availableSeats", columnDefinition = "decimal")
	private Integer availableSeats;

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public Integer getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
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
