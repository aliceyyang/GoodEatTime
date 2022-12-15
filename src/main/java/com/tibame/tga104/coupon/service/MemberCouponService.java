package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponService {

		
	MemberCouponVO updateusageStatus(Boolean usageStatus);
	
	MemberCouponVO getOneMemberCoupon(MemberCouponVO memberCouponVO);
	
	List<MemberCouponVO> getAll();
}
