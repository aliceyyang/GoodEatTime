package coupon.service;

import java.util.List;

import coupon.vo.CouponVO;

public interface CouponService {

	CouponVO addCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName, String couponStartTime, String couponEndTime, 
			Boolean verified, String couponContent, Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty, String verificationDetail);
	
	CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName, String couponStartTime, String couponEndTime, 
			Boolean verified, String couponContent, Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty, String verificationDetail);
	
	void deleteCoupon(StringBuffer errormsg, Integer couponNo);
	
	CouponVO getOneCoupon(StringBuffer errormsg,  Integer couponNo);
	
	List<CouponVO> getAll();
}
