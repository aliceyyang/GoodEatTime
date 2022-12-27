package com.tibame.tga104.coupon.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tibame.tga104.coupon.service.CouponService;
import com.tibame.tga104.coupon.service.CouponServiceImpl;
import com.tibame.tga104.coupon.vo.CouponVO;

@WebServlet("/coupon/Manage")
public class CouponManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponService svc;
	private Gson gson;

	@Override
	public void init() throws ServletException {
		svc = new CouponServiceImpl();
		gson = new GsonBuilder()
				.setDateFormat("yyyy/MM/dd")
				.create();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer restaurantNo = (Integer) session.getAttribute("restaurantNo");
		
		// TODO 暫時寫死!!!
//		System.out.println("AAA");
		List<CouponVO> list = svc.findByRestaurantNo(1);
		Map<String, List> map = new HashMap<String, List>();
		map.put("data", list);
		System.out.println(list);
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().write(gson.toJson(map));
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("coupon_restaurant.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CouponVO> list = svc.getAllcouponPic();
		System.out.println(list);
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().write(gson.toJson(list));

	}
}
