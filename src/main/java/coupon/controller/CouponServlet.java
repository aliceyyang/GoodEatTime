package coupon.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import coupon.dao.impl.CouponDaoImpl;
import coupon.vo.CouponVO;
public class CouponServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getAll".equals(action)) {
			
			CouponDaoImpl dao = new CouponDaoImpl();
			List<CouponVO> list = dao.getALL();
			
			HttpSession session = req.getSession();
			session.setAttribute("list", list);
			String url = "coupon/coupon.jsp";
		}
	}
}
