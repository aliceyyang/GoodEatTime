package com.tibame.tga104.member.service.impl;

import com.tibame.tga104.member.dao.MemberDAO;
import com.tibame.tga104.member.dao.MemberSpringDAO;
import com.tibame.tga104.member.service.MemberService;
import com.tibame.tga104.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberSpringDAO memberSpringDAO;
    @Override
    public List<MemberVO> getAccountByAll() {
        return memberSpringDAO.getAccountByAll();
    }
}
