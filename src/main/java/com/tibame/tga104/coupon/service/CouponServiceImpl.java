package com.tibame.tga104.coupon.service;

import java.sql.Timestamp;
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
	public CouponVO addCoupon(Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate, String couponName,
			Timestamp couponStartTime, Timestamp couponEndTime, Boolean verified, String couponContent,
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

//	public CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate, String couponName,
//			Timestamp couponStartTime, Timestamp couponEndTime, Boolean verified, String couponContent,
//			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
//			String verificationDetail) {
	@Override
	public CouponVO updateCoupon(CouponVO couponVO) {	
		dao.update(couponVO);
		return couponVO;
	}

	@Override
	public void deleteCoupon(Integer couponNo) {
			dao.delete(couponNo);
		}


	@Override
	public CouponVO getOneCoupon(Integer couponNo) {
			return dao.findByPrimaryKey(couponNo);
		}

	@Override
	public List<CouponVO> getAll() {
		return dao.getAll();
	}

	@Override
	public CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate, String couponName,
			Timestamp couponStartTime, Timestamp couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
