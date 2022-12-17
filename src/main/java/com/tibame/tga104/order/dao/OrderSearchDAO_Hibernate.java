package com.tibame.tga104.order.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.vo.OrderSearchVO;

@Transactional
@Repository
public class OrderSearchDAO_Hibernate implements OrderSearchDAO_interface {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public OrderSearchVO select(Integer prodOrderNo) {
		if (prodOrderNo != null) {
			return this.getSession().get(OrderSearchVO.class, prodOrderNo);
		}		
		return null;
	}
	
	@Override
	public List<OrderSearchVO> selectByConditions(OrderSearchVO orderSearchVO) {
		return getSession().createCriteria(OrderSearchVO.class)
			.add(Example.create(orderSearchVO))
			.list();
	}

	@Override
	public List<OrderSearchVO> getAll() {
		
		return this.getSession().createQuery("from OrderSearchVO", OrderSearchVO.class).list();
	}
}
