package com.tibame.tga104.order.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="prodOrder")
public class ProdOrderVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name="prodOrderNo")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer prodOrderNo;
		@Column(name="memberNo")
		@NotNull
		private Integer	memberNo;
		@Column(name="restaurantNo")
		@NotNull
		private Integer	restaurantNo;
		@Column(name="couponNo")
		private Integer couponNo;
		@Column(name="orderStatus")
		private String orderStatus;
		@Column(name="prodOrderDate")
		@NotNull
		private java.sql.Timestamp prodOrderDate;
		@Column(name="prodOrderReveiveTime")
		private java.sql.Timestamp prodOrderReveiveTime;
		@Column(name="prodOderDeliverTime")
		private java.sql.Timestamp prodOderDeliverTime;
		@Column(name="deliverFee")
		@NotNull
		private Integer deliverFee;
		@Column(name="amountBeforeCoupon")
		@NotNull
		private Integer amountBeforeCoupon;
		@Column(name="amountAfterCoupon")
		@NotNull
		private Integer amountAfterCoupon;
		@Column(name="prodOrderPoint")
		@NotNull
		private Integer prodOrderPoint;
		@Column(name="prodOrderReceiverName")
		@NotNull
		private String prodOrderReceiverName;
		@Column(name="prodOrderReceiverTel")
		@NotNull
		private String prodOrderReceiverTel;
		@Column(name="prodOrderReceiverMail")
		@NotNull
		private String prodOrderReceiverMail;
		@Column(name="prodOrderReceiverAddress")
		@NotNull
		private String prodOrderReceiverAddress;
		@Column(name="invoiceNumber")
		@NotNull
		private String invoiceNumber;
		@Column(name="taxIDNumber")
		private String taxIDNumber;
		
