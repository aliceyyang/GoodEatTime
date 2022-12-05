package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.dao.CouponDao;
import com.tibame.tga104.coupon.dao.impl.CouponDaoImpl;
import com.tibame.tga104.coupon.vo.CouponVO;

public class CouponServiceImpl implements CouponService {

	private CouponDao dao;

	public CouponServiceImpl() {
		dao = new CouponDaoImpl();
	}

	@Override
	public CouponVO addCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName,
			String couponStartTime, String couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail) {

		CouponVO couponVO = new CouponVO();

		couponVO.setRestaurantNo(restaurantNo);
		couponVO.setAdminNo(adminNo);
		couponVO.setCouponApplyDate(couponApplyDate);
		couponVO.setCouponName(couponName);
		couponVO.setCouponStartTime(couponStartTime);
		couponVO.setCouponEndTime(couponEndTime);
		couponVO.setVerified(verified);
		couponVO.setCouponContent(couponContent);
		couponVO.setUsageLimitation(usageLimitation);
		couponVO.setAmountOrFold(amountOrFole);
		couponVO.setMaxIssueQty(maxIssueQty);
		couponVO.setIssuedQty(issuedQty);
		couponVO.setVerificationDetail(verificationDetail);
		dao.insert(couponVO);

		return couponVO;
	}

	@Override
	public CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, String couponApplyDate, String couponName,
			String couponStartTime, String couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail) {

		CouponVO couponVO = new CouponVO();
		couponVO.setRestaurantNo(restaurantNo);
		couponVO.setAdminNo(adminNo);
		couponVO.setCouponApplyDate(couponApplyDate);
		couponVO.setCouponName(couponName);
		couponVO.setCouponStartTime(couponStartTime);
		couponVO.setCouponEndTime(couponEndTime);
		couponVO.setVerified(verified);
		couponVO.setCouponContent(couponContent);
		couponVO.setUsageLimitation(usageLimitation);
		couponVO.setAmountOrFold(amountOrFole);
		couponVO.setMaxIssueQty(maxIssueQty);
		couponVO.setIssuedQty(issuedQty);
		couponVO.setVerificationDetail(verificationDetail);
		dao.update(couponVO);

		return couponVO;

	}

	@Override
	public void deleteCoupon(StringBuffer errormsg, Integer couponNo) {
		if (couponNo == null) {
			errormsg.append("請輸入優惠券號碼");
		} else {
			dao.delete(couponNo);
		}

	}

	@Override
	public CouponVO getOneCoupon(StringBuffer errormsg, Integer couponNo) {
		if (couponNo == null) {
			errormsg.append("請輸入優惠券號碼");
			return null;
		} else {
			return dao.findByPrimaryKey(couponNo);
		}
	}

	@Override
	public List<CouponVO> getAll() {
		return dao.getAll();
	}
}
