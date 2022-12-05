package com.tibame.tga104.membercoupon.service;

import java.util.List;

import com.tibame.tga104.membercoupon.dao.MemberCouponDAO;
import com.tibame.tga104.membercoupon.dao.impl.MemberCouponImpl;
import com.tibame.tga104.membercoupon.vo.MemberCouponVO;

public class MemberCouponServiceImpl implements MemberCouponService{

	private MemberCouponDAO dao;
	
	public MemberCouponServiceImpl() {
		dao = new MemberCouponImpl();
	}
	
	
	@Override
	public MemberCouponVO addMemberCoupn(Integer memberNo, Integer couponNo, Boolean usageStatus) {
		MemberCouponVO membercouponVO = new MemberCouponVO();
		
		membercouponVO.setMemberNo(memberNo);
		membercouponVO.setCouponNo(couponNo);
		membercouponVO.setUsageStatus(usageStatus);
		dao.insert(membercouponVO);
		
		return membercouponVO;
	}

	@Override
	public MemberCouponVO updateMemberCoupon(Integer memberNo, Integer couponNo, Boolean usageStatus) {
	
		MemberCouponVO memberCouponVO = new MemberCouponVO();
		memberCouponVO.setCouponNo(couponNo);
		memberCouponVO.setCouponNo(couponNo);
		memberCouponVO.setUsageStatus(usageStatus);
		dao.update(memberCouponVO);
		
		return memberCouponVO;
	}

	@Override
	public void deleteMemberCoupon(Integer memberNo) {

		dao.delete(memberNo);
	}

	@Override
	public MemberCouponVO getOneMemeberCoupon(Integer memberNo) {
		return dao.findByPrimaryKey(memberNo);
	}

	@Override
	public List<MemberCouponVO> geAll() {
		return dao.getAll();
	}
}
