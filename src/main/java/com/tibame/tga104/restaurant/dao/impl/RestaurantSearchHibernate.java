package com.tibame.tga104.restaurant.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		String hql = "from RestaurantSearchVO";
		List<RestaurantSearchVO> result = this.getSession().createQuery(hql, RestaurantSearchVO.class).list();
		return result;
	}

	@Override
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantName) {
		if (restaurantName != null) {
			String hql = "from RestaurantSearchVO where restaurantName like :restaurantName";
			List<RestaurantSearchVO> result = this.getSession().createQuery(hql, RestaurantSearchVO.class)
					.setParameter("restaurantName", "'%" + restaurantName + "%'").list();
			return result;
		}
		return null;
	}

}
