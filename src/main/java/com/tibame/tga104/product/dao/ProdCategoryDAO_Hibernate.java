package com.tibame.tga104.product.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.product.vo.ProdCategoryVO;

@Repository
public class ProdCategoryDAO_Hibernate implements ProdCategoryDAO {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	@Transactional
	public ProdCategoryVO insert(ProdCategoryVO prodCategory) {
		if (prodCategory != null) {
			this.getSession().persist(prodCategory);
			return prodCategory;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean update(ProdCategoryVO prodCategory) {
		if (prodCategory != null && prodCategory.getProdCategoryNo() != null) {
			ProdCategoryVO temp = this.getSession().get(ProdCategoryVO.class, prodCategory.getProdCategoryNo());
			if (temp != null) {
				this.getSession().merge(prodCategory);
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Integer prodCategoryNo) {
		if (prodCategoryNo != null) {
			ProdCategoryVO temp = this.getSession().get(ProdCategoryVO.class, prodCategoryNo);
			if (temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public ProdCategoryVO findByPrimaryKey(Integer prodCategoryNo) {
		if (prodCategoryNo != null) {
			return this.getSession().get(ProdCategoryVO.class, prodCategoryNo);
		}
		return null;
	}

	@Override
	public List<ProdCategoryVO> getAll() {
		return this.getSession().createQuery("from ProdCategoryVO", ProdCategoryVO.class).list();
	}

}
