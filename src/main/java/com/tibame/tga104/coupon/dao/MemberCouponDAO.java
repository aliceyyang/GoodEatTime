package com.tibame.tga104.coupon.dao;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;

public interface MemberCouponDAO {

	public void insert(MemberCouponVO memberCouponVO);
	
	public void update(MemberCouponVO memberCouponVO);
	
	public void delete(Integer memberNo);
	
	public MemberCouponVO findByPrimaryKey(Integer memberCouponVO);
	
	public List<MemberCouponVO> getAll();

}