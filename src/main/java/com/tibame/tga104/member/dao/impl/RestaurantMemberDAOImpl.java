package com.tibame.tga104.member.dao.impl;


import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.member.dao.RestaurantMemberDAO;
import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.member.vo.RestaurantRegistVO;

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


//===============餐廳會員註冊===============
	@Override
	public RestaurantRegistVO insert(RestaurantRegistVO restaurantRegistVO) {
		// 確認各必填欄位皆輸入
		if (restaurantRegistVO != null && restaurantRegistVO.getRestaurantNo() == null) {
			this.getSession().save(restaurantRegistVO);
			return restaurantRegistVO;
		}
		
		
		return null;
	}



	//查詢是否有此會員帳號存在
	@Override
	public RestaurantRegistVO selectByAccount(String restaurantAccount) {
		//Select * from restaurant where restaurantAccount = ?
		final String hql = "from RestaurantRegistVO where restaurantAccount = :restaurantAccount ";
		try {
			return session.createQuery(hql, RestaurantRegistVO.class)
					.setParameter("restaurantAccount", restaurantAccount)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
