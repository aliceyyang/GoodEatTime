package com.tibame.tga104.member.service.impl;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.member.dao.MemberDAO;
import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

//===============會員登入===============
	@Override
	public MemberVO memberLogin(MemberVO memberVO) {

		if (memberVO.getMail() == null || memberVO.getMail().isEmpty()) {
			memberVO.setMessage("帳號必須輸入");
		}
		if (memberVO.getMemberPassword() == null || memberVO.getMemberPassword().isEmpty()) {
			memberVO.setMessage("密碼必須輸入");
		}
		if (memberVO.getMessage() != null) {
			return memberVO;
		}
		memberVO = dao.selectForLogin(memberVO.getMail(), memberVO.getMemberPassword());
		if (memberVO != null) {
			memberVO.setSuccessful(true);
			memberVO.setMessage("登入成功");
		} else {
			memberVO = new MemberVO();
			memberVO.setSuccessful(false);
			memberVO.setMessage("登入失敗");
		}

		return memberVO;
	}

//===============會員註冊===============
	@Override
	public MemberVO register(MemberVO memberVO) {
		if (memberVO.getName() == null || memberVO.getName().isEmpty()) {
			memberVO.setMessage("姓名必須輸入");
			memberVO.setSuccessful(false);
			return memberVO;
		}
		final Date birthday = memberVO.getBirthday();
		if (memberVO.getBirthday() == null || Objects.equals(birthday, "")) {
			memberVO.setMessage("生日必須輸入");
			memberVO.setSuccessful(false);
			return memberVO;
		}

		if (memberVO.getMail() == null || memberVO.getMail().isEmpty()) {
			memberVO.setMessage("帳號信箱必須輸入");
			memberVO.setSuccessful(false);
			return memberVO;
		}
		String memberPassString = memberVO.getMemberPassword();
		if (memberVO.getMemberPassword() == null || memberVO.getMemberPassword().isEmpty()) {
			memberVO.setMessage("密碼必須輸入");
			memberVO.setSuccessful(false);
			return memberVO;
		}
		if (memberPassString.length() < 6 || memberPassString.length() > 12) {
			memberVO.setMessage("密碼長度需介於6~12個字元");
		}
		if (memberVO.getTel() == null || memberVO.getTel().isEmpty()) {
			memberVO.setMessage("電話必須輸入");
			memberVO.setSuccessful(false);
			return memberVO;
		}
		// 判定帳號有無重複
		if (dao.selectBymail(memberVO.getMail()) != null) {
			memberVO.setMessage("此帳號重複");
			memberVO.setSuccessful(false);
			return memberVO;
		}
		if (memberVO.getMessage() != null) {
			return memberVO;
		}

//		final byte[] memberPic = memberVO.getMemberPic();
//		if(memberPic==null || Objects.equals(memberPic, "")) {
//			return "設定你的頭貼吧";
//		}

		dao.insert(memberVO);
		memberVO.setSuccessful(true);
		memberVO.setMessage("註冊成功");
		return memberVO;
	}

//先拿到使用者要看的資料
	@Override
	public MemberVO findMemberByNo(MemberVO memberVO) {
		return null;
	}

//===============修改會員資料===============
	@Override
	public MemberVO edit(MemberVO memberVO) {

//		MemberVO memeberdata = dao.selectByMemberNo(memberVO.getMemberNo());
//		memberVO.setName(memeberdata.getName());
//		memberVO.setMemberPassword(memeberdata.getMemberPassword());
//		memberVO.setTel(memeberdata.getTel());
////		memberVO.setMemberPic(memeberdata.getMemberPic());
//		memberVO = dao.update(memberVO);
		return memberVO;
	}

//資料編輯完儲存檔案時呼叫
	@Override
	public boolean save(MemberVO memberVO) {
		String memberPassword = memberVO.getMemberPassword();
		if (memberPassword == null || memberPassword.length() < 6 || memberPassword.length() > 12) {
			memberVO.setMessage("密碼長度需介於6~12個字元");
			return false;
		}
		return dao.update(memberVO) > 0;
	}

//===============忘記密碼===============
	@Override
	public MemberVO forgotPassWord(MemberVO memberVO) {
//		String mail = memberVO.getMemberPassword();
		MemberVO mailRessult = dao.selectBymail(memberVO.getMail());
		
		return mailRessult;
	}

}
