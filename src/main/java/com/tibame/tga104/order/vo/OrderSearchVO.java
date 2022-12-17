package com.tibame.tga104.order.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="v_OrderSearch")
public class OrderSearchVO implements java.io.Serializable{
	private static final long serialVersionUID = 8676063332323320312L;
	
	@Id
	@Column(name="prodOrderNo")
	private Integer prodOrderNo;
	@Column(name="memberNo")
	private Integer	memberNo;
	@Column(name="restaurantNo")
	private Integer	restaurantNo;
	@Column(name="couponNo")
	private Integer couponNo;
	@Column(name="orderStatus")
	private String orderStatus;
	@Column(name="prodOrderDate")
	private java.sql.Timestamp prodOrderDate;
	@Column(name="prodOrderReveiveTime")
	private java.sql.Timestamp prodOrderReveiveTime;
	@Column(name="prodOderDeliverTime")
	private java.sql.Timestamp prodOderDeliverTime;
	@Column(name="deliverFee")
	private Integer deliverFee;
	@Column(name="amountBeforeCoupon")
	private Integer amountBeforeCoupon;
	@Column(name="amountAfterCoupon")
	private Integer amountAfterCoupon;
	@Column(name="prodOrderPoint")
	private Integer prodOrderPoint;
	@Column(name="prodOrderReceiverName")
	private String prodOrderReceiverName;
	@Column(name="prodOrderReceiverTel")
	private String prodOrderReceiverTel;
	@Column(name="prodOrderReceiverMail")
	private String prodOrderReceiverMail;
	@Column(name="prodOrderReceiverAddress")
	private String prodOrderReceiverAddress;
	@Column(name="invoiceNumber")
	private String invoiceNumber;
	@Column(name="taxIDNumber")
	private String taxIDNumber;
	@Column(name="prodNo")
	private Integer prodNo;
	@Column(name="prodName")
	private String prodName;
	@Column(name="prodQty")
	private Integer prodQty;
	@Column(name="prodPrice")
	private Integer prodPrice;
	@Column(name="name")
	private String name;
	@Column(name="tel")
	private String tel;
	
	
	@Override
	public String toString() {
		return "OrderSearchVO [prodOrderNo=" + prodOrderNo + ", memberNo=" + memberNo + ", restaurantNo=" + restaurantNo
				+ ", couponNo=" + couponNo + ", orderStatus=" + orderStatus + ", prodOrderDate=" + prodOrderDate
				+ ", prodOrderReveiveTime=" + prodOrderReveiveTime + ", prodOderDeliverTime=" + prodOderDeliverTime
				+ ", deliverFee=" + deliverFee + ", amountBeforeCoupon=" + amountBeforeCoupon + ", amountAfterCoupon="
				+ amountAfterCoupon + ", prodOrderPoint=" + prodOrderPoint + ", prodOrderReceiverName="
				+ prodOrderReceiverName + ", prodOrderReceiverTel=" + prodOrderReceiverTel + ", prodOrderReceiverMail="
				+ prodOrderReceiverMail + ", prodOrderReceiverAddress=" + prodOrderReceiverAddress + ", invoiceNumber="
				+ invoiceNumber + ", taxIDNumber=" + taxIDNumber + ", prodNo=" + prodNo + ", prodName=" + prodName
				+ ", prodQty=" + prodQty + ", prodPrice=" + prodPrice + ", name=" + name + ", tel=" + tel + "]";
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


	public java.sql.Timestamp getProdOrderDate() {
		return prodOrderDate;
	}


	public void setProdOrderDate(java.sql.Timestamp prodOrderDate) {
		this.prodOrderDate = prodOrderDate;
	}


	public java.sql.Timestamp getProdOrderReveiveTime() {
		return prodOrderReveiveTime;
	}


	public void setProdOrderReveiveTime(java.sql.Timestamp prodOrderReveiveTime) {
		this.prodOrderReveiveTime = prodOrderReveiveTime;
	}


	public java.sql.Timestamp getProdOderDeliverTime() {
		return prodOderDeliverTime;
	}


	public void setProdOderDeliverTime(java.sql.Timestamp prodOderDeliverTime) {
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


	public Integer getProdNo() {
		return prodNo;
	}


	public void setProdNo(Integer prodNo) {
		this.prodNo = prodNo;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public Integer getProdQty() {
		return prodQty;
	}


	public void setProdQty(Integer prodQty) {
		this.prodQty = prodQty;
	}


	public Integer getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
