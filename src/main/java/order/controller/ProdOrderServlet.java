package order.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.service.ProdOrderService;
import order.vo.ProdOrderVO;

@WebServlet("/order/ProdOrderServlet")
public class ProdOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void goGet(HttpServletRequest req, HttpServletResponse res)
			throws ServerException, IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServerException, IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("prodOrderNo");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入正確訂單編號。");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/selectProdOrder.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer prodOrderNo = null;
			try {
				prodOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確。");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/selectProdOrder.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ProdOrderService prodOrderService = new ProdOrderService();
			ProdOrderVO prodOrderVO = prodOrderService.select(prodOrderNo);
			System.out.println(prodOrderVO.getProdOrderNo());
			if (prodOrderVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/selectProdOrder.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("prodOrderVO", prodOrderVO); // 資料庫取出的empVO物件,存入req
			String url = "/order/listoneProdOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer prodOrderNo = Integer.valueOf(req.getParameter("prodOrderNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			ProdOrderService prodOrderService = new ProdOrderService();
			ProdOrderVO prodOrderVO = prodOrderService.select(prodOrderNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("prodOrderVO", prodOrderVO); // 資料庫取出的empVO物件,存入req
			String url = "/order/getallProdOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

//		if ("insert".equals(action)) { // 來自addEmp.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//			String ename = req.getParameter("ename");
//			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			if (ename == null || ename.trim().length() == 0) {
//				errorMsgs.add("員工姓名: 請勿空白");
//			} else if (!ename.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}
//
//			String job = req.getParameter("job").trim();
//			if (job == null || job.trim().length() == 0) {
//				errorMsgs.add("職位請勿空白");
//			}
//
//			java.sql.Date hiredate = null;
//			try {
//				hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//			} catch (IllegalArgumentException e) {
//				hiredate = new java.sql.Date(System.currentTimeMillis());
//				errorMsgs.add("請輸入日期!");
//			}
//
//			Double sal = null;
//			try {
//				sal = Double.valueOf(req.getParameter("sal").trim());
//			} catch (NumberFormatException e) {
//				sal = 0.0;
//				errorMsgs.add("薪水請填數字.");
//			}
//
//			Double comm = null;
//			try {
//				comm = Double.valueOf(req.getParameter("comm").trim());
//			} catch (NumberFormatException e) {
//				comm = 0.0;
//				errorMsgs.add("獎金請填數字.");
//			}
//
//			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//			EmpVO empVO = new EmpVO();
//			empVO.setEname(ename);
//			empVO.setJob(job);
//			empVO.setHiredate(hiredate);
//			empVO.setSal(sal);
//			empVO.setComm(comm);
//			empVO.setDeptno(deptno);
//
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
//				RequestDispatcher failureView = req.getRequestDispatcher("/emp/addEmp.jsp");
//				failureView.forward(req, res);
//				return;
//			}
//
//			/*************************** 2.開始新增資料 ***************************************/
//			EmpService empSvc = new EmpService();
//			empVO = empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);
//
//			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			String url = "/order/addProdOrder.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//			successView.forward(req, res);
//		}

	}

}
