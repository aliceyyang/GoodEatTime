package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponService {

	MemberCouponVO updateusageStatus(Integer memberNo, Integer coupponNo);
	
	MemberCouponVO getOneMemberCoupon(Integer memberCouponVO, Integer couponNo);
	
	List<MemberCouponVO> getAll();
}
