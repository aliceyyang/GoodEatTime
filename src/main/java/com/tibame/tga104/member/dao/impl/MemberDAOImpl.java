package com.tibame.tga104.member.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tibame.tga104.member.dao.MemberDAO;
import com.tibame.tga104.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	
	@Override
	public MemberVO select(Integer memberNo) {
		if (memberNo != null) {
			return this.getSession().get(MemberVO.class, memberNo);
		}
		return null;
	}
	
	//會員註冊	
	@Override
	public MemberVO insert(MemberVO member) {
		//確認各必填欄位皆輸入
		if (member != null && member.getMemberNo() == null) {
			this.getSession().save(member);
			return member;
		}
		return null;
	}

	@Override
	public MemberVO update(MemberVO member) {
		if (member.getMemberNo() != null) {
			MemberVO temp = this.getSession().get(MemberVO.class, member.getMemberNo());
			if (temp != null) {
				temp.setMemberPassword(member.getMemberPassword());
				temp.setName(member.getName());
				temp.setTel(member.getTel());
				temp.setMemberPic(member.getMemberPic());
				return temp;
			}
		}
		return null;
	}
	
}


//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Component;
//
//import com.tibame.tga104.common.connection.HibernateUtil;
//import com.tibame.tga104.member.dao.MemberDAO;
//import com.tibame.tga104.member.vo.MemberVO;
//
//@Component
//public class MemberDAOImpl implements MemberDAO {
//	private SessionFactory sessionFactory;
//
//	public MemberDAOImpl(SessionFactory sessionFactory) {
//		super();
//		this.sessionFactory = sessionFactory;
//	}
//
//	public Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//
//		MemberDAO dao = new MemberDAOImpl(sessionFactory);
////		MemberVO member = dao.select(1);
////		System.out.println("membervo="+member);
////	
//
//		MemberVO insert = new MemberVO();
//
//		insert.setMemberPassword("sa;gth'r");
//		insert.setName("sorry");
//		insert.setMail("J@gmail.com");
////		insert.setBirthday(new SimpleDateFormat("yyyy-mm-dd").parse("1970-12-12"));
//		insert.setBirthday(java.sql.Date.valueOf("1970-12-12"));
//		insert.setTel("0947736287");
//		insert.setMemberLevel(2);
//		insert.setVerificationAccount(true);
//		MemberVO result1 = dao.insert(insert);
//		System.out.println("membervo=" + result1);
//
////		boolean result = dao.update();
//
//		transaction.commit();
//		session.close();
//		HibernateUtil.closeSessionFactory();
//	}
//
//	@Override
//	public MemberVO select(Integer memberNo) {
//		if (memberNo != null) {
//			return this.getSession().get(MemberVO.class, memberNo);
//		}
//		return null;
//	}
//
////會員註冊	
//	@Override
//	public MemberVO insert(MemberVO member) {
//		//確認各必填欄位皆輸入
//		if (member != null && member.getMemberNo() == null) {
//			this.getSession().save(member);
//			return member;
//		}
//		return null;
//	}
//
//	@Override
//	public MemberVO update(MemberVO member) {
//		if (member.getMemberNo() != null) {
//			MemberVO temp = this.getSession().get(MemberVO.class, member.getMemberNo());
//			if (temp != null) {
//				temp.setMemberPassword(member.getMemberPassword());
//				temp.setName(member.getName());
//				temp.setTel(member.getTel());
//				temp.setMemberPic(member.getMemberPic());
//				return temp;
//			}
//		}
//
//		return null;
//	}
//
//}

