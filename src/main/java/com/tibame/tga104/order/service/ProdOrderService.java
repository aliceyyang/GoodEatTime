package com.tibame.tga104.order.service;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.ProdOrderDAO_interface;
import com.tibame.tga104.order.dao.ProdOrderDetailDAO_interface;
import com.tibame.tga104.order.vo.ProdOrderDetailVO;
import com.tibame.tga104.order.vo.ProdOrderVO;
import com.tibame.tga104.product.dao.ProdInfoDAO;
import com.tibame.tga104.product.helper.OrderInsertWrapper;
import com.tibame.tga104.product.vo.ProdInfoVO;

@Service
public class ProdOrderService {
	
	@Autowired
	private ProdOrderDAO_interface dao;
	@Autowired
	private ProdOrderDetailDAO_interface prodOrderDetailDAO;
	@Autowired
	private ProdInfoDAO prodInfoDAO;
	
	@Transactional
	public OrderInsertWrapper insert(OrderInsertWrapper order) {
		if (order == null || order.getProdOrderVO() == null || order.getOrderDetailList() == null) {
			return null;
		}
		ProdOrderVO newOrder = order.getProdOrderVO();
		if (newOrder == null || newOrder.getMemberNo() == null || newOrder.getRestaurantNo() == null
				|| newOrder.getProdOrderReceiverAddress() == null || newOrder.getAmountAfterCoupon() == null
				|| newOrder.getAmountBeforeCoupon() == null || newOrder.getProdOrderPoint() == null
				|| newOrder.getProdOrderReceiverName() == null || newOrder.getProdOrderReceiverTel() == null
				|| newOrder.getProdOrderReceiverMail() == null || newOrder.getDeliverFee() == null) {
			return null;
		}
		if (newOrder.getMemberNo() < 0 || newOrder.getRestaurantNo() < 0
				|| newOrder.getProdOrderReceiverAddress().length() == 0
				|| newOrder.getAmountAfterCoupon() < 0
				|| newOrder.getAmountBeforeCoupon() < 0
				|| newOrder.getProdOrderPoint() < 0
				|| newOrder.getProdOrderReceiverName().length() == 0
				|| newOrder.getProdOrderReceiverTel().length() == 0
				|| newOrder.getProdOrderReceiverMail().length() == 0
				|| newOrder.getDeliverFee() < 0) {
			return null;
		}
		List<ProdOrderDetailVO> newOrderDetail = order.getOrderDetailList();
		for (ProdOrderDetailVO vo : newOrderDetail) {
			if (vo.getProdNo() == null || vo.getProdQty() == null
					|| vo.getProdNo() < 0 || vo.getProdQty() < 0) {
				return null;
			}
		}
		// 隨機產生發票編號
		StringBuilder inv = new StringBuilder();
		inv.append((char)(Math.random()*26 + 65)).append((char)(Math.random()*26 + 65)).append("-");
		for (int i = 0; i< 8; i++) {
			inv.append((int)(Math.random()*10));
		}
		newOrder.setInvoiceNumber(inv.toString());
		// 訂單建立時間
		newOrder.setProdOrderDate(new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));
		
