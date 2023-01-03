package com.tibame.tga104.order.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.order.vo.ProdCommentReplyVO;

@Repository
public class ProdCommentReply_Hibernate implements ProdCommentReply_interface {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}
	
	@Override
	public List<ProdCommentReplyVO> getNotNullComment(ProdCommentReplyVO prodCommentReplyVO) {
		
		System.out.print(prodCommentReplyVO);
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(ProdCommentReplyVO.class);
		Root<ProdCommentReplyVO> root = criteriaQuery.from(ProdCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("prodCommentRating")),criteriaBuilder.equal(root.get("restaurantNo"),prodCommentReplyVO.getRestaurantNo()));
//		criteriaQuery = criteriaQuery.where((criteriaBuilder.isNotNull(root.get("prodCommentRating"))),criteriaBuilder.isNull(root.get("restaurantReply-")));
		TypedQuery<ProdCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<ProdCommentReplyVO> notNullResult = typedQuery.getResultList();		
		if (notNullResult!=null && !notNullResult.isEmpty()) {
			return notNullResult;
		} else {
			return null;
		}
	}
	
	@Override
	public List<ProdCommentReplyVO> getNullComment(){
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(ProdCommentReplyVO.class);
		Root<ProdCommentReplyVO> root = criteriaQuery.from(ProdCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("prodCommentRating")),criteriaBuilder.equal(root.get("restaurantNo"),3));
		TypedQuery<ProdCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<ProdCommentReplyVO> NullResult = typedQuery.getResultList();	
//		System.out.print(NullResult);
		if (NullResult!=null && !NullResult.isEmpty()) {
			return NullResult;
		} else {
			return null;
		}
	}
	
	@Override
	public List<ProdCommentReplyVO> getForMemberNotNullComment(ProdCommentReplyVO prodCommentReplyVO) {
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(ProdCommentReplyVO.class);
		Root<ProdCommentReplyVO> root = criteriaQuery.from(ProdCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("prodCommentRating")),criteriaBuilder.equal(root.get("memberNo"),prodCommentReplyVO.getMemberNo()));
//		criteriaQuery = criteriaQuery.where((criteriaBuilder.isNotNull(root.get("prodCommentRating"))),criteriaBuilder.isNull(root.get("restaurantReply-")));
		TypedQuery<ProdCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<ProdCommentReplyVO> notNullResult = typedQuery.getResultList();		
		if (notNullResult!=null && !notNullResult.isEmpty()) {
			return notNullResult;
		} else {
			return null;
		}
	}
	
	@Override
	public List<ProdCommentReplyVO> getForMemberNullComment(ProdCommentReplyVO prodCommentReplyVO){
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProdCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(ProdCommentReplyVO.class);
		Root<ProdCommentReplyVO> root = criteriaQuery.from(ProdCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNull(root.get("prodCommentRating")),criteriaBuilder.equal(root.get("memberNo"),prodCommentReplyVO.getMemberNo()));
		TypedQuery<ProdCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<ProdCommentReplyVO> NullResult = typedQuery.getResultList();	
//		System.out.print(NullResult);
		if (NullResult!=null && !NullResult.isEmpty()) {
			return NullResult;
		} else {
			return null;
		}
	}

}
