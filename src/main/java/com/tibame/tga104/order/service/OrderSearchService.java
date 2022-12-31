package com.tibame.tga104.order.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga104.order.dao.OrderSearchDAO_interface;
import com.tibame.tga104.order.vo.OrderSearchVO;

@Service
public class OrderSearchService {
	
	@Autowired
	private OrderSearchDAO_interface dao;
	
	public List<OrderSearchVO> findByConditions(OrderSearchVO orderSearchVO) {
		if (orderSearchVO == null) {
			return dao.getAll();
		} else {
			final Integer prodOrderNo = orderSearchVO.getProdOrderNo();
			if (prodOrderNo != null) {
				return Arrays.asList(dao.select(prodOrderNo));
			} else {
				return dao.selectByConditions(orderSearchVO);
			}
		}
	}
	
	public List<OrderSearchVO> selectByProdOrderNo(Integer prodOrderNo) {
		if(prodOrderNo == null || prodOrderNo < 1) {
			return null;
		}
		return dao.selectByProdOrderNo(prodOrderNo);
	}
	
	public List<OrderSearchVO> selectByMemberNo(Integer memberNo) {
		if (memberNo == null || memberNo < 1) {
			return null;
		}
		List<OrderSearchVO> temp = dao.selectByMemberNo(memberNo);
		List<OrderSearchVO> result = new LinkedList<>();
		for (OrderSearchVO vo1 : temp) {
			boolean test = true;
			for (OrderSearchVO vo2 : result) {
				if (vo1.getProdOrderNo().equals(vo2.getProdOrderNo())) {
					test = false;
				}
			}
			if (test) {
				result.add(vo1);
			}
		}
		
		return result;
	}
	
	public List<OrderSearchVO> selectByRestaurantNo(Integer restaurantNo) {
		if (restaurantNo == null || restaurantNo < 1) {
			return null;
		}
		List<OrderSearchVO> temp = dao.selectByRestaurantNo(restaurantNo);
		List<OrderSearchVO> result = new LinkedList<>();
		for (OrderSearchVO vo1 : temp) {
			boolean test = true;
			for (OrderSearchVO vo2 : result) {
				if (vo1.getProdOrderNo().equals(vo2.getProdOrderNo())) {
					test = false;
				}
			}
			if (test) {
				result.add(vo1);
			}
		}
		
		return result;
	}
}
