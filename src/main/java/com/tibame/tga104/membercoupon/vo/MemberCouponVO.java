package com.tibame.tga104.membercoupon.vo;

import java.io.Serializable;

public class MemberCouponVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer memberNo;
	private Integer couponNo;
	private Boolean usageStatus;
	
	public MemberCouponVO() {
		super();
	}

	public MemberCouponVO(Integer memberNo, Integer couponNo, Boolean usageStatus) {
		super();
		this.memberNo = memberNo;
		this.couponNo = couponNo;
		this.usageStatus = usageStatus;
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
