package coupon.vo;

import java.io.Serializable;

public class CouponVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer couponNo;
	private Integer restaurantNo;
	private Integer adminNo;
	private String couponApplyDate;
	private String couponName;
	private String couponStartTime;
	private String couponEndTime;
	private Boolean verified;
	private String couponContent;
	private Integer usageLimitation;
	private Double amountOrFold;
	private Boolean couponType;
	private Integer maxIssueQty;
	private Integer issuedQty;
	private String verificationDetail;
	
	public CouponVO() {
		super();
	
	}


	public CouponVO(Integer couponNo, Integer restaurantNo, Integer adminNo, String couponApplyDate,
			String couponName, String couponStartTime, String couponEndTime, Boolean verified, String couponContent,
			Integer usageLimitation, Double amountOrFold, Boolean couponType, Integer maxIssueQty, Integer issuedQty,
			String verificationDetail) {
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
	}

	@Override
	public String toString() {
		return "couponvo [couponNo=" + couponNo + ", restaurantNo=" + restaurantNo + ", adminNo=" + adminNo
				+ ", couponApplyDate=" + couponApplyDate + ", couponName=" + couponName + ", couponStartTime="
				+ couponStartTime + ", couponEndTime=" + couponEndTime + ", verified=" + verified + ", couponContent="
				+ couponContent + ", usageLimitation=" + usageLimitation + ", amountOrFold=" + amountOrFold
				+ ", couponType=" + couponType + ", maxIssueQty=" + maxIssueQty + ", issuedQty=" + issuedQty
				+ ", verificationDetail=" + verificationDetail + "]";
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

	public String getCouponApplyDate() {
		return couponApplyDate;
	}

	public void setCouponApplyDate(String couponApplyDate) {
		this.couponApplyDate = couponApplyDate;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponStartTime() {
		return couponStartTime;
	}

	public void setCouponStartTime(String couponStartTime) {
		this.couponStartTime = couponStartTime;
	}

	public String getCouponEndTime() {
		return couponEndTime;
	}

	public void setCouponEndTime(String couponEndTime) {
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
	
	
}
