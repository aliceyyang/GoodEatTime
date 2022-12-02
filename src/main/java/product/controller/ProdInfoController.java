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
import javax.servlet.http.HttpSession;

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
    	// 先寫死確認是否正常運作，forward是否成功，jsp是否有問題
//		ProdInfoService prodSvc = new ProdInfoService();
//    	ProdInfoVO prodInfoVO = prodSvc.getOneProduct(3);
//    	req.setAttribute("prodInfoVO", prodInfoVO);
//    	String url = "/product/listOneProd.jsp";
//		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneProd.jsp
//		successView.forward(req, res);
    	
    	String failureView = "/product/selectProduct.jsp";
    	String updateView = "/product/updateProduct.jsp";
    	String listOneView = "/product/listOneProd.jsp";
    	String listAllView = "/product/listAllProd.jsp";
    	req.setCharacterEncoding("UTF-8");
    	String action = req.getParameter("action");
    	ProdInfoService prodSvc = new ProdInfoService();
    	HttpSession session = req.getSession();
    	
    	if ("getAll".equals(action)) {
    		List<ProdInfoVO> list = prodSvc.getAll();
    		session.setAttribute("list", list);
    		requestDispatch(req, res, listAllView);
    		return;
    	}
    	
    	if ("getOne_For_Display".equals(action)) {
    		Object[] result = getOne_For_Display(req.getParameter("prodNo"));
    		if (result[0] != null) {
    			req.setAttribute("errorMsgs", (List<String>)result[0]);
    			requestDispatch(req, res, failureView);
    			return;
    		}
    		req.setAttribute("prodInfoVO", (ProdInfoVO)result[1]);
    		requestDispatch(req, res, listOneView);
			return;
    	}
    	
    	if ("getOne_For_Update".equals(action)) {
    		Integer prodNo = Integer.valueOf(req.getParameter("prodNo"));
    		ProdInfoVO prodInfoVO = prodSvc.getOneProduct(prodNo);
        	req.setAttribute("prodInfoVO", prodInfoVO);
        	requestDispatch(req, res, updateView);
        	return;
    	}
    	
    	if ("get_FromProdCategory".equals(action)) {
    		Integer prodCategoryNo = Integer.valueOf(req.getParameter("prodCategoryNo"));
    		List<ProdInfoVO> list = prodSvc.getByCategory(prodCategoryNo);
    		session.setAttribute("list", list);
    		requestDispatch(req, res, listAllView);
    		return;
    	}
    	
    	if ("update".equals(action)) {
    		Object[] result = update_prod(req.getParameter("prodNo"),
    				req.getParameter("restaurantNo"), req.getParameter("prodCategoryNo"),
    				req.getParameter("prodName"), req.getParameter("prodPrice"), 
    				req.getParameter("prodStock"), req.getParameter("prodDescription"),
    				req.getParameter("prodContent"), req.getParameter("prodCommentQty"),
    				req.getParameter("totalCommentRating"));
    		if (result[0] != null) {
    			req.setAttribute("errorMsgs", (List<String>)result[0]);
    			req.setAttribute("prodInfoVO", (ProdInfoVO)result[1]);
    			requestDispatch(req, res, updateView);
    			return;
    		}
    		req.setAttribute("prodInfoVO", (ProdInfoVO)result[1]);
    		requestDispatch(req, res, listOneView);
			return;
    	}
    	
    	if ("delete".equals(action)) {
    		Integer prodNo = Integer.valueOf(req.getParameter("prodNO"));
    		prodSvc.deleteProdInfo(prodNo);
    		requestDispatch(req, res, listAllView);
    		return;
    	}
    	if ("addProduct".equals(action)) {
    		Object[] result = add_prod(
    				req.getParameter("restaurantNo"), req.getParameter("prodCategoryNo"),
    				req.getParameter("prodName"), req.getParameter("prodPrice"), 
    				req.getParameter("prodStock"), req.getParameter("prodDescription"),
    				req.getParameter("prodContent"), req.getParameter("prodCommentQty"),
    				req.getParameter("totalCommentRating"));
    		if (result[0] != null) {
    			req.setAttribute("errorMsgs", (List<String>)result[0]);
    			req.setAttribute("prodInfoVO", (ProdInfoVO)result[1]);
    			requestDispatch(req, res, "/product/addProduct.jsp");
    			return;
    		}
    		req.setAttribute("prodInfoVO", (ProdInfoVO)result[1]);
    		requestDispatch(req, res, listOneView);
			return;
    	}
	}
    
    void requestDispatch(HttpServletRequest req, HttpServletResponse res, String url)
    		throws ServletException, IOException {
    	RequestDispatcher destination = req.getRequestDispatcher(url); 
    	destination.forward(req, res);
    }
    
    Object[] getOne_For_Display(String prodNoStr) {
    	Object[] result = new Object[2];
    	// result[0] = 錯誤訊息
    	// result[1] = 查詢結果
    	
    	List<String> errorMsgs = new LinkedList<String>();
    	
    	/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		
		if (prodNoStr == null || (prodNoStr.trim()).length() == 0) {
			errorMsgs.add("請輸入產品編號");
			result[0] = errorMsgs;
			return result;//程式中斷
		}
		
		Integer prodNo = null;
		try {
			prodNo = Integer.valueOf(prodNoStr.trim());
		} catch (Exception e) {
			errorMsgs.add("產品編號格式不正確");
			result[0] = errorMsgs;
			return result;//程式中斷
		}
		
		/***************************2.開始查詢資料*****************************************/
		ProdInfoService prodSvc = new ProdInfoService();
    	ProdInfoVO prodInfoVO = prodSvc.getOneProduct(prodNo);
		if (prodInfoVO == null) {
			errorMsgs.add("查無資料");
			result[0] = errorMsgs;
			return result;//程式中斷
		}
    	
		/***************************3.查詢完成,回傳資料*************************************/
		result[1] = prodInfoVO;
		return result;
    }
    
    Object[] update_prod(String prodNoStr, String restaurantNoStr, String prodCategoryNoStr,
    		String prodName, String prodPriceStr, String prodStockStr, String prodDescription,
    		String prodContent, String prodCommentQtyStr, String totalCommentRatingStr) {
    	Object[] result = new Object[2];
    	// result[0] = 錯誤訊息
    	// result[1] = 使用這輸入的錯誤資料 / 修改結果
    	
    	List<String> errorMsgs = new LinkedList<String>();
    	
    	/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		
    	// prodNo, restaurantNo, prodCommentQty, totalCommentRating 未讓使用者修改，故不驗證
    	Integer prodNo = Integer.valueOf(prodNoStr);
    	Integer restaurantNo = Integer.valueOf(restaurantNoStr);
    	Integer prodCommentQty = Integer.valueOf(prodCommentQtyStr);
    	Integer totalCommentRating = Integer.valueOf(totalCommentRatingStr);
    	// prodCategoryNo讓使用者選擇，故也不需驗證
    	Integer prodCategoryNo = Integer.valueOf(prodCategoryNoStr);
    	
    	// 確認產品名稱
		if (prodName == null || (prodName.trim()).length() == 0) {
			errorMsgs.add("請輸入產品名稱");
		}
		
		// 確認產品價格
		if (prodPriceStr == null || (prodPriceStr.trim()).length() == 0) {
			errorMsgs.add("請輸入產品價格");
		}
		
		Integer prodPrice = null;
		try {
			prodPrice = Integer.valueOf(prodPriceStr.trim());
		} catch (Exception e) {
			prodPrice = 1;
			errorMsgs.add("產品價格格式不正確");
		}
		
		if(prodPrice <= 0) {
			prodPrice = 1;
			errorMsgs.add("產品價格不能小於或等於0");
		}
		
		// 確認產品庫存
		if (prodStockStr == null || (prodStockStr.trim()).length() == 0) {
			errorMsgs.add("請輸入產品庫存");
		}
		
		Integer prodStock = null;
		try {
			prodStock = Integer.valueOf(prodStockStr.trim());
		} catch (Exception e) {
			prodStock = 0;
			errorMsgs.add("產品庫存格式不正確");
		}
		
		if(prodStock < 0) {
			prodStock = 0;
			errorMsgs.add("產品庫存不能小於0");
		}
		
		//確認產品說明
		if (prodDescription == null || (prodDescription.trim()).length() == 0) {
			errorMsgs.add("請輸入產品說明");
		}
		
		//確認產品規格
		if (prodContent == null || (prodContent.trim()).length() == 0) {
			errorMsgs.add("請輸入產品規格");
		}
		
		if (!errorMsgs.isEmpty()) {
			result[0] = errorMsgs;
			ProdInfoVO wrongProdInfoVO = new ProdInfoVO();
			wrongProdInfoVO.setProdNo(prodNo);
			wrongProdInfoVO.setRestaurantNo(restaurantNo);
			wrongProdInfoVO.setProdCategoryNo(prodCategoryNo);
			wrongProdInfoVO.setProdName(prodName);
			wrongProdInfoVO.setProdPrice(prodPrice);
			wrongProdInfoVO.setProdStock(prodStock);
			wrongProdInfoVO.setProdDescription(prodDescription);
			wrongProdInfoVO.setProdContent(prodContent);
			wrongProdInfoVO.setProdCommentQty(prodCommentQty);
			wrongProdInfoVO.setTotalCommentRating(totalCommentRating);
			result[1] = wrongProdInfoVO;
			return result;//程式中斷
		}
		
		/***************************2.開始修改資料*****************************************/
		ProdInfoService prodSvc = new ProdInfoService();
    	ProdInfoVO prodInfoVO = prodSvc.updateProdInfo(prodNo, restaurantNo, prodCategoryNo,
    			prodName, prodPrice, prodStock, prodDescription,
        		prodContent, prodCommentQty, totalCommentRating);
		
		/***************************3.修改完成,回傳資料*************************************/
		result[1] = prodInfoVO;
		return result;
    }
    
    Object[] add_prod(String restaurantNoStr, String prodCategoryNoStr,
    		String prodName, String prodPriceStr, String prodStockStr, String prodDescription,
    		String prodContent, String prodCommentQtyStr, String totalCommentRatingStr) {
    	Object[] result = new Object[2];
    	// result[0] = 錯誤訊息
    	// result[1] = 使用這輸入的錯誤資料 / 修改結果
    	
    	List<String> errorMsgs = new LinkedList<String>();
    	
    	/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		
    	// 確認餐廳編號
    	if (restaurantNoStr == null || (restaurantNoStr.trim()).length() == 0) {
			errorMsgs.add("請輸入餐廳編號");
		}
    	
    	Integer restaurantNo = null;
    	try {
    		restaurantNo = Integer.valueOf(restaurantNoStr);
		} catch (Exception e) {
			restaurantNo = 1;
			errorMsgs.add("餐廳編號格式不正確");
		}
    	if (restaurantNo < 0) {
    		restaurantNo = 1;
			errorMsgs.add("餐廳編號不能小於或等於0");
    	}
    	
    	// prodCategoryNo讓使用者選擇，故也不需驗證
    	Integer prodCategoryNo = Integer.valueOf(prodCategoryNoStr);
    	
    	// 確認產品名稱
		if (prodName == null || (prodName.trim()).length() == 0) {
			errorMsgs.add("請輸入產品名稱");
		}
		
		// 確認產品價格
		if (prodPriceStr == null || (prodPriceStr.trim()).length() == 0) {
			errorMsgs.add("請輸入產品價格");
		}
		
		Integer prodPrice = null;
		try {
			prodPrice = Integer.valueOf(prodPriceStr.trim());
		} catch (Exception e) {
			prodPrice = 1;
			errorMsgs.add("產品價格格式不正確");
		}
		
		if(prodPrice <= 0) {
			prodPrice = 1;
			errorMsgs.add("產品價格不能小於或等於0");
		}
		
		// 確認產品庫存
		if (prodStockStr == null || (prodStockStr.trim()).length() == 0) {
			errorMsgs.add("請輸入產品庫存");
		}
		
		Integer prodStock = null;
		try {
			prodStock = Integer.valueOf(prodStockStr.trim());
		} catch (Exception e) {
			prodStock = 0;
			errorMsgs.add("產品庫存格式不正確");
		}
		
		if(prodStock < 0) {
			prodStock = 0;
			errorMsgs.add("產品庫存不能小於0");
		}
		
		//確認產品說明
		if (prodDescription == null || (prodDescription.trim()).length() == 0) {
			errorMsgs.add("請輸入產品說明");
		}
		
		//確認產品規格
		if (prodContent == null || (prodContent.trim()).length() == 0) {
			errorMsgs.add("請輸入產品規格");
		}
		
		if (!errorMsgs.isEmpty()) {
			result[0] = errorMsgs;
			ProdInfoVO wrongProdInfoVO = new ProdInfoVO();
			wrongProdInfoVO.setRestaurantNo(restaurantNo);
			wrongProdInfoVO.setProdCategoryNo(prodCategoryNo);
			wrongProdInfoVO.setProdName(prodName);
			wrongProdInfoVO.setProdPrice(prodPrice);
			wrongProdInfoVO.setProdStock(prodStock);
			wrongProdInfoVO.setProdDescription(prodDescription);
			wrongProdInfoVO.setProdContent(prodContent);
			result[1] = wrongProdInfoVO;
			return result;//程式中斷
		}
		
		/***************************2.開始修改資料*****************************************/
		ProdInfoService prodSvc = new ProdInfoService();
    	ProdInfoVO prodInfoVO = prodSvc.addProdInfo(restaurantNo, prodCategoryNo,
    			prodName, prodPrice, prodStock, prodDescription,
        		prodContent);
		
		/***************************3.修改完成,回傳資料*************************************/
		result[1] = prodInfoVO;
		return result;
    }
    
}
