package com.tibame.tga104.coupon.dao;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponDAO {

	public MemberCouponVO selectByMemberNo(Integer memberNo);

	public MemberCouponVO insert(MemberCouponVO memberCouponVO);
	
	public boolean update(MemberCouponVO memberCouponVO);
	
	public boolean delete(Integer memberNo);
	
	public List<MemberCouponVO> getAll();
}
