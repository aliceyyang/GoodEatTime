package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.OrderSearchVO;

public interface OrderSearchDAO_interface {
	
	public OrderSearchVO select(Integer prodOrderNo);

	List<OrderSearchVO> selectByConditions(OrderSearchVO prodOrderVO);
	
	public List<OrderSearchVO> getAll();

}