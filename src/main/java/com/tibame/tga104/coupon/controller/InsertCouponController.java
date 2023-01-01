package com.tibame.tga104.coupon.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

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
import com.tibame.tga104.member.vo.RestaurantMemberVO;

@WebServlet("/coupon/insert")
public class InsertCouponController extends HttpServlet {
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
		RestaurantMemberVO restaurantMemberVO = new RestaurantMemberVO();
		restaurantMemberVO =  (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
		CouponVO vo = svc.insertByRestaurantNo(restaurantMemberVO.getRestaurantNo());
		
//		CouponVO vo = gson.fromJson(req.getReader(), CouponVO.class);

		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().write(gson.toJson(vo));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RestaurantMemberVO restaurantMemberVO = new RestaurantMemberVO();
		restaurantMemberVO = (RestaurantMemberVO) session.getAttribute("restaurantMemberVO");
//		session.getAttribute("restaurantVO");
		CouponVO vo = gson.fromJson(req.getReader(), CouponVO.class);
//		CouponVO vo = new CouponVO();
//		vo.setCouponName(req.getParameter("couponName"));
//		vo.setCouponStartTime(Date.valueOf(req.getParameter("couponStartTime")));
//		vo.setCouponEndTime(Date.valueOf(req.getParameter("couponEndTime")));
//		vo.setCouponContent(req.getParameter("couponContent"));
//		vo.setUsageLimitation(Integer.valueOf(req.getParameter("usageLimitation")));
//		vo.setAmountOrFold(Double.valueOf(req.getParameter("amountOrFold")));
//		vo.setCouponType(Boolean.valueOf(req.getParameter("couponType")));
//		vo.setMaxIssueQty(Integer.valueOf(req.getParameter("maxIssueQty")));
//		vo.setIssuedQty(Integer.valueOf(req.getParameter("issuedQty")));
//		byte[] couponPic = (byte[])req.getParameter("couponPic");
//		byte[] couponPic = 
//		vo.setCouponPic(Byte.valueOf(req.getParameter("couponPic")));
//		System.out.println(vo);
		vo.setRestaurantNo(1);
		svc.insertCoupon(vo);
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().write(gson.toJson(vo));
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("listOneCoupon.jsp").forward(req, resp);
	}
	
}
