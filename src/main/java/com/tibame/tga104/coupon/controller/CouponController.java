package com.tibame.tga104.coupon.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.ErrorManager;

import javax.print.attribute.standard.Destination;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.tga104.coupon.service.CouponServiceImpl;
import com.tibame.tga104.coupon.vo.CouponVO;

@WebServlet("/coupon/AddCoupon")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CouponController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String listAllView = "/coupon/listAllCoupon.jsp";
		String listOneView = "/coupon/listOneCoupon.jsp";
		String selectView = "/coupon/selectCoupon.jsp";
		String updateView = "/coupon/updateCoupon.jsp";
		String addView = "/coupon/addCoupon.jsp";
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		CouponServiceImpl couponSvc = new CouponServiceImpl();
		HttpSession session = req.getSession();
		System.out.println("into servlet");
		if ("getAll".equals(action)) {
			List<CouponVO> list = couponSvc.getAll();
			session.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher(listAllView);
			dispatcher.forward(req, res);
			return;
		}
		if ("getOne".equals(action)) {
			List<String> errormsg = new LinkedList<String>();
			String couponNo = req.getParameter("couponNo");
			if (couponNo == null || couponNo.trim().length() == 0) {
				errormsg.add("請輸入優惠券編號");
				req.setAttribute("errorMsgs", errormsg);
				RequestDispatcher dispatcher = req.getRequestDispatcher(selectView);
				dispatcher.forward(req, res);
				return;
			}
			Integer coupono = null;
			try {
				coupono = Integer.valueOf(couponNo.trim());
			} catch (Exception e) {
				errormsg.add("優惠券編號格式不正確");
				req.setAttribute("errorMsgs", errormsg);
				RequestDispatcher dispatcher = req.getRequestDispatcher(selectView);
				dispatcher.forward(req, res);
				return;
			}
			CouponVO couponvo = couponSvc.getOneCoupon(coupono);
			req.setAttribute("couponVO", couponvo);
			RequestDispatcher dispatcher = req.getRequestDispatcher(listOneView);
			dispatcher.forward(req, res);
		}
		if ("deleteCoupon".equals(action)) {
			String couponNo = req.getParameter("couponNo");
			Integer couponno = Integer.valueOf(couponNo.trim());
			couponSvc.deleteCoupon(couponno);
			List<CouponVO> list = couponSvc.getAll();
			session.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher(listAllView);
			dispatcher.forward(req, res);
			return;
		}
		if ("updateCoupon".equals(action)) {
			List<String> errormsg = new LinkedList<String>();
			req.setAttribute("errormsg", errormsg);
			String couponNo = req.getParameter("couponNo");
			Integer coupono = null;
			coupono = Integer.valueOf(couponNo.trim());
			CouponVO couponvo = couponSvc.getOneCoupon(coupono);
			if (couponvo != null) {
				couponSvc.updateCoupon(couponvo);
			}
		}
	}
}
