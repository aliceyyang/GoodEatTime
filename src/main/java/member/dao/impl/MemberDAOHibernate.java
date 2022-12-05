package member.dao.impl;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import common.connection.HibernateUtil;
import member.dao.MemberDAO;
import member.vo.MemberVO;

public class MemberDAOHibernate implements MemberDAO {
	private SessionFactory sessionFactory;

	public MemberDAOHibernate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		MemberDAO dao = new MemberDAOHibernate(sessionFactory);
//		MemberVO member = dao.select(1);
//		System.out.println("membervo="+member);
//	

		MemberVO insert = new MemberVO();

		insert.setMemberPassword("sa;gth'r");
		insert.setName("sorry");
		insert.setMail("J@gmail.com");
//		insert.setBirthday(new SimpleDateFormat("yyyy-mm-dd").parse("1970-12-12"));
		insert.setBirthday(java.sql.Date.valueOf("1970-12-12"));
		insert.setTel("0947736287");
		insert.setMemberLevel(2);
		insert.setVerificationAccount(true);
		MemberVO result1 = dao.insert(insert);
		System.out.println("membervo=" + result1);

//		boolean result = dao.update();

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public MemberVO select(Integer memberNo) {
		if (memberNo != null) {
			return this.getSession().get(MemberVO.class, memberNo);
		}
		return null;
	}

	@Override
	public MemberVO insert(MemberVO member) {
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

//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//import member.dao.MemberDAO;
//import member.vo.Member;
//
//public class MemberDAOImpl implements MemberDAO {
//	private DataSource dataSource;
//
//	public MemberDAOImpl() throws NamingException {
//		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/goodeattime");
//
//	}
//
//	@Override
//	public Member selectByMemberNo(Integer memberNo) {
//		String sql = "select * from member where memberNo = ?";
//		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setInt(1, memberNo);
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					Member member = new Member();
//					member.setMemberNo(rs.getInt("memberNo"));
//					member.setMemberLevel(rs.getString("memberLevel"));
//					member.setName(rs.getString("name"));
//					member.setBirthday(rs.getDate("birthday"));
//					member.setMail(rs.getString("mail"));
//					member.setMemberPassword(rs.getString("MemberPassword"));
//					member.setVerificationAccount(rs.getBoolean("verificationAccount"));
//					member.setTel(rs.getString("tel"));
//					member.setPoint(rs.getInt("point"));
//					member.setMemberPic(rs.getBytes("memberPic"));
//
//					return member;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public int insert(Member member) {
//		String sql = "INSERT INTO Member(name, memberPassword, tel, memberPic)value(?,?,?,?)";
//		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			pstmt.setString(1, member.getName());
//			pstmt.setString(2, member.getMemberPassword());
//			pstmt.setString(3, member.getTel());
////			pstmt.setBytes(4, member.getMemberPic());
//
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}
//
//	@Override
//	public int updateByMemberId(Member member) {
//
//		StringBuilder sql = new StringBuilder("update member set memberNo = memberNo ");
//		String memberpassword = member.getMemberPassword();
//		String name = member.getName();
//		if (memberpassword != null) {
//			sql.append(", memberPassword = ?");
//		}
//		if (name != null) {
//			sql.append(", name = ?");
//		}
//		sql.append("where memberNo = ?");
//
//		try (Connection conn = dataSource.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//			int seq = 1;
//			if (memberpassword != null) {
//				pstmt.setString(seq++, memberpassword);
//			}
//			if (name != null) {
//				pstmt.setString(seq++, name);
//			}
//			pstmt.setInt(seq, member.getMemberNo());
//
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//
//	}
//
//}