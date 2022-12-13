package com.tibame.tga104.product.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.product.vo.ProdPicVO;

@Repository
public class ProdPicDAO_Hibernate implements ProdPicDAO {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public ProdPicVO insert(ProdPicVO prodPicVO) {
		if (prodPicVO != null) {
			this.getSession().save(prodPicVO);
			return prodPicVO;
		}
		return null;
	}

	@Override
	public ProdPicVO update(ProdPicVO prodPicVO) {
		if (prodPicVO != null && prodPicVO.getProdPicNo() != null) {
			ProdPicVO temp = this.getSession().get(ProdPicVO.class, prodPicVO.getProdPicNo());
			if (temp != null) {
				return (ProdPicVO) this.getSession().merge(prodPicVO);
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer prodPicNo) {
		if (prodPicNo != null) {
			ProdPicVO temp = this.getSession().get(ProdPicVO.class, prodPicNo);
			if(temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public ProdPicVO findByPrimaryKey(Integer prodPicNo) {
		if (prodPicNo != null) {
			return this.getSession().get(ProdPicVO.class, prodPicNo);
		}
		return null;
	}

	@Override
	public List<ProdPicVO> getAll() {
		return this.getSession().createQuery("from ProdPicVO", ProdPicVO.class).list();
	}

	@Override
	public List<ProdPicVO> findByProdNo(Integer prodNo) {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdPicVO> criteriaQuery = criteriaBuilder.createQuery(ProdPicVO.class);
		
		Root<ProdPicVO> root = criteriaQuery.from(ProdPicVO.class);
		
		Predicate p1 = criteriaBuilder.equal(root.get("prodNo"), prodNo);
		
		criteriaQuery = criteriaQuery.where(p1);
		
		TypedQuery<ProdPicVO> typedQurey = this.getSession().createQuery(criteriaQuery);
		List<ProdPicVO> result = typedQurey.getResultList();
		
		return result;
	}

}
