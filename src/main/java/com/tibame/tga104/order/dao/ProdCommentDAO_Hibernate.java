package com.tibame.tga104.order.dao;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;
import com.tibame.tga104.reservation.vo.ReservationVO;

@Repository
public class ProdCommentDAO_Hibernate implements ProdCommentDAO_interface {

	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}
	
	@Override
	public List<ProdOrderDetailVO> getNotNullComment() {
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdOrderDetailVO> criteriaQuery = criteriaBuilder.createQuery(ProdOrderDetailVO.class);
		Root<ProdOrderDetailVO> root = criteriaQuery.from(ProdOrderDetailVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("prodCommentRating")));	
		TypedQuery<ProdOrderDetailVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<ProdOrderDetailVO> notNullResult = typedQuery.getResultList();		
		if (notNullResult!=null && !notNullResult.isEmpty()) {
			return notNullResult;
		} else {
			return null;
		}
			
//		Query<ProdOrderDetailVO> query = this.getSession().createQuery("from prodOrderDetail "
//				+ "where prodCommentRating is not null", ProdOrderDetailVO.class);
//		List<ProdOrderDetailVO> notNullResult = query.list();
//		if (notNullResult!=null && !notNullResult.isEmpty()) {
//			return notNullResult;
//		} else {
//			return null;
//		}
	}
	
	@Override
	public List<ProdOrderDetailVO> getNullComment(){
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdOrderDetailVO> criteriaQuery = criteriaBuilder.createQuery(ProdOrderDetailVO.class);
		Root<ProdOrderDetailVO> root = criteriaQuery.from(ProdOrderDetailVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNull(root.get("prodCommentRating")));	
		TypedQuery<ProdOrderDetailVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(4);
		List<ProdOrderDetailVO> NullResult = typedQuery.getResultList();		
		if (NullResult!=null && !NullResult.isEmpty()) {
			return NullResult;
		} else {
			return null;
		}
		
	}
	
	public ProdOrderDetailVO updateCommnet(ProdOrderDetailVO prodOrderDetailVO) {
		// 確認是否需要從prodOrderDetail > prodOrder > restaurantNo ?
		if(prodOrderDetailVO != null && prodOrderDetailVO.getProdOrderNo() != null && prodOrderDetailVO.getProdNo() != null) {
			
			String updateHQL = "from ProdOrderDetailVO where prodOrderNo= :prodOrderNo and prodNo = :prodNo";
			ProdOrderDetailVO queryResult = this.getSession().createQuery(updateHQL, ProdOrderDetailVO.class)
					.setParameter("prodOrderNo", prodOrderDetailVO.getProdOrderNo())
					.setParameter("prodNo", prodOrderDetailVO.getProdNo())
					.uniqueResult();
			queryResult.setProdCommentRating(prodOrderDetailVO.getProdCommentRating());
			queryResult.setProdCommentContent(prodOrderDetailVO.getProdCommentContent());
			queryResult.setProdCommentPic(prodOrderDetailVO.getProdCommentPic());
			queryResult.setProdCommentTime(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));
			
			return queryResult;
			
		}
		return null;
	}
	
	public ProdOrderDetailVO replyComment(ProdOrderDetailVO prodOrderDetailVO) {
		if (prodOrderDetailVO != null && prodOrderDetailVO.getProdOrderNo() != null) {
			
			String replyHQL = "from ProdOrderDetailVO where prodOrderNo= :prodOrderNo ";
			ProdOrderDetailVO queryResult = this.getSession().createQuery(replyHQL, ProdOrderDetailVO.class)
					.setParameter("prodOrderNo", prodOrderDetailVO.getProdOrderNo())
					.uniqueResult();
			System.out.println(queryResult);
			
			queryResult.setRestaurantReply(prodOrderDetailVO.getRestaurantReply());
			queryResult.setRestaurantReplyTime(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));
			
			return queryResult;
		}
		return null;
	}
	
}
