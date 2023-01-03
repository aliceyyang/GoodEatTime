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
import com.tibame.tga104.order.vo.RestCommentReplyVO;

@Repository
public class RestCommentReply_Hibernate implements RestCommentReply_interface {

	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}
	
	@Override
	public List<RestCommentReplyVO> getNotNullComment(RestCommentReplyVO restCommentReplyVO) {
		
		System.out.println(restCommentReplyVO);
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<RestCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(RestCommentReplyVO.class);
		Root<RestCommentReplyVO> root = criteriaQuery.from(RestCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("commentRating")),criteriaBuilder.equal(root.get("restaurantNo"),restCommentReplyVO.getRestaurantNo()));
//		criteriaQuery = criteriaQuery.where((criteriaBuilder.isNotNull(root.get("commentRating"))),criteriaBuilder.isNull(root.get("restaurantRe")));	
		TypedQuery<RestCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<RestCommentReplyVO> notNullResult = typedQuery.getResultList();		
		if (notNullResult!=null && !notNullResult.isEmpty()) {
			return notNullResult;
		} else {
			return null;
		}
	}
	@Override
	public List<RestCommentReplyVO> getNullComment(){
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<RestCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(RestCommentReplyVO.class);
		Root<RestCommentReplyVO> root = criteriaQuery.from(RestCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("commentRating")),criteriaBuilder.equal(root.get("restaurantNo"),3));
		TypedQuery<RestCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<RestCommentReplyVO> NullResult = typedQuery.getResultList();		
		if (NullResult!=null && !NullResult.isEmpty()) {
			return NullResult;
		} else {
			return null;
		}
	}
	
	@Override
	public List<RestCommentReplyVO> getForMemberNotNullComment(RestCommentReplyVO restCommentReplyVO) {
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<RestCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(RestCommentReplyVO.class);
		Root<RestCommentReplyVO> root = criteriaQuery.from(RestCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("commentRating")),criteriaBuilder.equal(root.get("memberNo"),restCommentReplyVO.getMemberNo()));
//		criteriaQuery = criteriaQuery.where((criteriaBuilder.isNotNull(root.get("prodCommentRating"))),criteriaBuilder.isNull(root.get("restaurantReply-")));
		TypedQuery<RestCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<RestCommentReplyVO> notNullResult = typedQuery.getResultList();		
		if (notNullResult!=null && !notNullResult.isEmpty()) {
			return notNullResult;
		} else {
			return null;
		}
	}
	
	@Override
	public List<RestCommentReplyVO> getForMemberNullComment(RestCommentReplyVO restCommentReplyVO){
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<RestCommentReplyVO> criteriaQuery = criteriaBuilder.createQuery(RestCommentReplyVO.class);
		Root<RestCommentReplyVO> root = criteriaQuery.from(RestCommentReplyVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNull(root.get("commentRating")),criteriaBuilder.equal(root.get("memberNo"),restCommentReplyVO.getMemberNo()));
		TypedQuery<RestCommentReplyVO> typedQuery = this.getSession().createQuery(criteriaQuery);
//		typedQuery.setFirstResult(0);
//		typedQuery.setMaxResults(4);
		List<RestCommentReplyVO> NullResult = typedQuery.getResultList();	
//		System.out.print(NullResult);
		if (NullResult!=null && !NullResult.isEmpty()) {
			return NullResult;
		} else {
			return null;
		}
	}
}
