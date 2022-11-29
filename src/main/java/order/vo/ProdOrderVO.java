package order.vo;

import java.sql.Timestamp;

public class ProdOrderVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
		private Integer prodOrderNo;
		private Integer	memberNo;
		private Integer	restaurantNo;
		private Integer couponNo;
		private String orderStatus;
		private java.sql.Timestamp prodOrderDate;
		private java.sql.Timestamp prodOrderReveiveTime;
		private java.sql.Timestamp prodOderDeliverTime;
		private Integer deliverFee;
		private Integer amountBeforeCoupon;
		private Integer amountAfterCoupon;
		private Integer prodOrderPoint;
		private String prodOrderReceiverName;
		private String prodOrderReceiverTel;
		private String prodOrderReceiverMail;
		private String prodOrderReceiverAddress;
		private String invoiceNumber;
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
