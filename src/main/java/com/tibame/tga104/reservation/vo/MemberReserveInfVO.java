package com.tibame.tga104.reservation.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="v_memeber_reservation")
public class MemberReserveInfVO {
	
	@Id
	@Column(name= "reserveNo")
	private Integer reserveNo;
	
	@Column(name="memberNo")
	private Integer memberNo;

	@Column(name="restaurantName")
	private String restaurantName;
	
	@Column(name="reserveNum")
	private Integer reserveNum;
	
	@Column(name="reserveDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone= "GMT+8")
	private java.sql.Date reserveDate;
	
	@Column(name="reserveTime")
	private String reserveTime;
	
	@Column(name="remark")
	private String remark;

	public Integer getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(Integer reserveNo) {
		this.reserveNo = reserveNo;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(Integer reserveNum) {
		this.reserveNum = reserveNum;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
}
