package com.tibame.tga104.product.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.product.helper.ShoppingCartWrapper;
import com.tibame.tga104.product.service.ShoppingCartService;
import com.tibame.tga104.product.vo.ShoppingCartVO;

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
	
	@PostMapping("insert")
	public Map<String, String> insert(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO,
			@RequestBody Map<String, Integer> prodNo) {
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
		}
		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		if (prodNo == null || prodNo.get("prodNo") == null) {
			return null;
		}
		
		ShoppingCartVO vo = new ShoppingCartVO();
		vo.setMemberNo(5);
		vo.setProdNo(prodNo.get("prodNo"));
		vo.setProdQty(1);
		
		Map<String, String> result = new HashMap<>();
		if (shoppingCartService.insert(vo)!= null) {
			result.put("add", "success");
		}else {
			result.put("add", "fail");
		}
		
		return result;
	}
	
	@PostMapping("insertQty")
	public Map<String, String> insertQty(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO,
			@RequestBody Map<String, Integer> prod) {
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
		}
		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		if (prod == null || prod.get("prodNo") == null || prod.get("prodQty") == null) {
			return null;
		}
		ShoppingCartVO vo = new ShoppingCartVO();
		vo.setMemberNo(5);
		vo.setProdNo(prod.get("prodNo"));
		vo.setProdQty(prod.get("prodQty"));
		
		Map<String, String> result = new HashMap<>();
		if (shoppingCartService.insert(vo)!= null) {
			result.put("add", "success");
		}else {
			result.put("add", "fail");
		}
		
		return result;
	}
}
