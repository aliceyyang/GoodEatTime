package com.tibame.tga104.product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.product.helper.ProdDetailWrapper;
import com.tibame.tga104.product.helper.ShoppingMallWrapper;
import com.tibame.tga104.product.service.ProdCategoryService;
import com.tibame.tga104.product.service.ProdInfoService;
import com.tibame.tga104.product.service.ProdPicService;
import com.tibame.tga104.product.service.ShoppingCartService;
import com.tibame.tga104.product.service.ShowProdDetailService;
import com.tibame.tga104.product.service.ShowProdInMallService;
import com.tibame.tga104.product.vo.ProdInfoVO;
import com.tibame.tga104.product.vo.ProdPicVO;
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
	public ShoppingMallWrapper showAll(@SessionAttribute(name = "memberVO", required = false) MemberVO memberVO) {
//		Map<String, List> map = new HashMap<String, List>();
//		map.put("prodList", showProdInMallService.getAll());
//		map.put("prodCategoryList", prodCategoryService.getAll());
//		return map;
//		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
//		System.out.println("memberNo="+memberNo);
		// 目前memberNo還是先寫死
		ShoppingMallWrapper result = new ShoppingMallWrapper.Builder().setProdList(showProdInMallService.getAll())
				.setProdCategoryList(prodCategoryService.getAll()).build();
		
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
			result.setShoppingCart(shoppingCartService.findByMemberNo(memberNo));
		}
		
		return result;
	}

	@GetMapping("detail")
	public ProdDetailWrapper showOneDetail(@RequestParam Integer prodNo,
			@SessionAttribute(name = "memberVO", required = false) MemberVO memberVO) {
//		System.out.println("memberNo=" + memberNo);
		ProdDetailWrapper result = new ProdDetailWrapper();
		result.setShowProdDetailVO(showProdDetailService.select(prodNo));
		result.setProdPicList(prodPicService.getPicNoByProdNo(prodNo));
		
		Integer memberNo = null;
		if (memberVO != null) {
			memberNo = memberVO.getMemberNo();
			result.setShoppingCart(shoppingCartService.findByMemberNo(memberNo));
		}
		
		if (result.getShowProdDetailVO() != null) {
			result.setSimilarProdList(
					showProdInMallService.select6ByCategory(result.getShowProdDetailVO().getProdCategoryNo()));
		}
		return result;
	}

	// 若找不到的話，回傳一個查無此圖片的的圖片?
	@GetMapping("mainPic")
	public byte[] showMainPic(@RequestParam Integer prodNo) {
		if (prodNo == null) {
			return null;
		}
		ProdInfoVO vo = prodInfoService.getOneProduct(prodNo);
		if (vo == null) {
			return null;
		}
		return prodInfoService.getOneProduct(prodNo).getProdMainPic();
	}

	// 若找不到的話，回傳一個查無此圖片的的圖片?
	@GetMapping("prodPic")
	public byte[] showProdPics(@RequestParam Integer prodPicNo) {
		if (prodPicNo == null) {
			return null;
		}
		ProdPicVO vo = prodPicService.getOneProdPic(prodPicNo);
		if (vo == null) {
			return null;
		}
		return prodPicService.getOneProdPic(prodPicNo).getProdPic();
	}

	@PostMapping("addProdInfo")
	public ProdInfoVO addNewProd(@RequestBody(required = false) ProdInfoVO prodInfoVO) {
		return prodInfoService.insertProd(prodInfoVO);
	}

	@PutMapping("updateProdInfo")
	public ProdInfoVO updateProd(@RequestBody(required = false) ProdInfoVO prodInfoVO) {
		ProdInfoVO target = prodInfoService.getOneProduct(prodInfoVO.getProdNo());
		target.setProdMainPicStr(prodInfoVO.getProdMainPicStr());
		return prodInfoService.update(target);
	}
}
