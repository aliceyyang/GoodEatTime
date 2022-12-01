package product.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.service.ProdInfoService;
import product.vo.ProdInfoVO;

@WebServlet("/product/ProdInfoController")
public class ProdInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdInfoController() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req,res);
	}
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
    	// 先寫死確認是否正常運作，forward成功，jsp是否有問題
//		ProdInfoService prodSvc = new ProdInfoService();
//    	ProdInfoVO prodInfoVO = prodSvc.getOneProduct(3);
//    	req.setAttribute("prodInfoVO", prodInfoVO);
//    	String url = "/product/listOneProd.jsp";
//		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProd.jsp
//		successView.forward(req, res);
    	
    	String failureView = "/product/selectProduct.jsp";
    	req.setCharacterEncoding("UTF-8");
    	String action = req.getParameter("action");
    	
    	
    	if("getOne_For_Display".equals(action)) {
    		Object[] result = getOne_For_Display(req.getParameter("prodNo"));
    		if (result[0] != null) {
    			req.setAttribute("errorMsgs", (List<String>)result[0]);
    			requestDispatch(req, res, failureView);
    			return;
    		}
    		req.setAttribute("prodInfoVO", (ProdInfoVO)result[1]);
    		String listOneView = "/product/listOneProd.jsp";
    		requestDispatch(req, res, listOneView);
			return;
    	}
    	
	}
    
    Object[] getOne_For_Display(String prodNoStr) {
    	Object[] result = new Object[2];
    	// result[0] = 錯誤訊息
    	// result[1] = 
    	
    	List<String> errorMsgs = new LinkedList<String>();
    	
    	/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		
		if (prodNoStr == null || (prodNoStr.trim()).length() == 0) {
			errorMsgs.add("請輸入產品編號");
		}
		if (!errorMsgs.isEmpty()) {
			result[0] = errorMsgs;
			return result;//程式中斷
		}
		
		Integer prodNo = null;
		try {
			prodNo = Integer.valueOf(prodNoStr.trim());
		} catch (Exception e) {
			errorMsgs.add("產品編號格式不正確");
		}
		if (!errorMsgs.isEmpty()) {
			result[0] = errorMsgs;
			return result;//程式中斷
		}
		
		/***************************2.開始查詢資料*****************************************/
		ProdInfoService prodSvc = new ProdInfoService();
    	ProdInfoVO prodInfoVO = prodSvc.getOneProduct(prodNo);
		if (prodInfoVO == null) {
			errorMsgs.add("查無資料");
		}
		if (!errorMsgs.isEmpty()) {
			result[0] = errorMsgs;
			return result;//程式中斷
		}
    	
		/***************************3.查詢完成,回傳資料*************************************/
		result[1] = prodInfoVO;
		return result;
    }
    
    void requestDispatch(HttpServletRequest req, HttpServletResponse res, String url)
    		throws ServletException, IOException {
    	RequestDispatcher destination = req.getRequestDispatcher(url); 
    	destination.forward(req, res);
    }
}
