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
	public MemberCouponVO updateusageStatus(Integer memberNo, Integer couponNo) {
		MemberCouponVO vo = new MemberCouponVO();
		vo.setUsageStatus(vo.getUsageStatus());
		dao.update(vo);
		return vo;
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


