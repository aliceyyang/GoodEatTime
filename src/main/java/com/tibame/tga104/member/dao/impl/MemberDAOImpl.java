package com.tibame.tga104.member.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
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

	

//===============會員註冊===============
	
	@Override
	public MemberVO insert(MemberVO member) {
		// 確認各必填欄位皆輸入
		if (member != null && member.getMemberNo() == null) {
			this.getSession().save(member);
			return member;
		}
		return null;
	}
	//查詢是否有此會員帳號存在+忘記密碼
	@Override
	public MemberVO selectBymail(String mail) {
		//Select * from member where mail = ?
		final String hql = "from MemberVO where mail = :mail ";
		try {
			return session.createQuery(hql, MemberVO.class)
					.setParameter("mail", mail)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
//===============會員登入===============
	
	@Override
	public MemberVO selectForLogin(String mail, String memberPassword) {
		// select * from member where mail = ?and memberPassword = ?";
		final String hql ="from MemberVO where mail = :mail and memberPassword = :memberPassword ";
		return (MemberVO) session.createQuery(hql)
				.setParameter("mail", mail)
				.setParameter("memberPassword", memberPassword)
				.uniqueResult();
	}
//		if (mail != null && memberPassword.isEmpty()) {
//			Query<MemberVO> query = getSession()
//					.createQuery("from member where mail = :mail and memberPassword = :memberPassword", MemberVO.class);
//			query.setParameter("mail", mail);
//			query.setParameter("memberPassword", memberPassword);
//			List<MemberVO> memberVO = query.list();
//		}
	
	
	
	
	
//===============修改會員資料===============
	//先select
	@Override
	public MemberVO selectByMemberNo(Integer memberNo) {
		if (memberNo != null) {
			return this.getSession().get(MemberVO.class, memberNo);
		}
		return null;
	}
	
	@Override
	public int update(MemberVO memberVO) {
		//update member set  memberPassword =?, name=?, tel=? where memberNo=? 
		StringBuilder hql = new StringBuilder().append("update MemberVO set ");
		//一定要改密碼
		hql.append("memberPassword = :memberPassword");
		String name = memberVO.getName();
		if(name != null && !name.isEmpty()) {
			hql.append(",name = :name");
		}
		String tel = memberVO.getTel();
		if(tel != null && !tel.isEmpty()) {
			hql.append(",tel = :tel ");
		}
		hql.append("where memberNo = :memberNo");
		//判段欄位需輸入,但可以只修改其一
		try {
			Query<?> query = session.createQuery(hql.toString());
			query.setParameter("memberPassword", memberVO.getMemberPassword());
			
			if(name != null && !name.isEmpty()) {
				query.setParameter("name", memberVO.getName());
			}
			
			if(tel != null && !tel.isEmpty()) {
				query.setParameter("tel", memberVO.getTel());
			}
			query.setParameter("memberNo", memberVO.getMemberNo());
			return query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1;
		
//		if (member.getMemberNo() != null) {
//			MemberVO temp = this.getSession().get(MemberVO.class, member.getMemberNo());
//			if (temp != null) {
//				temp.setMemberPassword(member.getMemberPassword());
//				temp.setName(member.getName());
//				temp.setTel(member.getTel());
////				temp.setMemberPic(member.getMemberPic());
//				return temp;
//			}
//		}
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
