package com.tibame.tga104.product.controller;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.product.helper.ShoppingCartWrapper;
import com.tibame.tga104.product.service.ShoppingCartService;

@RestController
@RequestMapping("cart")
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping("all")
	public Map<Integer, Integer> showAll(HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
		}
		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		return shoppingCartService.findByMemberNo(5);
	}
	
	@GetMapping("allDetail")
	public Collection<ShoppingCartWrapper> showAllDetail(HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
		}
		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		return shoppingCartService.convert(shoppingCartService.findByMemberNo(5));
	}
}
