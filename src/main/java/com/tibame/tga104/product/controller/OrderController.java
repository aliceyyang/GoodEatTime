package com.tibame.tga104.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.order.service.OrderSearchService;
import com.tibame.tga104.order.service.ProdOrderService;
import com.tibame.tga104.order.vo.OrderSearchVO;
import com.tibame.tga104.product.helper.OrderInsertWrapper;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private ProdOrderService prodOrderService;

	@Autowired
	private OrderSearchService orderSearchService;

	@GetMapping("receiver")
	public MemberVO receiver(@SessionAttribute(name = "memberVO") MemberVO memberVO) {
		if (memberVO == null) {
			return null;
		}
		MemberVO vo = new MemberVO();
		vo.setMemberNo(memberVO.getMemberNo());
		vo.setMail(memberVO.getMail());
		vo.setTel(memberVO.getTel());
		vo.setName(memberVO.getName());
		return vo;
	}

	@PostMapping("insert")
	public OrderInsertWrapper insert(@SessionAttribute(name = "memberVO", required = false) MemberVO memberVO,
			@RequestBody OrderInsertWrapper order) {
		if (memberVO == null || memberVO.getMemberNo() == null) {
			return null;
		}
		Integer memberNo = memberVO.getMemberNo();
		order.getProdOrderVO().setMemberNo(memberNo);
		OrderInsertWrapper result = prodOrderService.insert(order);
		if (result == null) {
			result = new OrderInsertWrapper();
			result.setMessage("Insert Fail");
		} else {
			result.setMessage("Insert Success");
		}

//		Map<String, String> result = new HashMap<>();
//		if (prodOrderService.insert(order) == null) {
//			result.put("insert", "fail");
//		} else {
//			result.put("insert", "success");
//		}
//		ProdOrderVO prodOrderVO = order.getProdOrderVO();
//		List<ProdOrderDetailVO> orderDetailList =order.getOrderDetailList();
//		
//		prodOrderVO.setMemberNo(memberNo);
//		
//		Map<String, String> result = new HashMap<>();
//		prodOrderVO = prodOrderService.insert(prodOrderVO);
//		if (prodOrderVO == null) {
//			result.put("insert", "fail");
//			return result;
//		} 
//		Integer prodOrderNo = prodOrderVO.getProdOrderNo();
//		for (ProdOrderDetailVO vo : orderDetailList) {
//			vo.setProdOrderNo(prodOrderNo);
//			prodOrderDetailService.insertNewOrder(vo);
//		}
//		
//		result.put("insert", "success");
		return result;
	}

	@GetMapping("memberSearch")
	public Map<String, List<OrderSearchVO>> orderSearch(@SessionAttribute(name = "memberVO") MemberVO memberVO) {
		Map<String, List<OrderSearchVO>> result = new HashMap<>();

//			result.put("data", orderSearchService.selectByMemberNo(5));
		result.put("data", orderSearchService.selectByMemberNo(memberVO.getMemberNo()));
		return result;

	}

	@GetMapping("restaurantSearch")
	public Map<String, List<OrderSearchVO>> restaurantSearch(
			@SessionAttribute(name = "restaurantMemberVO", required = false) RestaurantMemberVO restaurantMemberVO) {
		Map<String, List<OrderSearchVO>> result = new HashMap<>();
//		result.put("data", orderSearchService.selectByRestaurantNo(2));
		result.put("data", orderSearchService.selectByRestaurantNo(restaurantMemberVO.getRestaurantNo()));
		return result;
	}

	@GetMapping("detail")
	public List<OrderSearchVO> orderDetail(@RequestParam Integer prodOrderNo) {
		return orderSearchService.selectByProdOrderNo(prodOrderNo);
	}

	@GetMapping("restaurantdetail")
	public List<OrderSearchVO> restaurantDetail(@RequestParam Integer prodOrderNo) {
		return orderSearchService.selectByProdOrderNo(prodOrderNo);
	}
}
