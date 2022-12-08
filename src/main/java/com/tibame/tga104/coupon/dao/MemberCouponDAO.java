package com.tibame.tga104.coupon.dao;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponDAO {

	public MemberCouponVO insert(MemberCouponVO memberCouponVO);
	
	public MemberCouponVO update(MemberCouponVO memberCouponVO);
	
	public Boolean usageStatus(Boolean usageStatus);
	
	public MemberCouponVO findByPrimaryKey(Integer memberNo);
	
	public List<MemberCouponVO> getAll();

}
