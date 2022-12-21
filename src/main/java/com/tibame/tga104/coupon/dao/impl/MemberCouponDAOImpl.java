package com.tibame.tga104.coupon.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.coupon.dao.MemberCouponDAO;
import com.tibame.tga104.coupon.vo.MemberCouponVO;

@Repository
public class MemberCouponDAOImpl implements MemberCouponDAO {

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

	@Override
	public MemberCouponVO insert(MemberCouponVO memberCouponVO) {
		if (memberCouponVO != null && memberCouponVO.getMemberNo() == null) {
			this.getSession().save(memberCouponVO);
			return memberCouponVO;
		}
		return null;
	}

	@Override
	public boolean update(MemberCouponVO memberCouponVO) {
		if (memberCouponVO != null && memberCouponVO.getMemberNo() == null) {
			MemberCouponVO temp = this.getSession().get(memberCouponVO.getClass(), memberCouponVO.getMemberNo());
			if (temp != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public MemberCouponVO select(Integer memberNo) {
		if (memberNo != null) {
			return this.getSession().get(MemberCouponVO.class, memberNo);
		}
		return null;
	}

	@Override
	public List<MemberCouponVO> getAll() {
//		return this.getSession().createQuery("form MemberCoupon", MemberCouponVO.class).list();
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<MemberCouponVO> criteriaQuery = criteriaBuilder.createQuery(MemberCouponVO.class);

		Root<MemberCouponVO> root = criteriaQuery.from(MemberCouponVO.class);

		TypedQuery<MemberCouponVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<MemberCouponVO> list = typedQuery.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(Integer memberNo) {
		if (memberNo != null) {
			this.getSession().get(MemberCouponVO.class, memberNo);
			return true;
		}
		return false;
	}
}
