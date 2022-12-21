package com.tibame.tga104.member.dao.impl;


import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.member.dao.RestaurantMemberDAO;
import com.tibame.tga104.member.vo.RestaurantMemberVO;

@Repository
public class RestaurantMemberDAOImpl implements RestaurantMemberDAO {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	
	
//===============餐廳會員登入===============
	@Override
	public RestaurantMemberVO selectForLogin(String restaurantAccount, String restaurantPassword) {
		// select * from restaurant where restaurantAccount = ?and restaurantPassword = ?";
		final String hql ="from RestaurantMemberVO where restaurantAccount = :restaurantAccount and restaurantPassword = :restaurantPassword ";
		return (RestaurantMemberVO) session.createQuery(hql)
				.setParameter("restaurantAccount", restaurantAccount)
				.setParameter("restaurantPassword", restaurantPassword)
				.uniqueResult();
	}

}
