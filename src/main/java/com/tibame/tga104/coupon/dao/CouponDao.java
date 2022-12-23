package com.tibame.tga104.coupon.dao;

import java.util.List;

import com.tibame.tga104.coupon.vo.CouponVO;

public interface CouponDao {
	
	public CouponVO findByPrimaryKey(Integer CouponVO);
	
	public CouponVO insert(CouponVO couponVO);
	
	public void updateByCouponNo(CouponVO couponVO);

	public void delete(Integer couponNo);
		
	public List<CouponVO> getAll();
	
	public List<CouponVO> selectByRestaurantNo(Integer restaurantNo);
	
	public CouponVO insertByRestaurantNo(Integer restaurantNo);
	
	public CouponVO searchByRestaurantNo(Integer restaurantNo);
	
}
