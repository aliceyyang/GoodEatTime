package com.tibame.tga104.coupon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.vo.MemberCouponVO;


@Service
@Transactional
public class MemberCouponServiceImpl implements MemberCouponService{
	@Autowired
	private MemberCouponDAO dao;
	
	

	@Override
	public MemberCouponVO addOneCoupon(Integer couponNo) {
		return dao.insert(null);
	}

	@Override
	public List<MemberCouponVO> getCouponBymemberNo(Integer memberNo) {
		return dao.selectAllCouponByMemberNo(memberNo);
	}

	@Override
	public List<MemberCouponVO> getAll() {
		return dao.getAll();
	}
	
}


