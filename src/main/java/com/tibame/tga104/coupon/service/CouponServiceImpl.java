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
		final CouponVO vo = dao.findByPrimaryKey(couponNo);
		if (vo != null ) {
			final byte[] couponPic = vo.getCouponPic();
			if (couponPic != null && couponPic.length != 0) {
				vo.setCouponPicStr(Base64.getEncoder().encodeToString(couponPic));
				vo.setCouponPic(null);
			}
		}
		return vo;
	}

	@Override
	public List<CouponVO> getAll() {
		return dao.getAll();
	}

	@Override
	public List<CouponVO> findByRestaurantNo(Integer restaurantNo) {
		List<CouponVO> list = dao.selectByRestaurantNo(restaurantNo);
		for (CouponVO vo : list) {
//			if (vo.getCouponType() != false) {
//				String amount = "折價";
//				amount = Boolean.toString(vo.getCouponType());
//			} else {
//				String fold = "打折";
//				fold = Boolean.toString(vo.getCouponType());
//			}
			final byte[] couponPic = vo.getCouponPic();
			if (couponPic != null && couponPic.length != 0) {
				vo.setCouponPicStr(Base64.getEncoder().encodeToString(couponPic));
				vo.setCouponPic(null);
			}
		}
		return list;
	}


	@Override
	public CouponVO insertCoupon(CouponVO couponVO) {
		final String couponPicStr = couponVO.getCouponPicStr();
		if (couponPicStr != null && !couponPicStr.isEmpty()) {
			couponVO.setCouponPic(Base64.getDecoder().decode(couponPicStr));
		}
		dao.insert(couponVO);
		return couponVO;
	}


	@Override
	public CouponVO insertByRestaurantNo(Integer restaurantNo) {
		CouponVO couponVO = new CouponVO();
		final String couponPicStr = couponVO.getCouponPicStr();
		if (couponPicStr != null && !couponPicStr.isEmpty()) {
			couponVO.setCouponPic(Base64.getDecoder().decode(couponPicStr));
		}
		dao.insertByRestaurantNo(restaurantNo);
		return couponVO;
	}


	@Override
	public List<CouponVO> getAllcouponPic() {
		List<CouponVO> list = dao.getAllCouponPic();
		for (CouponVO vo : list) {
			final byte[] couponPic = vo.getCouponPic();
			if (couponPic != null && couponPic.length != 0) {
				vo.setCouponPicStr(Base64.getEncoder().encodeToString(couponPic));
				vo.setCouponPic(null);
			}
		}
		return list;
	}

}
