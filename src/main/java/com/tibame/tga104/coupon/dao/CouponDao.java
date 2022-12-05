package com.tibame.tga104.coupon.dao;

import java.util.List;

import com.tibame.tga104.coupon.vo.CouponVO;

public interface CouponDao {

	public void insert(CouponVO couponVO);
	
	public void update(CouponVO couponVO);

	public void delete(Integer couponNo);
	
	public CouponVO findByPrimaryKey(Integer CouponVO);
	
	public List<CouponVO> getAll();

}
