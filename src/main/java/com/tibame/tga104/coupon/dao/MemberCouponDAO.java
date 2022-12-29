package com.tibame.tga104.coupon.dao;

import java.util.List;

import com.tibame.tga104.coupon.vo.MemberCouponVO;
import com.tibame.tga104.member.vo.MemberVO;

public interface MemberCouponDAO {

	public List<MemberCouponVO> selectAllCouponByMemberNo(Integer memberNo);

	public MemberCouponVO insert(Integer memberNo, Integer couponNo);
	
	public boolean update(MemberCouponVO memberCouponVO);
	
	public boolean delete(Integer memberNo);
	
	public List<MemberCouponVO> getAll();

}