//		// 改建構子寫法再開。
//		public ProdOrderVO() {
//			
//		}
//		
//		public ProdOrderVO(Integer prodOrderNo, Integer	memberNo, Integer restaurantNo, Integer couponNo, String orderStatus, 
//				java.sql.Timestamp prodOrderDate, java.sql.Timestamp prodOrderReveiveTime, java.sql.Timestamp prodOderDeliverTime, 
//				Integer deliverFee, Integer amountBeforeCoupon, Integer amountAfterCoupon, Integer prodOrderPoint, 
//				String prodOrderReceiverName, String prodOrderReceiverTel, String prodOrderReceiverMail, String prodOrderReceiverAddress,
//				String invoiceNumber, String taxIDNumber) {
//			
//			this.prodOrderNo = prodOrderNo;
//			this.memberNo = memberNo;
//			this.restaurantNo = restaurantNo;
//			this.couponNo = couponNo;
//			this.orderStatus = orderStatus;
//			this.prodOrderDate = prodOrderDate;
//			this.prodOrderReveiveTime = prodOrderReveiveTime;
//			this.prodOderDeliverTime = prodOderDeliverTime;
//			this.deliverFee = deliverFee;
//			this.amountBeforeCoupon = amountBeforeCoupon;
//			this.amountAfterCoupon = amountAfterCoupon;
//			this.prodOrderPoint = prodOrderPoint;
//			this.prodOrderReceiverName = prodOrderReceiverName;
//			this.prodOrderReceiverTel = prodOrderReceiverTel;
//			this.prodOrderReceiverMail = prodOrderReceiverMail;
//			this.prodOrderReceiverAddress = prodOrderReceiverAddress;
//			this.invoiceNumber = invoiceNumber;
//			this.taxIDNumber = taxIDNumber;
//			
//		}
		
		@Override
		public String toString() {
			return "ProdOrderVO [prodOrderNo=" + prodOrderNo + ", memberNo=" + memberNo + ", restaurantNo="
					+ restaurantNo + ", couponNo=" + couponNo + ", orderStatus=" + orderStatus + ", prodOrderDate="
					+ prodOrderDate + ", prodOrderReveiveTime=" + prodOrderReveiveTime + ", prodOderDeliverTime="
					+ prodOderDeliverTime + ", deliverFee=" + deliverFee + ", amountBeforeCoupon=" + amountBeforeCoupon
					+ ", amountAfterCoupon=" + amountAfterCoupon + ", prodOrderPoint=" + prodOrderPoint
					+ ", prodOrderReceiverName=" + prodOrderReceiverName + ", prodOrderReceiverTel="
					+ prodOrderReceiverTel + ", prodOrderReceiverMail=" + prodOrderReceiverMail
					+ ", prodOrderReceiverAddress=" + prodOrderReceiverAddress + ", invoiceNumber=" + invoiceNumber
					+ ", taxIDNumber=" + taxIDNumber + "]";
		}
		
		public Integer getProdOrderNo() {
			return prodOrderNo;
		}
		public void setProdOrderNo(Integer prodOrderNo) {
			this.prodOrderNo = prodOrderNo;
		}
		public Integer getMemberNo() {
			return memberNo;
		}
		public void setMemberNo(Integer memberNo) {
			this.memberNo = memberNo;
		}
		public Integer getRestaurantNo() {
			return restaurantNo;
		}
		public void setRestaurantNo(Integer restaurantNo) {
			this.restaurantNo = restaurantNo;
		}
		public Integer getCouponNo() {
			return couponNo;
		}
		public void setCouponNo(Integer couponNo) {
			this.couponNo = couponNo;
		}
		public String getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}
		public Timestamp getProdOrderDate() {
			return prodOrderDate;
		}
		public void setProdOrderDate(Timestamp prodOrderDate) {
			this.prodOrderDate = prodOrderDate;
		}
		public Timestamp getProdOrderReveiveTime() {
			return prodOrderReveiveTime;
		}
		public void setProdOrderReveiveTime(Timestamp prodOrderReveiveTime) {
			this.prodOrderReveiveTime = prodOrderReveiveTime;
		}
		public Timestamp getProdOderDeliverTime() {
			return prodOderDeliverTime;
		}
		public void setProdOderDeliverTime(Timestamp prodOderDeliverTime) {
			this.prodOderDeliverTime = prodOderDeliverTime;
		}
		public Integer getDeliverFee() {
			return deliverFee;
		}
		public void setDeliverFee(Integer deliverFee) {
			this.deliverFee = deliverFee;
		}
		public Integer getAmountBeforeCoupon() {
			return amountBeforeCoupon;
		}
		public void setAmountBeforeCoupon(Integer amountBeforeCoupon) {
			this.amountBeforeCoupon = amountBeforeCoupon;
		}
		public Integer getAmountAfterCoupon() {
			return amountAfterCoupon;
		}
		public void setAmountAfterCoupon(Integer amountAfterCoupon) {
			this.amountAfterCoupon = amountAfterCoupon;
		}
		public Integer getProdOrderPoint() {
			return prodOrderPoint;
		}
		public void setProdOrderPoint(Integer prodOrderPoint) {
			this.prodOrderPoint = prodOrderPoint;
		}
		public String getProdOrderReceiverName() {
			return prodOrderReceiverName;
		}
		public void setProdOrderReceiverName(String prodOrderReceiverName) {
			this.prodOrderReceiverName = prodOrderReceiverName;
		}
		public String getProdOrderReceiverTel() {
			return prodOrderReceiverTel;
		}
		public void setProdOrderReceiverTel(String prodOrderReceiverTel) {
			this.prodOrderReceiverTel = prodOrderReceiverTel;
		}
		public String getProdOrderReceiverMail() {
			return prodOrderReceiverMail;
		}
		public void setProdOrderReceiverMail(String prodOrderReceiverMail) {
			this.prodOrderReceiverMail = prodOrderReceiverMail;
		}
		public String getProdOrderReceiverAddress() {
			return prodOrderReceiverAddress;
		}
		public void setProdOrderReceiverAddress(String prodOrderReceiverAddress) {
			this.prodOrderReceiverAddress = prodOrderReceiverAddress;
		}
		public String getInvoiceNumber() {
			return invoiceNumber;
		}
		public void setInvoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}
		public String getTaxIDNumber() {
			return taxIDNumber;
		}
		public void setTaxIDNumber(String taxIDNumber) {
			this.taxIDNumber = taxIDNumber;
		}

		
}
