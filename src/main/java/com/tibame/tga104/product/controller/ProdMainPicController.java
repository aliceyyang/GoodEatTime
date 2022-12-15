package com.tibame.tga104.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.tga104.product.service.ProdInfoService;
import com.tibame.tga104.product.vo.ProdInfoVO;

@WebServlet("/product/mainPic")
public class ProdMainPicController extends HttpServlet  {
	private static final long serialVersionUID = 4645305526234573528L;
	@Autowired
	private ProdInfoService svc;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer prodNo = Integer.valueOf(req.getParameter("prodNo"));
		ProdInfoVO prodInfoVO = svc.getOneProduct(prodNo);
		byte[] pic = prodInfoVO.getProdMainPic();
		resp.setContentType("image/jpg");
		resp.getOutputStream().write(pic);
	}
}
