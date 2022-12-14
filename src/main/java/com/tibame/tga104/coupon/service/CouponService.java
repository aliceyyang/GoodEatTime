package com.tibame.tga104.coupon.service;

import java.sql.Timestamp;
import java.util.List;

import com.tibame.tga104.coupon.vo.CouponVO;

public interface CouponService {

	CouponVO addCoupon(Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate, String couponName,
			Timestamp couponStartTime, Timestamp couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail);
	
	CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate, String couponName,
			Timestamp couponStartTime, Timestamp couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail);
	
	void deleteCoupon(Integer couponNo);
	
	CouponVO getOneCoupon(Integer couponNo);
	
	List<CouponVO> getAll();

	CouponVO updateCoupon(CouponVO couponVO);
	
}
