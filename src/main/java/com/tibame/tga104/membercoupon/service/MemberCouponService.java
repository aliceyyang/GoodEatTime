package com.tibame.tga104.membercoupon.service;

import java.util.List;

import com.tibame.tga104.membercoupon.vo.MemberCouponVO;

public interface MemberCouponService {
	
	MemberCouponVO addMemberCoupn(Integer memberNo, Integer couponNo, Boolean usageStatus);
	
	MemberCouponVO updateMemberCoupon(Integer memberNo, Integer couponNo, Boolean usageStatus);
	
	void deleteMemberCoupon(Integer memberNo);
	
	MemberCouponVO getOneMemeberCoupon(Integer memberNo);
	
	List<MemberCouponVO> geAll();
	
}
