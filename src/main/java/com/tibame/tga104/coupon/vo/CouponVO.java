package com.tibame.tga104.coupon.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

public class CouponVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer couponNo;
	private Integer restaurantNo;
	private Integer adminNo;
	private java.sql.Timestamp couponApplyDate;
	private String couponName;
	private java.sql.Date couponStartTime;
	private java.sql.Date couponEndTime;
	private Boolean verified;
	private String couponContent;
	private Integer usageLimitation;
	private Double amountOrFold;
	private Boolean couponType;
	private Integer maxIssueQty;
	private Integer issuedQty;
	private String verificationDetail;
	private byte[] couponPic;
	private String couponPicStr;
	private String couponTypeStr;

	public CouponVO() {
	}

	public CouponVO(Integer couponNo, Integer restaurantNo, Integer adminNo, Timestamp couponApplyDate,
			String couponName, Date couponStartTime, Date couponEndTime, Boolean verified,
			String couponContent, Integer usageLimitation, Double amountOrFold, Boolean couponType, Integer maxIssueQty,
			Integer issuedQty, String verificationDetail,byte[] couponPic) {
		super();
		this.couponNo = couponNo;
		this.restaurantNo = restaurantNo;
		this.adminNo = adminNo;
		this.couponApplyDate = couponApplyDate;
		this.couponName = couponName;
		this.couponStartTime = couponStartTime;
		this.couponEndTime = couponEndTime;
		this.verified = verified;
		this.couponContent = couponContent;
		this.usageLimitation = usageLimitation;
		this.amountOrFold = amountOrFold;
		this.couponType = couponType;
		this.maxIssueQty = maxIssueQty;
		this.issuedQty = issuedQty;
		this.verificationDetail = verificationDetail;
		this.couponPic = couponPic;
	}



	@Override
	public String toString() {
		return "CouponVO [couponNo=" + couponNo + ", restaurantNo=" + restaurantNo + ", adminNo=" + adminNo
				+ ", couponApplyDate=" + couponApplyDate + ", couponName=" + couponName + ", couponStartTime="
				+ couponStartTime + ", couponEndTime=" + couponEndTime + ", verified=" + verified + ", couponContent="
				+ couponContent + ", usageLimitation=" + usageLimitation + ", amountOrFold=" + amountOrFold
				+ ", couponType=" + couponType + ", maxIssueQty=" + maxIssueQty + ", issuedQty=" + issuedQty
				+ ", verificationDetail=" + verificationDetail + ", couponPic=" + Arrays.toString(couponPic) + "]";
	}

	public Integer getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(Integer couponNo) {
		this.couponNo = couponNo;
	}

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public Integer getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}

	public Timestamp getCouponApplyDate() {
		return couponApplyDate;
	}

	public void setCouponApplyDate(Timestamp couponApplyDate2) {
		this.couponApplyDate = couponApplyDate2;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Date getCouponStartTime() {
		return couponStartTime;
	}

	public void setCouponStartTime(Date couponStartTime) {
		this.couponStartTime = couponStartTime;
	}

	public Date getCouponEndTime() {
		return couponEndTime;
	}

	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getCouponContent() {
		return couponContent;
	}

	public void setCouponContent(String couponContent) {
		this.couponContent = couponContent;
	}

	public Integer getUsageLimitation() {
		return usageLimitation;
	}

	public void setUsageLimitation(Integer usageLimitation) {
		this.usageLimitation = usageLimitation;
	}

	public Double getAmountOrFold() {
		return amountOrFold;
	}

	public void setAmountOrFold(Double amountOrFold) {
		this.amountOrFold = amountOrFold;
	}

	public Boolean getCouponType() {
		return couponType;
	}

	public void setCouponType(Boolean couponType) {
		this.couponType = couponType;
	}

	public Integer getMaxIssueQty() {
		return maxIssueQty;
	}

	public void setMaxIssueQty(Integer maxIssueQty) {
		this.maxIssueQty = maxIssueQty;
	}

	public Integer getIssuedQty() {
		return issuedQty;
	}

	public void setIssuedQty(Integer issuedQty) {
		this.issuedQty = issuedQty;
	}

	public String getVerificationDetail() {
		return verificationDetail;
	}

	public void setVerificationDetail(String verificationDetail) {
		this.verificationDetail = verificationDetail;
	}

	public byte[] getCouponPic() {
		return couponPic;
	}

	public void setCouponPic(byte[] couponPic) {
		this.couponPic = couponPic;
	}

	public String getCouponPicStr() {
		return couponPicStr;
	}

	public void setCouponPicStr(String couponPicStr) {
		this.couponPicStr = couponPicStr;
	}

	public String getCouponTypeStr() {
		return couponTypeStr;
	}

	public void setCouponTypeStr(String couponTypeStr) {
		this.couponTypeStr = couponTypeStr;
	}
	
}
