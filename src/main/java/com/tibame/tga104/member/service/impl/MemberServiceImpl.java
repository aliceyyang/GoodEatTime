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


	@Override
	public MemberVO register(MemberVO memberVO) {
		if (memberVO.getName() == null || memberVO.getName().isEmpty()) {
			memberVO.setMessage("姓名必須輸入");
		}
		final Date birthday = memberVO.getBirthday();
		if(memberVO.getBirthday()==null || Objects.equals(birthday, "")) {
			memberVO.setMessage("生日必須輸入");
		}

		if (memberVO.getMail() == null || memberVO.getMail().isEmpty()) {
			memberVO.setMessage("帳號信箱必須輸入");		
		}
		
		if (memberVO.getMemberPassword() == null || memberVO.getMemberPassword().isEmpty()) {
			memberVO.setMessage("密碼必須輸入");		
		}
		
		if (memberVO.getTel() == null || memberVO.getTel().isEmpty()) {
			memberVO.setMessage("電話必須輸入");		
		}
		if (memberVO.getMessage()!= null) {
			return memberVO;
		}
		
//		final byte[] memberPic = memberVO.getMemberPic();
//		if(memberPic==null || Objects.equals(memberPic, "")) {
//			return "設定你的頭貼吧";
//		}

		memberVO.setMessage("註冊成功"); 
		
		dao.insert(memberVO);
		return memberVO;
	}



}
