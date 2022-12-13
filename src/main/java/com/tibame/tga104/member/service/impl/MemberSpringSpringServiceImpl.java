package com.tibame.tga104.member.service.impl;

import com.tibame.tga104.member.dao.MemberSpringDAO;
import com.tibame.tga104.member.service.MemberSpringService;
import com.tibame.tga104.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberSpringSpringServiceImpl implements MemberSpringService {
    @Autowired
    private MemberSpringDAO memberSpringDAO;
    @Override
    public List<MemberVO> getAccountByAll() {
        return memberSpringDAO.getAccountByAll();
    }
}
