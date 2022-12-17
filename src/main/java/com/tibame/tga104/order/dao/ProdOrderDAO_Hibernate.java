package com.tibame.tga104.order.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.vo.ProdOrderVO;
import com.tibame.tga104.product.vo.ProdInfoVO;

@Transactional
@Repository
public class ProdOrderDAO_Hibernate implements ProdOrderDAO_interface{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}

	@Override
	public void insert(ProdOrderVO prodOrderVO) {
		if (prodOrderVO != null) {
			this.getSession().save(prodOrderVO);
		}
	}
	@Override
	public void delete(Integer prodOrderNo) {
		if(prodOrderNo != null) {
			ProdOrderVO temp = this.getSession().get(ProdOrderVO.class, prodOrderNo);
			if (temp!=null) {
				this.getSession().delete(temp);
			}
		}
	}
	@Override
	public void update(ProdOrderVO prodOrderVO) {
		if (prodOrderVO !=null && prodOrderVO.getProdOrderNo()!=null) {
			ProdInfoVO temp = this.getSession().get(ProdInfoVO.class, prodOrderVO.getProdOrderNo());
			if (temp!=null) {
				this.getSession().merge(prodOrderVO);
			}
		}
		
	}

	@Override
	public ProdOrderVO select(Integer prodOrderNo) {
		if (prodOrderNo != null) {
			return this.getSession().get(ProdOrderVO.class, prodOrderNo);
		}
		
		return null;
	}

	@Override
	public List<ProdOrderVO> getAll() {
		
		return this.getSession().createQuery("from ProdOrderVO", ProdOrderVO.class).list();
	}

	@Override
	public List<ProdOrderVO> selectByConditions(ProdOrderVO prodOrderVO) {
		return getSession().createCriteria(ProdOrderVO.class)
			.add(Example.create(prodOrderVO))
			.list();
	}
}
