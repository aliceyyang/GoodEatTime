package com.tibame.tga104.coupon.service;

import java.util.List;
import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.vo.MemberCouponVO;



public class MemberCouponServiceImpl implements MemberCouponService{

	private MemberCouponDAO dao;
	
	

	@Override
	public MemberCouponVO updateusageStatus(Integer memberNo, Integer couponNo) {
		MemberCouponVO vo = new MemberCouponVO();
		vo.setUsageStatus(vo.getUsageStatus());
		dao.update(vo);
		return vo;
	}

	@Override
	public MemberCouponVO getOneMemberCoupon(Integer memberNo, Integer couponNo) {
		return dao.select(memberNo);
	}

	@Override
	public List<MemberCouponVO> getAll() {
		return dao.getAll();
	}
	
}


