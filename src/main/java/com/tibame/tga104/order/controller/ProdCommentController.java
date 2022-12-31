package com.tibame.tga104.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.order.service.ProdCommentService;
import com.tibame.tga104.order.service.ProdOrderDetailService;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;

@RestController
@RequestMapping("prodcomment")
public class ProdCommentController {
	
	@Autowired
	private ProdCommentService prodCommentService;
	
	@Autowired
	private ProdOrderDetailService prodOrderDetailService;
	
	@PostMapping("NotNullComment")
	public List<ProdOrderDetailVO> notNullComment(){
		return prodCommentService.selectNotNullComment();
	}
	
	@PostMapping("NullComment")
	public List<ProdOrderDetailVO> nullComment(){
		return prodCommentService.selectNullComment();
	}
	
	@PostMapping("Comment")
	public ProdOrderDetailVO prodCommnet (@RequestBody(required = false) ProdOrderDetailVO prodOrderDetailVO) {
		return prodCommentService.updateProdCommnet(prodOrderDetailVO);
	}
	
	@PostMapping("CommentReply")
	public ProdOrderDetailVO prodCommentReply(@RequestBody(required = false) ProdOrderDetailVO prodOrderDetailVO) {
		System.out.println(prodOrderDetailVO);
		return prodCommentService.replyProdComment(prodOrderDetailVO);
	}
	
	@GetMapping("ShowCommentPic")
	public byte[] showCommentPic(@RequestParam Integer prodOrderNo, @RequestParam Integer prodNo) {
		return prodOrderDetailService
				.select(prodOrderNo,prodNo)
				.getProdCommentPic();
	}
}
