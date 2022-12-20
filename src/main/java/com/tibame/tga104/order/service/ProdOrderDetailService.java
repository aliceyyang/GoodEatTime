package com.tibame.tga104.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.ProdOrderDetailDAO_interface;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;

@Service
public class ProdOrderDetailService {
	
	@Autowired
	private ProdOrderDetailDAO_interface dao;
	
	@Transactional
	public ProdOrderDetailVO insertNewOrder(ProdOrderDetailVO newOrder) {
		if (newOrder == null || newOrder.getProdOrderNo() == null 
				|| newOrder.getProdNo() == null || newOrder.getProdQty() == null) {
			return null;
		}
		if (newOrder.getProdOrderNo() < 0 || newOrder.getProdNo() < 0
				|| newOrder.getProdQty() < 1) {
			return null;
		}
		ProdOrderDetailVO temp = dao.select(newOrder.getProdOrderNo(), newOrder.getProdNo());
		if (temp == null) {
			return dao.insert(newOrder);
		}
		return null;
	}
	
	@Transactional
	public ProdOrderDetailVO insertProdOrder(Integer prodOrderNo, Integer prodNo, Integer prodQty, 
			Integer prodCommentRating, String prodCommentContent, byte[] prodCommentPic, 
			java.sql.Timestamp prodCommentTime, java.sql.Timestamp restaurantReplyTime) {
		
		ProdOrderDetailVO insertProdOrderDetail = new ProdOrderDetailVO();
		insertProdOrderDetail.setProdOrderNo(prodOrderNo);
		insertProdOrderDetail.setProdNo(prodNo);
		insertProdOrderDetail.setProdQty(prodQty);
//		insertProdOrderDetail.setProdPrice(prodPrice);
		insertProdOrderDetail.setProdCommentRating(prodCommentRating);
		insertProdOrderDetail.setProdCommentContent(prodCommentContent);
		insertProdOrderDetail.setProdCommentPic(prodCommentPic);
		insertProdOrderDetail.setProdCommentTime(prodCommentTime);
		insertProdOrderDetail.setRestaurantReplyTime(restaurantReplyTime);
		dao.insert(insertProdOrderDetail);

		return insertProdOrderDetail;	
	}
	
	@Transactional
	public boolean deleteProdOrderDetail(Integer prodOrderNo, Integer prodQty) {
		if(prodOrderNo == null || prodQty == null || prodOrderNo < 0 || prodQty < 0) {
			return false;
		}
		return dao.delete(prodOrderNo, prodQty);
	}
	
	@Transactional
	public ProdOrderDetailVO update(ProdOrderDetailVO update) {
		if (update == null || update.getProdOrderNo() == null 
				|| update.getProdNo() == null || update.getProdQty() == null) {
			return null;
		}
		if (update.getProdOrderNo() < 0 || update.getProdNo() < 0
				|| update.getProdQty() < 1) {
			return null;
		}
		ProdOrderDetailVO temp = dao.select(update.getProdOrderNo(), update.getProdNo());
		if (temp != null) {
			return dao.update(update);
		}
		return null;
	}
	
	@Transactional
	public ProdOrderDetailVO updateProdOrder(Integer prodOrderNo, Integer prodNo, Integer prodQty, 
			Integer prodCommentRating, String prodCommentContent, byte[] prodCommentPic, 
			java.sql.Timestamp prodCommentTime, java.sql.Timestamp restaurantReplyTime) {
		
		ProdOrderDetailVO updateProdOrderDetail = new ProdOrderDetailVO();
		updateProdOrderDetail.setProdOrderNo(prodOrderNo);
		updateProdOrderDetail.setProdNo(prodNo);
		updateProdOrderDetail.setProdQty(prodQty);
//		updateProdOrderDetail.setProdPrice(prodPrice);
		updateProdOrderDetail.setProdCommentRating(prodCommentRating);
		updateProdOrderDetail.setProdCommentContent(prodCommentContent);
		updateProdOrderDetail.setProdCommentPic(prodCommentPic);
		updateProdOrderDetail.setProdCommentTime(prodCommentTime);
		updateProdOrderDetail.setRestaurantReplyTime(restaurantReplyTime);
		dao.insert(updateProdOrderDetail);

		return updateProdOrderDetail;
	}
	
	public ProdOrderDetailVO select(Integer prodOrderNo, Integer prodQty) {
		if(prodOrderNo == null || prodQty == null || prodOrderNo < 0 || prodQty < 0) {
			return null;
		}
		return dao.select(prodOrderNo, prodQty);
	}
	
	public List<ProdOrderDetailVO> select(Integer prodOrderNo) {
		if(prodOrderNo == null || prodOrderNo < 0) {
			return null;
		}
		return dao.select(prodOrderNo);
	}
	
	public List<ProdOrderDetailVO> getAll() {
		return dao.getAll();
	}

}
