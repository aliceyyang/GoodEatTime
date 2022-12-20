package com.tibame.tga104.order.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.vo.ProdOrderDetailPK;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;

@Repository
public class ProdOrderDetailDAO_Hibernate implements ProdOrderDetailDAO_interface {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public ProdOrderDetailVO insert(ProdOrderDetailVO prodOrderDetailVO) {
		if (prodOrderDetailVO != null) {
			this.getSession().save(prodOrderDetailVO);
			return prodOrderDetailVO;
		}
		return null;
	}

	@Override
	public ProdOrderDetailVO update(ProdOrderDetailVO prodOrderDetailVO) {
		if (prodOrderDetailVO == null || prodOrderDetailVO.getProdNo() == null
				|| prodOrderDetailVO.getProdOrderNo() == null) {
			return null;
		}
		ProdOrderDetailVO temp = this.getSession().get(ProdOrderDetailVO.class, prodOrderDetailVO.getId());
		if (temp != null) {
			this.getSession().merge(prodOrderDetailVO);
			return prodOrderDetailVO;
		}
		return null;
	}

	@Override
	public boolean delete(Integer prodOrderNo, Integer prodQty) {
		if (prodOrderNo == null || prodQty == null) {
			return false;
		}
		ProdOrderDetailVO temp = this.getSession()
				.get(ProdOrderDetailVO.class, new ProdOrderDetailPK(prodOrderNo, prodQty));
		if (temp != null) {
			this.getSession().delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public ProdOrderDetailVO select(Integer prodOrderNo, Integer prodQty) {
		if (prodOrderNo == null || prodQty == null) {
			return null;
		}
		ProdOrderDetailVO temp = this.getSession()
				.get(ProdOrderDetailVO.class, new ProdOrderDetailPK(prodOrderNo, prodQty));
		return temp;
	}
	
	@Override
	public List<ProdOrderDetailVO> select(Integer prodOrderNo) {
		String hql = "from ProdOrderDetailVO where prodOrderNo = :prodOrderNo";
		if (prodOrderNo != null && prodOrderNo > 0) {
			List<ProdOrderDetailVO> result = this.getSession().createQuery(hql, ProdOrderDetailVO.class)
					.setParameter("prodOrderNo", prodOrderNo).list();
			return result;
		}
		return null;
	}
	
	@Override
	public List<ProdOrderDetailVO> getAll() {
		return this.getSession().createQuery("from ProdOrderDetailVO", ProdOrderDetailVO.class).list();
	}



}
