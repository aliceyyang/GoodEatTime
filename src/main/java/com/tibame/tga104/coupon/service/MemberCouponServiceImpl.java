package com.tibame.tga104.coupon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.vo.MemberCouponVO;
import com.tibame.tga104.member.vo.MemberVO;


@Service
@Transactional
public class MemberCouponServiceImpl implements MemberCouponService{
	@Autowired
	private MemberCouponDAO dao;
	
	

	@Override
	public MemberCouponVO addOneCoupon(Integer memberNo, Integer couponNo) {
		return dao.insert(memberNo , couponNo);
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


