package com.tibame.tga104.coupon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.coupon.service.MemberCouponService;
import com.tibame.tga104.coupon.vo.MemberCouponVO;
import com.tibame.tga104.member.vo.MemberVO;
@RestController
@RequestMapping("/coupon_member")
public class MemberCouponController {

	@Autowired
	private MemberCouponService memberCouponService;
//暫時寫死
	@RequestMapping(value="/coupon1", method=RequestMethod.GET)
	public Map<String, List<MemberCouponVO>> member() {
		List<MemberCouponVO> list = memberCouponService.getCouponBymemberNo(1);
		Map<String, List<MemberCouponVO>> map = new HashMap<>();
		map.put("data",list);
//		System.out.println(list);
		return map;
	}
////正確
//	@RequestMapping(value="/coupon", method=RequestMethod.GET)
//	public Map<String, Object> member(HttpSession session) {
//		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
//		List<MemberCouponVO> list = memberCouponService.getCouponBymemberNo(memberVO.getMemberNo());
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("data", list);
//		return map;
//	}
//	@GetMapping("/memberCoupon/memberNo/{memberNo}")
//	public ResponseEntity<List<MemberCouponVO>> getOnememberCoupon(@PathVariable Integer memberNo
//															,@PathVariable Integer couponNo) {
////		MemberCouponVO vo = memberCouponService.getCouponBymemberNo(memberNo);
//		List<MemberCouponVO> list = memberCouponService.getCouponBymemberNo(memberNo);
//		if (list != null) {
//			return ResponseEntity.status(HttpStatus.OK).body(list);
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//	}
//	
//	@GetMapping("/memberCoupon")
//	private ResponseEntity<List<MemberCouponVO>> getAll() {
//		List<MemberCouponVO> getAllCoupon = memberCouponService.getAll();
//		return ResponseEntity.status(HttpStatus.OK).body(getAllCoupon);
//		
//	}
}
