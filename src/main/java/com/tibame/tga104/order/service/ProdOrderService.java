package com.tibame.tga104.order.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga104.order.dao.ProdOrderDAO_interface;
import com.tibame.tga104.order.vo.ProdOrderVO;

@Service
public class ProdOrderService {
	
	@Autowired
	private ProdOrderDAO_interface dao;
	
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
