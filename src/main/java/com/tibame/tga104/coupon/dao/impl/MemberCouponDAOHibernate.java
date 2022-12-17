package com.tibame.tga104.coupon.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.common.connection.HibernateUtil;
import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.vo.MemberCouponVO;

@Repository
public class MemberCouponDAOHibernate implements MemberCouponDAO {
	private SessionFactory sessionFactory;

	public MemberCouponDAOHibernate() {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MemberCouponVO select(Integer memberNo) {
		if (memberNo != null) {
			return this.getSession().get(MemberCouponVO.class, memberNo);
		}
		return null;
	}

	@Override
	public MemberCouponVO insert(MemberCouponVO memberCouponVO) {
		if (memberCouponVO != null && memberCouponVO.getMemberNo() == null) {
			MemberCouponVO temp = this.getSession().get(MemberCouponVO.class, memberCouponVO);
			if (temp == null) {
				this.getSession().save(memberCouponVO);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean update(MemberCouponVO memberCouponVO) {
		if (memberCouponVO.getMemberNo() != null) {
			MemberCouponVO temp = this.getSession().get(MemberCouponVO.class, memberCouponVO.getMemberNo());
			if (temp != null) {
				temp.setCouponNo(memberCouponVO.getCouponNo());
				temp.setMemberNo(memberCouponVO.getMemberNo());
				temp.setUsageStatus(memberCouponVO.getUsageStatus());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Integer memberNo) {
		if (memberNo != null) {
			MemberCouponVO temp = this.getSession().get(MemberCouponVO.class, memberNo);
			if (temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<MemberCouponVO> getAll() {
		// return this.getSession().createQuery("form MemCouponVO",
		// MemberCouponVO.class).list();

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<MemberCouponVO> criteriaQuery = criteriaBuilder.createQuery(MemberCouponVO.class);

		Root<MemberCouponVO> root = criteriaQuery.from(MemberCouponVO.class);

		TypedQuery<MemberCouponVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<MemberCouponVO> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}

}