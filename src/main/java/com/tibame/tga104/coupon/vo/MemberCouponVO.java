package com.tibame.tga104.coupon.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberCoupon")
public class MemberCouponVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "memberNo", nullable = false)
	private Integer memberNo;
	
	@Id
	@Column(name = "couponNo", nullable = false)
	private Integer couponNo;
	
	@Column(name = "usageStatus", columnDefinition = "Integer")
	private Boolean usageStatus;

	public MemberCouponVO() {

	}

	@Override
	public String toString() {
		return "MemberCouponVO [memberNo=" + memberNo + ", couponNo=" + couponNo + ", usageStatus=" + usageStatus + "]";
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(Integer couponNo) {
		this.couponNo = couponNo;
	}

	public Boolean getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(Boolean usageStatus) {
		this.usageStatus = usageStatus;
	}

}