		dao.insert(newOrder);
		if (newOrder.getProdOrderNo() == null) {
			return null;
		}
		OrderInsertWrapper result = new OrderInsertWrapper();
		newOrder.setOrderStatus("訂單成立");
		result.setProdOrderVO(newOrder);
		List<ProdOrderDetailVO> resultDetail = new LinkedList<>();
		for (ProdOrderDetailVO vo : newOrderDetail) {
			vo.setProdOrderNo(newOrder.getProdOrderNo());
			if (prodOrderDetailDAO.insert(vo) == null) {
				return null;
			}
			// 確認新增後去修改庫存數量
			ProdInfoVO prodInfoVO = prodInfoDAO.findByPrimaryKey(vo.getProdNo());
			prodInfoVO.setProdStock(prodInfoVO.getProdStock()-vo.getProdQty());
			prodInfoDAO.update(prodInfoVO);
			resultDetail.add(vo);
		}
		result.setOrderDetailList(resultDetail);
		return result;
	}
	
	@Transactional
	public ProdOrderVO insertProdOrder(Integer memberNo, Integer restaurantNo, Integer couponNo, String orderStatus, 
			java.sql.Timestamp prodOrderDate, java.sql.Timestamp prodOrderReveiveTime, java.sql.Timestamp prodOderDeliverTime, 
			Integer deliverFee, Integer amountBeforeCoupon, Integer amountAfterCoupon, Integer prodOrderPoint, 
			String prodOrderReceiverName, String prodOrderReceiverTel, String prodOrderReceiverMail, String prodOrderReceiverAddress,
			String invoiceNumber, String taxIDNumber) {
		
		ProdOrderVO insertProdOrder = new ProdOrderVO();
		insertProdOrder.setMemberNo(memberNo);
		insertProdOrder.setRestaurantNo(restaurantNo);
		insertProdOrder.setCouponNo(couponNo);
		insertProdOrder.setOrderStatus(orderStatus);
		insertProdOrder.setProdOrderDate(prodOrderDate);
		insertProdOrder.setProdOrderReveiveTime(prodOrderReveiveTime);
		insertProdOrder.setProdOderDeliverTime(prodOderDeliverTime);
		insertProdOrder.setDeliverFee(deliverFee);
		insertProdOrder.setAmountBeforeCoupon(amountBeforeCoupon);
		insertProdOrder.setAmountAfterCoupon(amountAfterCoupon);
		insertProdOrder.setProdOrderPoint(prodOrderPoint);
		insertProdOrder.setProdOrderReceiverName(prodOrderReceiverName);
		insertProdOrder.setProdOrderReceiverTel(prodOrderReceiverTel);
		insertProdOrder.setProdOrderReceiverMail(prodOrderReceiverMail);
		insertProdOrder.setProdOrderReceiverAddress(prodOrderReceiverAddress);
		insertProdOrder.setInvoiceNumber(invoiceNumber);
		insertProdOrder.setTaxIDNumber(taxIDNumber);
		dao.insert(insertProdOrder);

		return insertProdOrder;		
		
	}

	@Transactional
	public void deleteProdOrder(Integer prodOrderNo) {
		dao.delete(prodOrderNo);
	}
	
	@Transactional
	public ProdOrderVO update(ProdOrderVO updateOrder) {
		if (updateOrder == null || updateOrder.getMemberNo() == null || updateOrder.getRestaurantNo() == null
				|| updateOrder.getProdOrderReceiverAddress() == null || updateOrder.getAmountAfterCoupon() == null
				|| updateOrder.getAmountBeforeCoupon() == null || updateOrder.getProdOrderPoint() == null
				|| updateOrder.getProdOrderReceiverName() == null || updateOrder.getProdOrderReceiverTel() == null
				|| updateOrder.getProdOrderReceiverMail() == null || updateOrder.getDeliverFee() == null
				|| updateOrder.getProdOrderNo() == null) {
			return null;
		}
		if (updateOrder.getMemberNo() < 0 || updateOrder.getRestaurantNo() < 0
				|| updateOrder.getProdOrderReceiverAddress().length() == 0
				|| updateOrder.getAmountAfterCoupon() < 0
				|| updateOrder.getAmountBeforeCoupon() < 0
				|| updateOrder.getProdOrderPoint() < 0
				|| updateOrder.getProdOrderReceiverName().length() == 0
				|| updateOrder.getProdOrderReceiverTel().length() == 0
				|| updateOrder.getProdOrderReceiverMail().length() == 0
				|| updateOrder.getDeliverFee() < 0
				|| updateOrder.getProdOrderNo() < 0) {
			return null;
		}
		dao.update(updateOrder);
		return updateOrder;
	}
	
	@Transactional
	public ProdOrderVO updateProdOrder(Integer prodOrderNo, Integer	memberNo, Integer restaurantNo, Integer couponNo, String orderStatus, 
			java.sql.Timestamp prodOrderDate, java.sql.Timestamp prodOrderReveiveTime, java.sql.Timestamp prodOderDeliverTime, 
			Integer deliverFee, Integer amountBeforeCoupon, Integer amountAfterCoupon, Integer prodOrderPoint, 
			String prodOrderReceiverName, String prodOrderReceiverTel, String prodOrderReceiverMail, String prodOrderReceiverAddress,
			String invoiceNumber, String taxIDNumber) {
		
		ProdOrderVO updateProdOrder = new ProdOrderVO();
		updateProdOrder.setProdOrderNo(prodOrderNo);
		updateProdOrder.setMemberNo(memberNo);
		updateProdOrder.setRestaurantNo(restaurantNo);
		updateProdOrder.setCouponNo(couponNo);
		updateProdOrder.setOrderStatus(orderStatus);
		updateProdOrder.setProdOrderDate(prodOrderDate);
		updateProdOrder.setProdOrderReveiveTime(prodOrderReveiveTime);
		updateProdOrder.setProdOderDeliverTime(prodOderDeliverTime);
		updateProdOrder.setDeliverFee(deliverFee);
		updateProdOrder.setAmountBeforeCoupon(amountBeforeCoupon);
		updateProdOrder.setAmountAfterCoupon(amountAfterCoupon);
		updateProdOrder.setProdOrderPoint(prodOrderPoint);
		updateProdOrder.setProdOrderReceiverName(prodOrderReceiverName);
		updateProdOrder.setProdOrderReceiverTel(prodOrderReceiverTel);
		updateProdOrder.setProdOrderReceiverMail(prodOrderReceiverMail);
		updateProdOrder.setProdOrderReceiverAddress(prodOrderReceiverAddress);
		updateProdOrder.setInvoiceNumber(invoiceNumber);
		updateProdOrder.setTaxIDNumber(taxIDNumber);
		dao.update(updateProdOrder);

		return updateProdOrder;		
		
	}

	public ProdOrderVO select(Integer prodOrderNo) {
		return dao.select(prodOrderNo);
	}

	public List<ProdOrderVO> getAll(){
		return dao.getAll();
	}

	public List<ProdOrderVO> findByConditions(ProdOrderVO prodOrderVO) {
		if (prodOrderVO == null) {
			return dao.getAll();
		} else {
			final Integer prodOrderNo = prodOrderVO.getProdOrderNo();
			if (prodOrderNo != null) {
				return Arrays.asList(dao.select(prodOrderNo));
			} else {
				return dao.selectByConditions(prodOrderVO);
			}
		}
	}
}
