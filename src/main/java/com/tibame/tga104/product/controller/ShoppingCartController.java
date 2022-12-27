package com.tibame.tga104.product.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		return shoppingCartService.findByMemberNo(memberNo);
	}
	
	@GetMapping("allDetail")
	public Collection<ShoppingCartWrapper> showAllDetail(HttpSession session) {
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		return shoppingCartService.convert(shoppingCartService.findByMemberNo(memberNo));
	}
	
	@PostMapping("insert")
	public Map<String, String> insert(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO,
			@RequestBody Map<String, Integer> prodNo) {
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		if (prodNo == null || prodNo.get("prodNo") == null) {
			return null;
		}
		
		ShoppingCartVO vo = new ShoppingCartVO();
		vo.setMemberNo(memberNo);
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
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		if (prod == null || prod.get("prodNo") == null || prod.get("prodQty") == null) {
			return null;
		}
		ShoppingCartVO vo = new ShoppingCartVO();
		vo.setMemberNo(memberNo);
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
	
	@PatchMapping("update")
	public Map<String, String> update(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO,
			@RequestBody Map<String, Integer> prod) {
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		if (prod == null || prod.get("prodNo") == null || prod.get("prodQty") == null) {
			return null;
		}
		ShoppingCartVO vo = new ShoppingCartVO();
		vo.setMemberNo(memberNo);
		vo.setProdNo(prod.get("prodNo"));
		vo.setProdQty(prod.get("prodQty"));
		
		Map<String, String> result = new HashMap<>();
		if (shoppingCartService.update(vo)!= null) {
			result.put("update", "success");
		}else {
			result.put("update", "fail");
		}
		
		return result;
	}
	
	@DeleteMapping("delete")
	public Map<String, String> delete(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO,
			@RequestBody Map<String, Integer> prodNo) {
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		if (prodNo == null || prodNo.get("prodNo") == null) {
			return null;
		}
		
		Map<String, String> result = new HashMap<>();
		if (shoppingCartService.delete(memberNo, prodNo.get("prodNo"))) {
			result.put("delete", "success");
		}else {
			result.put("delete", "fail");
		}
		
		return result;
	}
}
