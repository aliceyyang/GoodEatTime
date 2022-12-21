package com.tibame.tga104.order.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.reservation.vo.ReservationVO;

@Repository
public class RestaurantCommentDAO_Hibernate implements RestaurantCommentDAO_interface{

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}
	
	@Override
	public List<ReservationVO> getNotNullComment() {
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ReservationVO> criteriaQuery = criteriaBuilder.createQuery(ReservationVO.class);
		Root<ReservationVO> root = criteriaQuery.from(ReservationVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNotNull(root.get("commentRating")));	
		TypedQuery<ReservationVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(4);
		List<ReservationVO> result = typedQuery.getResultList();		
		if (result!=null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}
		
	@Override
	public List<ReservationVO> getNullComment() {
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ReservationVO> criteriaQuery = criteriaBuilder.createQuery(ReservationVO.class);
		Root<ReservationVO> root = criteriaQuery.from(ReservationVO.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.isNull(root.get("commentRating")));	
		TypedQuery<ReservationVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(4);
		List<ReservationVO> result = typedQuery.getResultList();		
		if (result!=null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}
	
	@Override
	public ReservationVO updateCommnet (ReservationVO reservationVO) {
		if(reservationVO != null && reservationVO.getReserveNo() != null && reservationVO.getMemberNo() != null) {
			
			Query<ReservationVO> query = getSession().createQuery("update reservation "
					+ "	set commentRating = :commentRating, commentContent = :commentContent, commentPic = :commentPic, restaurantCommentTime = CURRENT_TIMESTAMP "
					+ "		where reserveNo= 2 and memberNo = 3 ", ReservationVO.class);
					query.setParameter("commentRating", reservationVO.getCommentRating())
					.setParameter("commentContent", reservationVO.getCommentContent())
					.setParameter("commentPic", reservationVO.getCommentPic());
					query.executeUpdate();
			
			ReservationVO queryResult = query.uniqueResult();
			return queryResult;
			
		}
		return null;
	}
	
}
