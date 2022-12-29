package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponService {

	MemberCouponVO addOneCoupon(Integer couponNo);
	
	List<MemberCouponVO> getCouponBymemberNo(Integer memberNo);
	
	List<MemberCouponVO> getAll();
}
