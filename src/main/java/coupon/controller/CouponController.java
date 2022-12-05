package coupon.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import coupon.dao.CouponDao;
import coupon.dao.CouponJDBCDAO;
import coupon.dao.impl.CouponDaoImpl;
import coupon.service.CouponService;
import coupon.service.CouponServiceImpl;
import coupon.vo.CouponVO;
@WebServlet("/CouponController")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CouponController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		super.doGet(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		/*************************** 開始查詢資料 ****************************************/

		if ("getAll".equals(action)) {
			CouponJDBCDAO dao = new CouponJDBCDAO();
			List<CouponVO> list = dao.getAll();

		/**************************** 查詢完成 , 準備轉交****************************************/

			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件 , 存入session中
			// Send the success view
			String url = "coupon/listAllCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}

		if ("getOne".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			String str = req.getParameter("couponNo");
			if (str == null || (str.trim().length() == 0)) {
				errorMsgs.add("請輸入優惠券編號");

			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failurView = req.getRequestDispatcher("/coupon/selectCoupon.jsp");
				failurView.forward(req, res);
				return;// 程式中斷
			}

			Integer couponNo = null;
			try {
				couponNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("優惠券編號格是不正確");
			}
			// Send the use back to the form, if there were erroes
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/coupon/selectCoupon.jsp");
				return;// 程式中斷
			}

		/*************************** 開始查詢資料 ****************************************/

			CouponDaoImpl dao = new CouponDaoImpl();
			CouponVO couponVO = dao.findByPrimaryKey(couponNo);
			if (couponVO == null) {
				errorMsgs.add("查無資料");

			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/compon/selectCoupon.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
		/*************************** * 查詢完成 , 準備轉交****************************************/

			req.setAttribute("coupnVO", couponVO); // 資料庫取出couponVO物件, 存入req
			String url = "/coupon/listOneCoupon.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}
	}
}
