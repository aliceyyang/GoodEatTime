package com.tibame.tga104.coupon.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.tibame.tga104.coupon.vo.MemberCouponVO;

public class MemberCouponHBNate implements MemberCouponDAO {
	private SessionFactory sessionFactory;

	public MemberCouponHBNate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MemberCouponVO insert(MemberCouponVO memberCouponVO) {
		if (memberCouponVO != null) {
			this.getSession().save(memberCouponVO);
			return memberCouponVO;
		}
		return null;
	}

	@Override
	public MemberCouponVO update(MemberCouponVO memberCouponVO) {
		if (memberCouponVO != null && memberCouponVO.getMemberNo() != null) {
			MemberCouponVO temp = this.getSession().get(MemberCouponVO.class, memberCouponVO.getMemberNo());
			if (temp != null) {
				return (MemberCouponVO) this.getSession().merge(memberCouponVO);
			}
		}
		return null;
	}

	@Override
	public Boolean usageStatus(Boolean usageStatus) {
		if (usageStatus != null) {
			MemberCouponVO temp = this.getSession().get(MemberCouponVO.class, usageStatus);
			if (temp != null ) {
				temp.setUsageStatus(usageStatus);
				return true;
			}
		}
		return false;
	}

	@Override
	public MemberCouponVO findByPrimaryKey(Integer memberNo) {
		if (memberNo != null) {
			return this.getSession().get(MemberCouponVO.class, memberNo);
		}
		return null;
	}

	@Override
	public List<MemberCouponVO> getAll() {
//		接SQL寫法	this.getSession().createQuery("from MemberCouponVO", MemberCouponVO.class).list();
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<MemberCouponVO> criteriaQuery = criteriaBuilder.createQuery(MemberCouponVO.class);
		Root<MemberCouponVO> root = criteriaQuery.from(MemberCouponVO.class);
		TypedQuery<MemberCouponVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<MemberCouponVO> list = typedQuery.getResultList();
		if (list != null && list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}
}
