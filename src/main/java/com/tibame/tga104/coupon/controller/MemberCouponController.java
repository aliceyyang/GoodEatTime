package com.tibame.tga104.coupon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tibame.tga104.coupon.service.MemberCouponService;
import com.tibame.tga104.coupon.vo.MemberCouponVO;

public class MemberCouponController {

	@Autowired
	private MemberCouponService memberCouponService;

	@PutMapping("/memberCoupon/usage/{couponNo}")
	private ResponseEntity<MemberCouponVO> updateusageStatus(@PathVariable Integer memberNo,
			@PathVariable Integer couponNo, @RequestBody @Valid MemberCouponVO memberCouponVO) {
		MemberCouponVO vo = memberCouponService.getOneMemberCoupon(memberNo, couponNo);
		if (vo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(vo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/memberCoupon/memberNo/{memberNo}")
	public ResponseEntity<MemberCouponVO> getOnememberCoupon(@PathVariable Integer memberNo
															,@PathVariable Integer couponNo) {
		MemberCouponVO vo = memberCouponService.getOneMemberCoupon(memberNo, couponNo);
		if (vo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(vo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/memberCoupon")
	private ResponseEntity<List<MemberCouponVO>> getAll() {
		List<MemberCouponVO> getAllCoupon = memberCouponService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(getAllCoupon);
		
	}
}
