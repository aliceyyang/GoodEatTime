package com.tibame.tga104.reservation.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.reservation.dao.ReservationDao;
import com.tibame.tga104.reservation.vo.MemberReserveInfVO;
import com.tibame.tga104.reservation.vo.ReservationVO;

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

	
	@Override
	public ReservationVO insert(ReservationVO reservationVO) {
		if (reservationVO != null && reservationVO.getReserveNo() == null) {
				this.getSession().persist(reservationVO);
				return reservationVO;
			
		}
		return null;
	}
	

	@Override
	public ReservationVO update(ReservationVO reservationVO) {
		if(reservationVO!= null && reservationVO.getReserveNo() != null) {
			ReservationVO temp = this.getSession().get(ReservationVO.class, reservationVO.getReserveNo());
			if(temp != null) {
				return (ReservationVO)this.getSession().merge(reservationVO);
			}
		}
		return null;
	}
	
	@Override
	public boolean update(Integer reserveNo, String reserveStatus, Integer commentRating, String commentContent, byte[] commentPic,
			Timestamp restaurantCommentTime, String restaurantRe, java.sql.Timestamp restaurantReTime) {
		if(reserveNo != null) {
			ReservationVO temp = this.getSession().get(ReservationVO.class, reserveNo);
			if(temp != null) {
				temp.setReserveStatus(reserveStatus);
				temp.setCommentRating(commentRating);
				temp.setCommentContent(commentContent);
				temp.setCommentPic(commentPic);
				temp.setRestaurantCommentTime(restaurantCommentTime);
				temp.setRestaurantRe(restaurantRe);
				temp.setRestaurantReTime(restaurantReTime);
				
				return true;
			}
		}return false;
		
	}
	
	@Override
	public ReservationVO findByPrimaryKey(Integer reserveNo) {
		if (reserveNo != null) {
			return this.getSession().get(ReservationVO.class, reserveNo);
		}
		return null;
	}

	@Override
	public List<ReservationVO> getAll() {
//		return this.getSession().createQuery("from ReservationVO", ReservationVO.class).list();
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ReservationVO> criteriaQuery = criteriaBuilder.createQuery(ReservationVO.class);
		
		Root<ReservationVO> root = criteriaQuery.from(ReservationVO.class);		
		
		TypedQuery<ReservationVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<ReservationVO> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}
		
	}


	@Override
	public List<ReservationVO> findByReserveDate(Date reserveDate) {
		Query<ReservationVO> query = getSession().createQuery("from ReserveTimeVO where reserveDate = :reserveDate", ReservationVO.class);
		query.setParameter("reserveDate", reserveDate);
		List<ReservationVO> reservationVO = query.list();
		return reservationVO;
	}


	@Override
	public List<MemberReserveInfVO> findByMemeberNo(Integer memberNo) {
		Query<MemberReserveInfVO> query = getSession().createQuery("from MemberReserveInfVO where memberNo =: memberNo", MemberReserveInfVO.class);
		query.setParameter("memberNo", memberNo);
		List<MemberReserveInfVO> memberReserveInfVO = query.setFirstResult(0).setMaxResults(10).list();
		return memberReserveInfVO;
	}


}
