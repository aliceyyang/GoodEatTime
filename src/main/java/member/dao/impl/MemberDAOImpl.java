package member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberDAOImpl implements MemberDAO {
	private DataSource dataSource;

	public MemberDAOImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/goodeattime");

	}

	@Override
	public Member selectByMemberNo(Integer memberNo) {
		String sql = "select * from member where memberNo = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, memberNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Member member = new Member();
					member.setMemberNo(rs.getInt("memberNo"));
					member.setMemberLev(rs.getString("memberLev"));
					member.setName(rs.getString("name"));
					member.setBirthday(rs.getDate("birthday"));
					member.setMail(rs.getString("mail"));
					member.setMemberPassword(rs.getString("MemberPassword"));
					member.setVerificationAccount(rs.getBoolean("verificationAccount"));
					member.setTel(rs.getString("tel"));
					member.setPoint(rs.getInt("point"));
					member.setMemberPic(rs.getBytes("memberPic"));

					return member;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(Member member) {
		String sql = "INSERT INTO Member(name, memberPassword, tel, memberPic)value(?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getMemberPassword());
			pstmt.setString(3, member.getTel());
//			pstmt.setBytes(4, member.getMemberPic());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int updateByMemberId(Member member) {

		StringBuilder sql = new StringBuilder("update member set memberNo = memberNo ");
		String memberpassword = member.getMemberPassword();
		String name = member.getName();
		if (memberpassword != null) {
			sql.append(", memberPassword = ?");
		}
		if (name != null) {
			sql.append(", name = ?");
		}
		sql.append("where memberNo = ?");

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int seq = 1;
			if (memberpassword != null) {
				pstmt.setString(seq++, memberpassword);
			}
			if (name != null) {
				pstmt.setString(seq++, name);
			}
			pstmt.setInt(seq, member.getMemberNo());

			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

}