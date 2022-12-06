package com.tibame.tga104.coupon.service;

import java.util.List;

import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.dao.impl.MemberCouponDAOImpl;
import com.tibame.tga104.coupon.vo.MemberCouponVO;



public class MemberCouponServiceImpl implements MemberCouponService{
	
	private MemberCouponDAO dao;
	
	public MemberCouponServiceImpl() {
		dao = new MemberCouponDAOImpl();
	}

	@Override
	public MemberCouponVO addMemberCoupon(Integer memberNo, Integer couponNo, Boolean usageStatus) {

		MemberCouponVO memberCouponVO = new MemberCouponVO();

		memberCouponVO.setMemberNo(memberNo);
		memberCouponVO.setCouponNo(couponNo);
		memberCouponVO.setUsageStatus(usageStatus);
		dao.insert(memberCouponVO);
		
		return memberCouponVO;
	}

	@Override
	public MemberCouponVO updateMemberCoupon(Integer memberNo, Integer couponNo, Boolean usageStatus) {
		
		MemberCouponVO memberCouponVO = new MemberCouponVO();
		memberCouponVO.setMemberNo(memberNo);
		memberCouponVO.setCouponNo(couponNo);
		memberCouponVO.setUsageStatus(usageStatus);
		
		dao.update(memberCouponVO);
		return memberCouponVO;
	}

	@Override
	public MemberCouponVO deleteMemberCoupon(StringBuffer errormsg, Integer memberNo) {

		if(memberNo == null) {
			errormsg.append("請輸入會員編號");
			return null;
		} else {
			return dao.findByPrimaryKey(memberNo);
		}
	}

	@Override
	public MemberCouponVO getOneMemberCoupon(StringBuffer errormsg, Integer memberNo) {
		if(memberNo == null) {
			errormsg.append("請輸入會員編號");
			return null;
		} else {
			return dao.findByPrimaryKey(memberNo);
		}
	}

	@Override
	public List<MemberCouponVO> getAll() {
		return dao.getAll();
	}

}
