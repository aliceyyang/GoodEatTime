package com.tibame.tga104.product.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.product.vo.ShoppingCartPK;
import com.tibame.tga104.product.vo.ShoppingCartVO;

@Repository
public class ShoppingCartDAO_Hibernate implements ShoppingCartDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public ShoppingCartVO insert(ShoppingCartVO shoppingCartVO) {
		if (shoppingCartVO != null) {
			this.getSession().save(shoppingCartVO);
			return shoppingCartVO;
		}
		return null;
	}

	@Override
	public ShoppingCartVO update(ShoppingCartVO shoppingCartVO) {
		if (shoppingCartVO!=null && shoppingCartVO.getMemberNo() != null 
				&& shoppingCartVO.getProdNo()!= null) {
			ShoppingCartVO temp = this.getSession().
					get(ShoppingCartVO.class, shoppingCartVO.getId());
			if (temp != null) {
				this.getSession().merge(shoppingCartVO);
				return shoppingCartVO;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer memberNo, Integer prodNo) {
		if (memberNo != null && prodNo != null) {
			ShoppingCartVO temp = this.getSession().
					get(ShoppingCartVO.class, new ShoppingCartPK(memberNo, prodNo));
			if (temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public ShoppingCartVO findByPrimaryKey(Integer memberNo, Integer prodNo) {
		if (memberNo != null && prodNo != null) {
			return this.getSession().get(ShoppingCartVO.class, new ShoppingCartPK(memberNo, prodNo));
		}
		return null;
	}

	@Override
	public List<ShoppingCartVO> getAll() {
		return this.getSession().createQuery("from ShoppingCartVO", ShoppingCartVO.class).list();
	}

	@Override
	public List<ShoppingCartVO> findByMemberNo(Integer memberNo) {
		String hql = "from ShoppingCartVO where memberNo = :memberNo";
		if (memberNo != null) {
			// 應該要先去member資料表搜尋是否有此會員，若無此會員則回傳null
			List<ShoppingCartVO> result = this.getSession().createQuery(hql, ShoppingCartVO.class)
					.setParameter("memberNo", memberNo).list();
			return result;
		}
		return null;
	}

}
