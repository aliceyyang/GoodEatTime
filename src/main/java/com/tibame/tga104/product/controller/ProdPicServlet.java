package com.tibame.tga104.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.tga104.product.service.ProdPicService;
import com.tibame.tga104.product.vo.ProdPicVO;

//@WebServlet("/product/ProdPic")
public class ProdPicServlet extends HttpServlet {
	private static final long serialVersionUID = -3689216109803591273L;
	
	@Autowired
	private ProdPicService svc;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer prodPicNo = Integer.valueOf(req.getParameter("prodPicNo"));
		ProdPicVO prodPicVO = svc.getOneProdPic(prodPicNo);
		byte[] pic = prodPicVO.getProdPic();
		resp.setContentType("image/jpg");
		resp.getOutputStream().write(pic);
	}
}
