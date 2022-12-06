package com.tibame.tga104.reservation.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserveTime")
public class ReserveTimeVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserveTimeNo")
	private Integer reserveTimeNo;
	
	@Column(name="restaurantNo")
	private Integer restaurantNo;
	
	@Column(name="reserveTime")
	private String reserveTime;
	
	@Column(name="weekDay")
	private Integer weekDay;
	
	@Column(name="allowReserveNum")
	private Integer allowReserveNum;

	public ReserveTimeVO() {

	}

	@Override
	public String toString() {
		return "ReserveTimeVO [reserveTimeNo=" + reserveTimeNo + ", restaurantNo=" + restaurantNo + ", reserveTime="
				+ reserveTime + ", weekDay=" + weekDay + ", allowReserveNum=" + allowReserveNum + "]";
	}

	public Integer getReserveTimeNo() {
		return reserveTimeNo;
	}

	public void setReserveTimeNo(Integer reserveTimeNo) {
		this.reserveTimeNo = reserveTimeNo;
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public Integer getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}

	public Integer getAllowReserveNum() {
		return allowReserveNum;
	}

	public void setAllowReserveNum(Integer allowReserveNum) {
		this.allowReserveNum = allowReserveNum;
	}

}
