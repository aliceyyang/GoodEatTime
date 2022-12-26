package com.tibame.tga104.order.dao;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.product.vo.ProdInfoVO;

@Repository
public class AddProdInfoDAO_Hibernate implements AddProdInfoDAO_interface{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}
	
	@Override
	public ProdInfoVO updateProd(ProdInfoVO prodInfoVO) {
		if (prodInfoVO != null && prodInfoVO.getProdNo() != null && prodInfoVO.getRestaurantNo() != null) {
			
			String updateHQL = "from ProdInfoVO where prodNo= :prodNo and restaurantNo = :restaurantNo";
			ProdInfoVO queryResult = this.getSession().createQuery(updateHQL, ProdInfoVO.class)
					.setParameter("prodNo", prodInfoVO.getProdNo())
					.setParameter("restaurantNo", prodInfoVO.getRestaurantNo())
					.uniqueResult();
			
			// if 大樓，用來確認哪一個欄位有被更新，可再看看有沒有更理想的寫法。
			if(prodInfoVO.getProdName() != null) {
				queryResult.setProdName(prodInfoVO.getProdName());				
			}
			if(prodInfoVO.getProdCategoryNo() != null) {
				queryResult.setProdCategoryNo(prodInfoVO.getProdCategoryNo());
			}
			if(prodInfoVO.getProdStock() != null) {
				queryResult.setProdStock(prodInfoVO.getProdStock());
			}
			if(prodInfoVO.getProdPrice() != null) {
				queryResult.setProdPrice(prodInfoVO.getProdPrice());
			}
			if(prodInfoVO.getProdDescription() != null) {
				queryResult.setProdDescription(prodInfoVO.getProdDescription());
			}
			if(prodInfoVO.getProdContent() != null) {
				queryResult.setProdContent(prodInfoVO.getProdContent());
			}
			
			return queryResult;
			
		}
		return null;
	}

}
