package com.tibame.tga104.product.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
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
		if (prodNo != null && prodNo > 0) {
			return this.getSession().get(ShowProdDetailVO.class, prodNo);
		}
		return null;
	}

	@Override
	public List<ShowProdDetailVO> select6ByCategory(Integer prodCategoryNo) {
		if (prodCategoryNo != null && prodCategoryNo > 0) {
			String nativeSQL = "select * FROM goodeattime.v_showproddetail "
					+ "where prodCategoryNo = :prodCategoryNo order by rand() limit 6";
			NativeQuery<ShowProdDetailVO> query = this.getSession().createSQLQuery(nativeSQL);
			query.setParameter("prodCategoryNo", prodCategoryNo);
			query.addEntity(ShowProdDetailVO.class);
			List<ShowProdDetailVO> result = query.list();
			return result;
		}
		return null;
	}

}
