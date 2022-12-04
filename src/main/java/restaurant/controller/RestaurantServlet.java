package restaurant.controller;

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

import restaurant.service.RestaurantService;
import restaurant.service.impl.RestaurantServiceImpl;
import restaurant.vo.RestaurantVO;

@WebServlet("/restaurant/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("list", list); // 資料庫取出的list物件,存入session
//		
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		RestaurantService svc = new RestaurantServiceImpl();
		HttpSession session = req.getSession();

//=====================查資料======================================================================================

		if ("getAll".equals(action)) {
			List<RestaurantVO> list = svc.getAll();
    		session.setAttribute("list", list);
    		req.getRequestDispatcher("../restaurant/listAllRestaurant.jsp").forward(req, res);
    		return;
    	}
		
		if ("getOne_For_Display".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			
			
			req.setAttribute("errorMsgs", errorMsgs);
			String restaurantNostr = req.getParameter("restaurantNo");
			if (restaurantNostr == null || (restaurantNostr.trim()).length() == 0) {
				errorMsgs.add("請輸入餐廳編號");
			}
			Integer restaurantNo = null;
			try {
				restaurantNo = Integer.valueOf(restaurantNostr);
			} catch (Exception e) {
				errorMsgs.add("餐廳編號格式不正確");
			}
			
			RestaurantVO vo = svc.getOneRestaurant(restaurantNo);
			System.out.println(vo.toString());
			if(errorMsgs.isEmpty()) {
				if (vo == null) {
					errorMsgs.add("查無資料");
				}
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher a = req.getRequestDispatcher("/restaurant/selectRestaurant.jsp");
				a.forward(req, res);
				return;
			}

			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("restaurantVO", vo); 
			RequestDispatcher b = req.getRequestDispatcher("/restaurant/listOneRestaurant.jsp");
			b.forward(req, res);
			return;
		}

// ======================修改資料==========================================================================================

		if ("getOne_For_Update".equals(action)) {
			Integer restaurantNo = Integer.valueOf(req.getParameter("restaurantNo"));
			RestaurantVO vo = svc.getOneRestaurant(restaurantNo);
			req.setAttribute("restaurantVO", vo); 
			req.getRequestDispatcher("/restaurant/updateRestaurant.jsp").forward(req, res);
			return;
		}

		if ("update".equals(action)) { 

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			RestaurantVO vo = new RestaurantVO();

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer restaurantNo = Integer.valueOf(req.getParameter("restaurantNo").trim());
			String restaurantTel = req.getParameter("restaurantTel");
			String restaurantName = req.getParameter("restaurantName");
			String restaurantTaxIDNo = req.getParameter("restaurantTaxIDNo");
			String restaurantAccountInfo = req.getParameter("restaurantAccountInfo");
			String restaurantBusinessHour = req.getParameter("restaurantBusinessHour");
			String restaurantAddr = req.getParameter("restaurantAddr");
			String restaurantAccount = req.getParameter("restaurantAccount");
			String restaurantPassword = req.getParameter("restaurantPassword");
			
			if(restaurantTel == null || restaurantTel.trim().length() == 0) {
				errorMsgs.add("請輸入餐廳電話");
			}else if(!restaurantTel.matches("^\\d{10}$")) {
				errorMsgs.add("餐廳電話格式不正確");
			}

			if (restaurantName == null || restaurantName.trim().length() == 0) {
				errorMsgs.add("請輸入餐廳名稱");
			}

			if(restaurantTaxIDNo != null || restaurantTaxIDNo.trim().length() != 0) {
				if(!restaurantTaxIDNo.matches("^\\d{8}$")) {
					errorMsgs.add("統一編號格式不正確");
				}
			}
			
			if(restaurantAccountInfo != null || restaurantAccountInfo.trim().length() != 0) {
				if(!restaurantTaxIDNo.matches("^\\d*$")) {
					errorMsgs.add("帳戶格式不正確");
				}
			}
			
			if(restaurantBusinessHour == null || restaurantBusinessHour.trim().length() == 0) {
				errorMsgs.add("請輸入營業時間");
			}else if(!restaurantBusinessHour.matches("^[0-2]\\d:[0-5]\\d-[0-2]\\d:[0-5]\\d$")) {
				errorMsgs.add("營業時間格式不正確");
			}
			
			if(restaurantAddr == null || restaurantAddr.trim().length() == 0) {
				errorMsgs.add("請輸入餐廳地址");
			}
			
			if(restaurantAccount == null || restaurantAccount.trim().length() == 0) {
				errorMsgs.add("請輸入餐廳帳號");
			}
			if(restaurantPassword == null || restaurantPassword.trim().length() == 0) {
				errorMsgs.add("請輸入餐廳密碼");
			}
			
			vo.setRestaurantNo(restaurantNo);
			vo.setRestaurantTel(restaurantTel);
			vo.setRestaurantName(restaurantName);
			vo.setRestaurantTaxIDNo(restaurantTaxIDNo);
			vo.setRestaurantAccountInfo(restaurantAccountInfo);
			vo.setRestaurantBusinessHour(restaurantBusinessHour);
			vo.setRestaurantAddr(restaurantAddr);
			vo.setRestaurantAccount(restaurantAccount);
			vo.setRestaurantPassword(restaurantPassword);
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("restaurantVO", vo); // 含有輸入格式錯誤的empVO物件,也存入req
				req.getRequestDispatcher("/restaurant/updateRestaurant.jsp").forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			vo = svc.updateRestaurant(restaurantTel, restaurantName, restaurantTaxIDNo, restaurantAccountInfo, restaurantBusinessHour, restaurantAddr, restaurantAccount, restaurantPassword, restaurantNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("restaurantVO", vo); // 資料庫update成功後,正確的的empVO物件,存入req
			req.getRequestDispatcher("/restaurant/listOneRestaurant.jsp").forward(req, res);
			return;
		}

// ======================設定餐廳狀態===================================================================================

		if ("setStatus".equals(action)) { 

			/*************************** 1.接收請求參數 ***************************************/
			Integer restaurantNo = Integer.valueOf(req.getParameter("restaurantNo"));
			Boolean restaurantStatus = Boolean.valueOf(req.getParameter("restaurantStatus"));
			// 不須錯誤驗證，因為是按鈕送出

			/*************************** 2.開始設定餐廳狀態 ***************************************/
			svc.setStatus(restaurantNo,restaurantStatus);

			/*************************** 3.完成,準備轉交(Send the Success view) ***********/
			req.getRequestDispatcher("/restaurant/listAllRestaurant.jsp").forward(req, res);
		}
	}

}
