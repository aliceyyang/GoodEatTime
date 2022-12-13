package com.tibame.tga104.reservation.dao.impl;

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

import com.tibame.tga104.reservation.dao.ReserveTimeDao;
import com.tibame.tga104.reservation.vo.ReserveTimeVO;

@Repository
public class ReserveTimeDaoImpl implements ReserveTimeDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

	
	@Override
	public ReserveTimeVO insert(ReserveTimeVO reserveTimeVo) {
		if (reserveTimeVo != null && reserveTimeVo.getReserveTimeNo() == null) {
			this.getSession().persist(reserveTimeVo);
			return reserveTimeVo;
		}
		return null;
	}

	@Override
	public boolean updateAllowReserveNum(Integer reserveTimeNO, String reserveTime, Integer allowReserveNum) {
		if (reserveTimeNO != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeNO);
			if (temp != null) {
				temp.setAllowReserveNum(allowReserveNum);
				temp.setReserveTime(reserveTime);

				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateWeekDay(Integer reserveTimeNO, String reserveTime, Integer weekDay, Integer allowReserveNum) {
		if (reserveTimeNO != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeNO);
			if (temp != null) {
				temp.setReserveTime(reserveTime);
				temp.setWeekDay(weekDay);
				temp.setAllowReserveNum(allowReserveNum);

				return true;
			}
		}
		return false;
	}

	@Override
	public ReserveTimeVO update(ReserveTimeVO reserveTimeVO) {
		if (reserveTimeVO != null && reserveTimeVO.getReserveTimeNo() != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeVO.getReserveTimeNo());
			if (temp != null) {
				return (ReserveTimeVO) this.getSession().merge(reserveTimeVO);
			}
		}
		return null;
	}

	@Override
	public List<ReserveTimeVO> findbyrestaurantNOandWeekDay(Integer restaurantNo, Integer weekDay) {
		Query<ReserveTimeVO> query = getSession().createQuery("from ReserveTimeVO where restaurantNo = :restaurantNo and weekDay = :weekDay", ReserveTimeVO.class);
		query.setParameter("restaurantNo", restaurantNo);
		query.setParameter("weekDay", weekDay);
		List<ReserveTimeVO> reserveTimeVO = query.list();
		return reserveTimeVO;
	}

	@Override
	public List<ReserveTimeVO> findbyrestaurantNo(Integer restaurantNo) {
			Query<ReserveTimeVO> query = getSession().createQuery("from ReserveTimeVO where restaurantNo = :restaurantNo", ReserveTimeVO.class);
			query.setParameter("restaurantNo", restaurantNo);
			List<ReserveTimeVO> reserveTimeVO = query.list();
			return reserveTimeVO;
	}

	@Override
	public List<ReserveTimeVO> getAll() {
//		return this.getSession().createQuery("from ReserveTimeVO", ReserveTimeVO.class).list();

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<ReserveTimeVO> criteriaQuery = criteriaBuilder.createQuery(ReserveTimeVO.class);

		Root<ReserveTimeVO> root = criteriaQuery.from(ReserveTimeVO.class);

		TypedQuery<ReserveTimeVO> typedQuery = this.getSession().createQuery(criteriaQuery)
				.setFirstResult(0)
				.setMaxResults(10);
		List<ReserveTimeVO> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}

	}

}
