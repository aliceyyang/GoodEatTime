package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;
import com.tibame.tga104.member.vo.MemberVO;

public interface MemberCouponService {

	MemberCouponVO addOneCoupon(Integer memberNo, Integer couponNo);
	
	List<MemberCouponVO> getCouponBymemberNo(Integer memberNo);
	
	List<MemberCouponVO> getAll();

}
