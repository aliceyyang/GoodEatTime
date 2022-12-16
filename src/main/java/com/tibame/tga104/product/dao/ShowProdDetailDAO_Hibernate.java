package com.tibame.tga104.product.dao;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.product.vo.ShowProdDetailVO;

@Repository
public class ShowProdDetailDAO_Hibernate implements ShowProdDetailDAO {
	
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	
	@Override
	public ShowProdDetailVO select(Integer prodNo) {
		if (prodNo!=null&&prodNo>0) {
			return session.get(ShowProdDetailVO.class, prodNo);
		}
		return null;
	}

}
