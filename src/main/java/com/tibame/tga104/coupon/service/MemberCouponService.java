package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponService {

	MemberCouponVO addMemberCoupon(Integer memberNo, Integer couponNo, Boolean usageStatus);
		
	MemberCouponVO updateMemberCoupon(Integer memberNo, Integer couponNo, Boolean usageStatus);
	
	MemberCouponVO deleteMemberCoupon(StringBuffer String ,Integer memberNo);
	
	MemberCouponVO getOneMemberCoupon(StringBuffer String,Integer memberNo);
	
	List<MemberCouponVO> getAll();
}
