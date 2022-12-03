package product.helper;

import java.util.LinkedList;
import java.util.List;

import product.service.ProdInfoService;
import product.vo.ProdInfoVO;

public class CheckProdInfo {
	public Object[] checkProdNo(String prodNoStr) {
		Object[] result = new Object[2];
		LinkedList<String> msg = new LinkedList<String>();
		if (prodNoStr == null || prodNoStr.trim().length() == 0) {
			msg.add("請輸入產品編號");
			result[0] = msg;
			return result;
		}
		Integer prodNo = null;
		try {
			prodNo = Integer.valueOf(prodNoStr.trim());
		} catch (Exception e) {
			msg.add("產品編號格式不正確");
			result[0] = msg;
			return result;
		}
		if (prodNo < 1) {
			msg.add("產品編號必須大於0");
			result[0] = msg;
			return result;
		}
		ProdInfoService prodSvc = new ProdInfoService();
    	ProdInfoVO prodInfoVO = prodSvc.getOneProduct(prodNo);
		if (prodInfoVO == null) {
			msg.add("查無資料");
			result[0] = msg;
			return result;
		}
		result[1] = prodInfoVO;
		return result;
	}
	
	public LinkedList<String> checkProdName(String prodName) {
		LinkedList<String> msg = new LinkedList<>();
		if (prodName == null || prodName.trim().length() == 0) {
			msg.add("error");
			msg.add("請輸入產品名稱");
			return msg;
		}
		int length = prodName.trim().length();
		if (length < 2 || length > 30) {
			msg.add("error");
			msg.add("產品名稱需介於2~30個文字之內");
			return msg;
		}
		if (msg.isEmpty()) {
			msg.add("correct");
		}
		return msg;
	}
	
	public LinkedList<String> checkProdPrice(String prodPriceStr) {
		LinkedList<String> msg = new LinkedList<>();
		if (prodPriceStr == null || (prodPriceStr.trim()).length() == 0) {
			msg.add("error");
			msg.add("請輸入產品價格");
			return msg;
		}
		
		Integer prodPrice = null;
		try {
			prodPrice = Integer.valueOf(prodPriceStr.trim());
		} catch (Exception e) {
			msg.add("error");
			msg.add("產品價格格式不正確");
			return msg;
		}
		
		if(prodPrice < 1) {
			msg.add("error");
			msg.add("產品價格不能小於或等於0");
			return msg;
		}
		if (msg.isEmpty()) {
			msg.add("correct");
		}
		return msg;
	}
	
	public LinkedList<String> checkProdStock(String prodStockStr) {
		LinkedList<String> msg = new LinkedList<>();
		if (prodStockStr == null || (prodStockStr.trim()).length() == 0) {
			msg.add("error");
			msg.add("請輸入產品庫存");
			return msg;
		}
		
		Integer prodStock = null;
		try {
			prodStock = Integer.valueOf(prodStockStr.trim());
		} catch (Exception e) {
			msg.add("error");
			msg.add("產品庫存格式不正確");
			return msg;
		}
		
		if(prodStock < 0) {
			msg.add("error");
			msg.add("產品庫存不能小於0");
			return msg;
		}
		if (msg.isEmpty()) {
			msg.add("correct");
		}
		return msg;
	}
	
	public LinkedList<String> checkProdDescription(String prodDescription) {
		LinkedList<String> msg = new LinkedList<>();
		if (prodDescription == null || prodDescription.trim().length() == 0) {
			msg.add("error");
			msg.add("請輸入產品說明");
			return msg;
		}
		int length = prodDescription.trim().length();
		if (length < 2 || length > 200) {
			msg.add("error");
			msg.add("產品說明需介於2~200個文字之內");
			return msg;
		}
		if (msg.isEmpty()) {
			msg.add("correct");
		}
		return msg;
	}
	
	public LinkedList<String> checkProdContent(String prodContent) {
		LinkedList<String> msg = new LinkedList<>();
		if (prodContent == null || prodContent.trim().length() == 0) {
			msg.add("error");
			msg.add("請輸入產品內容");
			return msg;
		}
		int length = prodContent.trim().length();
		if (length < 2 || length > 200) {
			msg.add("error");
			msg.add("產品內容需介於2~200個文字之內");
			return msg;
		}
		if (msg.isEmpty()) {
			msg.add("correct");
		}
		return msg;
	}
}
