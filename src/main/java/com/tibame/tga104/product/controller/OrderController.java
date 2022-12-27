package com.tibame.tga104.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.order.service.ProdOrderService;
import com.tibame.tga104.product.helper.OrderInsertWrapper;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private ProdOrderService prodOrderService;
	
	@GetMapping("receiver")
	public MemberVO receiver (@SessionAttribute(name="memberVO")MemberVO memberVO) {
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
	public OrderInsertWrapper insert(@SessionAttribute(name="memberVO", required=false)MemberVO memberVO, 
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
}
