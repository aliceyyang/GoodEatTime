package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.OrderSearchVO;

public interface OrderSearchDAO_interface {
	
	public OrderSearchVO select(Integer prodOrderNo);
	
	public List<OrderSearchVO> selectByProdOrderNo(Integer prodOrderNo);

	public List<OrderSearchVO> selectByConditions(OrderSearchVO orderSearchVO);
	
	public List<OrderSearchVO> selectByMemberNo(Integer memberNo);
	
	public List<OrderSearchVO> selectByRestaurantNo(Integer restaurantNo);

	public List<OrderSearchVO> getAll();

}