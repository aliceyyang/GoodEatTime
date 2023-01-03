package com.tibame.tga104.restaurant.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.restaurant.dao.RestaurantSearchDAO;
import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;

@Repository
public class RestaurantSearchHibernate implements RestaurantSearchDAO {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

	@Override
	public List<RestaurantSearchVO> getAll() {
		return this.getSession().createQuery("from RestaurantSearchVO", RestaurantSearchVO.class).list();
	}

	@Override
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantName) {
		if (restaurantName != null) {
			String hql = "from RestaurantSearchVO where restaurantName like '%" + restaurantName + "%'";
			List<RestaurantSearchVO> result = this.getSession().createQuery(hql, RestaurantSearchVO.class).list();
			return result;
		}
		return null;
	}

	@Override
	public List<RestaurantSearchVO> selectByrestaurantNo(Integer restaurantNo) {
		if (restaurantNo != null) {
			String hql = "from RestaurantSearchVO where restaurantNo = "+ restaurantNo;
			List<RestaurantSearchVO> list = this.getSession().createQuery(hql, RestaurantSearchVO.class).list();
			return list;
		}
		return null;
	}

}
