package com.tibame.tga104.reservation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

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
	public ReserveTimeVO updateAllowReserveNum(ReserveTimeVO reserveTimeVo) {
		if (reserveTimeVo != null && reserveTimeVo.getReserveTimeNo() != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeVo.getReserveTimeNo());
			if (temp != null) {
				return (ReserveTimeVO) this.getSession().merge(reserveTimeVo);
			}
		}
		return null;
	}

	@Override
	public ReserveTimeVO updateWeekDay(ReserveTimeVO reserveTimeVo) {
		if (reserveTimeVo != null && reserveTimeVo.getReserveTimeNo() != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeVo.getReserveTimeNo());
			if (temp != null) {
				return (ReserveTimeVO) this.getSession().merge(reserveTimeVo);
			}
		}
		return null;
	}

	@Override
	public int update(ReserveTimeVO reserveTimeVO) {
		Query<?> query = getSession().createQuery("update ReserveTimeVO "
				+ "set allowReserveNum = :allowReserveNum "
				+ "where "
				+ "restaurantNo = :restaurantNo and reserveTime = :reserveTime and weekDay = :weekDay");
		query.setParameter("allowReserveNum", reserveTimeVO.getAllowReserveNum())
			 .setParameter("restaurantNo", reserveTimeVO.getRestaurantNo()) 
			 .setParameter("reserveTime", reserveTimeVO.getReserveTime())
			 .setParameter("weekDay", reserveTimeVO.getWeekDay());
		return query.executeUpdate();
		
	}

	@Override
	public List<ReserveTimeVO> findByRestaurantNOandWeekDay(Integer restaurantNo, Integer weekDay) {
		Query<ReserveTimeVO> query = getSession().createQuery("from ReserveTimeVO where restaurantNo = :restaurantNo and weekDay = :weekDay", ReserveTimeVO.class);
		query.setParameter("restaurantNo", restaurantNo);
		query.setParameter("weekDay", weekDay);
		List<ReserveTimeVO> reserveTimeVO = query.list();
		return reserveTimeVO;
	}

	@Override
	public List<Integer> findByRestaurantNo(Integer restaurantNo) {
			Query<Integer> query = getSession().createQuery("select distinct weekDay from ReserveTimeVO where restaurantNo = :restaurantNo", Integer.class);
			query.setParameter("restaurantNo", restaurantNo);
			List<Integer> reserveTimeVO = query.list();
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


	@Override
	public List<Integer> getReserveTimeNo(Integer restaurantNo, Integer weekDay) {
		Query<ReserveTimeVO> query = getSession().createQuery("from ReserveTimeVO where restaurantNo = :restaurantNo and weekDay =:weekDay", ReserveTimeVO.class);
		query.setParameter("restaurantNo", restaurantNo);
		query.setParameter("weekDay", weekDay);
		List<ReserveTimeVO> list = query.list();
		List<Integer> no = new ArrayList<Integer>();
		for(ReserveTimeVO vo :list) {
			no.add(vo.getReserveTimeNo());
		}
		return no;
	}
}
