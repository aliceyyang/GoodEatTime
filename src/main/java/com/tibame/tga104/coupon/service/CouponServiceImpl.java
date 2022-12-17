package com.tibame.tga104.coupon.service;

import java.util.Base64;
import java.util.List;

import com.tibame.tga104.coupon.dao.CouponDao;
import com.tibame.tga104.coupon.dao.impl.CouponDaoImpl;
import com.tibame.tga104.coupon.vo.CouponVO;

public class CouponServiceImpl implements CouponService {

	private CouponDao dao;

	public CouponServiceImpl() {
		dao = new CouponDaoImpl();
	}

//	public CouponVO updateCoupon(Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate, String couponName,
//			Timestamp couponStartTime, Timestamp couponEndTime, Boolean verified, String couponContent,
//			Integer usageLimitation, Double amountOrFole, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
//			String verificationDetail) {
	@Override
	public CouponVO updateCoupon(CouponVO couponVO) {
		final String couponPicStr = couponVO.getCouponPicStr();
		if (couponPicStr != null && !couponPicStr.isEmpty()) {
			couponVO.setCouponPic(Base64.getDecoder().decode(couponPicStr));
		}
		dao.updateByCouponNo(couponVO);
		return couponVO;
	}

	@Override
	public void deleteCoupon(Integer couponNo) {
		dao.delete(couponNo);
	}

	@Override
	public CouponVO getOneCoupon(Integer couponNo) {
		CouponVO vo = dao.findByPrimaryKey(couponNo);
		final byte[] couponPic = vo.getCouponPic();
		if (couponPic != null && couponPic.length != 0) {
			vo.setCouponPicStr(Base64.getEncoder().encodeToString(vo.getCouponPic()));
			vo.setCouponPic(null);
		}
		return vo;
	}

	@Override
	public List<CouponVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<CouponVO> findByRestaurantNo(Integer restaurantNo) {
		return dao.selectByRestaurantNo(restaurantNo);
	}

}
