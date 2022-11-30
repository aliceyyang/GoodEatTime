package coupon.service;

import java.util.List;

import coupon.vo.CouponVO;

public interface CouponService {

	CouponVO addCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName, String couponStartTime, String couponEndTime, 
			Boolean verified, String couponContent, Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty, String verificationDetail);
	
	CouponVO updaCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName, String couponStartTime, String couponEndTime, 
			Boolean verified, String couponContent, Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty, String verificationDetail);
	
	void deleteCoupon(Integer couponNo);
	
	CouponVO getOneCoupon(Integer couponNo);
	
	List<CouponVO> getAll();
}
