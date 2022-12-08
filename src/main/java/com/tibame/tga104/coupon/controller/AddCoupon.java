package com.tibame.tga104.coupon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.tga104.coupon.service.CouponServiceImpl;
import com.tibame.tga104.coupon.vo.CouponVO;


@WebServlet("/coupon/AddCoupon")
public class AddCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCoupon() {
		super();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CouponServiceImpl couSvc = new CouponServiceImpl();
		CouponVO couVO = new CouponVO();
		req.setAttribute("couVO", couVO);
		String url = "/coupon/listOneCoupon.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		
	}
}
