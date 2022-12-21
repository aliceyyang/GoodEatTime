package com.tibame.tga104.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.order.service.ProdOrderDetailService;
import com.tibame.tga104.order.service.ProdOrderService;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;
import com.tibame.tga104.order.vo.ProdOrderVO;
import com.tibame.tga104.product.helper.OrderInsertWrapper;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private ProdOrderService prodOrderService;
	@Autowired
	private ProdOrderDetailService prodOrderDetailService;
	
	@PostMapping("insert")
	public Map<String, String> insert(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO, 
			@RequestBody OrderInsertWrapper order) {
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
		}
		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		memberNo = 5;
		order.getProdOrderVO().setMemberNo(memberNo);
		Map<String, String> result = new HashMap<>();
		if (prodOrderService.insert(order) == null) {
			result.put("insert", "fail");
		} else {
			result.put("insert", "success");
		}
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
}
