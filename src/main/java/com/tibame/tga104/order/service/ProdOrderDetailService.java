package com.tibame.tga104.order.service;

import java.util.List;

import com.tibame.tga104.order.dao.ProdOrderDetailDAO_interface;
import com.tibame.tga104.order.dao.ProdOrderDetailJNDIDAO;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;

public class ProdOrderDetailService {
	
	private ProdOrderDetailDAO_interface dao;

	public ProdOrderDetailService() {
		dao = new ProdOrderDetailJNDIDAO();
	} 

	public ProdOrderDetailVO insertProdOrder(Integer prodOrderNo, Integer prodNo, Integer prodQty, Integer prodPrice, 
			Integer prodCommentRating, String prodCommentContent, byte[] prodCommentPic, 
			java.sql.Timestamp prodCommentTime, java.sql.Timestamp restaurantReplyTime) {
		
		ProdOrderDetailVO insertProdOrderDetail = new ProdOrderDetailVO();
		insertProdOrderDetail.setProdOrderNo(prodOrderNo);
		insertProdOrderDetail.setProdNo(prodNo);
		insertProdOrderDetail.setProdQty(prodQty);
		insertProdOrderDetail.setProdPrice(prodPrice);
		insertProdOrderDetail.setProdCommentRating(prodCommentRating);
		insertProdOrderDetail.setProdCommentContent(prodCommentContent);
		insertProdOrderDetail.setProdCommentPic(prodCommentPic);
		insertProdOrderDetail.setProdCommentTime(prodCommentTime);
		insertProdOrderDetail.setRestaurantReplyTime(restaurantReplyTime);
		dao.insert(insertProdOrderDetail);

		return insertProdOrderDetail;	
	}

	public void deleteProdOrderDetail(Integer prodOrderNo) {
		dao.delete(prodOrderNo);
	}
	
	public ProdOrderDetailVO updateProdOrder(Integer prodOrderNo, Integer prodNo, Integer prodQty, Integer prodPrice, 
			Integer prodCommentRating, String prodCommentContent, byte[] prodCommentPic, 
			java.sql.Timestamp prodCommentTime, java.sql.Timestamp restaurantReplyTime) {
		
		ProdOrderDetailVO updateProdOrderDetail = new ProdOrderDetailVO();
		updateProdOrderDetail.setProdOrderNo(prodOrderNo);
		updateProdOrderDetail.setProdNo(prodNo);
		updateProdOrderDetail.setProdQty(prodQty);
		updateProdOrderDetail.setProdPrice(prodPrice);
		updateProdOrderDetail.setProdCommentRating(prodCommentRating);
		updateProdOrderDetail.setProdCommentContent(prodCommentContent);
		updateProdOrderDetail.setProdCommentPic(prodCommentPic);
		updateProdOrderDetail.setProdCommentTime(prodCommentTime);
		updateProdOrderDetail.setRestaurantReplyTime(restaurantReplyTime);
		dao.insert(updateProdOrderDetail);

		return updateProdOrderDetail;
	}
	
	public ProdOrderDetailVO select(Integer prodOrderNo) {
		return dao.select(prodOrderNo);
	}
	
	public List<ProdOrderDetailVO> getAll() {
		return dao.getAll();
	}

}
