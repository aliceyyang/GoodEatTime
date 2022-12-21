package com.tibame.tga104.order.service;

import java.util.Arrays;
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

}
