package com.tibame.tga104.product.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.product.vo.ProdCategoryVO;
import com.tibame.tga104.product.vo.ProdInfoVO;

@Repository
public class ProdInfoDAO_Hibernate implements ProdInfoDAO {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public ProdInfoVO insert(ProdInfoVO prodInfoVO) {
		if (prodInfoVO!=null) {
			this.getSession().save(prodInfoVO);
			return prodInfoVO;
		}
		return null;
	}

	@Override
	public ProdInfoVO update(ProdInfoVO prodInfoVO) {
		if (prodInfoVO!=null && prodInfoVO.getProdNo()!=null) {
			ProdInfoVO temp = this.getSession().get(ProdInfoVO.class, prodInfoVO.getProdNo());
			if (temp!=null) {
				this.getSession().merge(prodInfoVO);
				return prodInfoVO;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer prodNo) {
		if (prodNo!=null) {
			ProdInfoVO temp = this.getSession().get(ProdInfoVO.class, prodNo);
			if (temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public ProdInfoVO findByPrimaryKey(Integer prodNo) {
		if (prodNo!= null) {
			return this.getSession().get(ProdInfoVO.class, prodNo);
		}
		return null;
	}

	@Override
	public List<ProdInfoVO> getAll() {
		return this.getSession().createQuery("from ProdInfoVO", ProdInfoVO.class).list();
	}

	@Override
	public List<ProdInfoVO> findByProdCategory(Integer prodCategoryNo) {
		if (prodCategoryNo!=null) {
			ProdCategoryVO temp = this.getSession().get(ProdCategoryVO.class, prodCategoryNo);
			if (temp!=null) {
				String hql = "from ProdInfoVO where prodCategoryNo = :prodCategoryNo";
				List<ProdInfoVO> result = this.getSession().createQuery(hql, ProdInfoVO.class)
						.setParameter("prodCategoryNo", prodCategoryNo).list();
				return result;
			}
		}
		return null;
	}

}
