package com.tibame.tga104.coupon.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.tga104.coupon.dao.CouponJDBCDAO;
import com.tibame.tga104.coupon.dao.impl.CouponDaoImpl;
import com.tibame.tga104.coupon.vo.CouponVO;

@WebServlet("/coupon/CouponContr")
public class AddCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCoupon() {
		super();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		
	}
}
