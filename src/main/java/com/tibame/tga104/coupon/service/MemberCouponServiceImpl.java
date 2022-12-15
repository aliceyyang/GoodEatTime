package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.dao.impl.MemberCouponDAOHibernate;
import com.tibame.tga104.coupon.vo.MemberCouponVO;



public class MemberCouponServiceImpl implements MemberCouponService{

	private MemberCouponDAO dao;
	
	public MemberCouponServiceImpl() {
		dao = new MemberCouponDAOHibernate();
	}
	
	@Override
	public MemberCouponVO updateusageStatus(Boolean usageStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberCouponVO getOneMemberCoupon(MemberCouponVO memberCouponVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberCouponVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}


