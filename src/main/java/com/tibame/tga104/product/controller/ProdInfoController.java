package com.tibame.tga104.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.product.helper.ShoppingMallWrapper;
import com.tibame.tga104.product.service.ProdCategoryService;
import com.tibame.tga104.product.service.ProdInfoService;
import com.tibame.tga104.product.service.ProdPicService;
import com.tibame.tga104.product.service.ShoppingCartService;
import com.tibame.tga104.product.service.ShowProdDetailService;
import com.tibame.tga104.product.service.ShowProdInMallService;
import com.tibame.tga104.product.vo.ShowProdDetailVO;

@RestController
@RequestMapping("product")
public class ProdInfoController {
	@Autowired
	private ShowProdInMallService showProdInMallService;
	@Autowired
	private ShowProdDetailService showProdDetailService;
	@Autowired
	private ProdPicService prodPicService;
	@Autowired
	private ProdCategoryService prodCategoryService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ProdInfoService prodInfoService;
	
	@GetMapping("all")
	public ShoppingMallWrapper showAll(HttpSession session) {
//		Map<String, List> map = new HashMap<String, List>();
//		map.put("prodList", showProdInMallService.getAll());
//		map.put("prodCategoryList", prodCategoryService.getAll());
//		return map;
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
		}
		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		ShoppingMallWrapper result = new ShoppingMallWrapper.Builder()
															.setProdList(showProdInMallService.getAll())
															.setProdCategoryList(prodCategoryService.getAll())
															.setShoppingCart(shoppingCartService.findByMemberNo(5))
															.build();
		return result;
	}
	
	@GetMapping("detail")
	public ShowProdDetailVO showOneDetail(@RequestParam Integer prodNo) {
		ShowProdDetailVO vo = showProdDetailService.select(prodNo);
		vo.setProdPicList(prodPicService.getPicNoByProdNo(prodNo));
		return vo;
	}
	
	@GetMapping("mainPic")
	public byte[] showMainPic(@RequestParam Integer prodNo) {
		return prodInfoService.getOneProduct(prodNo).getProdMainPic();
	}
	
	@GetMapping("prodPic")
	public byte[] showProdPics(@RequestParam Integer prodPicNo) {
		return prodPicService.getOneProdPic(prodPicNo).getProdPic();
	}

}
