package com.tibame.tga104.membercoupon.dao;

import java.util.List;

import com.tibame.tga104.membercoupon.vo.MemberCouponVO;

public interface MemberCouponDAO{

	public void insert(MemberCouponVO membercouponVO);
	
	public void update(MemberCouponVO membercoponVO);
	
	public void delete(Integer memberNo);
	
	public MemberCouponVO findByPrimaryKey(Integer memberNo);
	
	public List<MemberCouponVO> getAll();
}
