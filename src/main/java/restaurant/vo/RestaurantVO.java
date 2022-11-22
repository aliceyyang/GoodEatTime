package restaurant.vo;

import java.io.Serializable;

public class RestaurantVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer restaurantNo;
	private String restaurantTel;
	private String restaurantName;
	private String restaurantTaxIDNo;
	private String restaurantAccountInfo;
	private String restaurantBusinessHour;
	private String restaurantAddr;
	private Boolean restaurantStatus;
	private String restaurantAccount;
	private String restaurantPassword;
	private Integer restaurantCommentQuantity;
	private Integer totalCommentRating;
	
	public RestaurantVO() {
		
	}

	public RestaurantVO(Integer restaurantNo, String restaurantTel, String restaurantName, String restaurantTaxIDNo,
			String restaurantAccountInfo, String restaurantBusinessHour, String restaurantAddr,
			Boolean restaurantStatus, String restaurantAccount, String restaurantPassword,
			Integer restaurantCommentQuantity, Integer totalCommentRating) {
		super();
		this.restaurantNo = restaurantNo;
		this.restaurantTel = restaurantTel;
		this.restaurantName = restaurantName;
		this.restaurantTaxIDNo = restaurantTaxIDNo;
		this.restaurantAccountInfo = restaurantAccountInfo;
		this.restaurantBusinessHour = restaurantBusinessHour;
		this.restaurantAddr = restaurantAddr;
		this.restaurantStatus = restaurantStatus;
		this.restaurantAccount = restaurantAccount;
		this.restaurantPassword = restaurantPassword;
		this.restaurantCommentQuantity = restaurantCommentQuantity;
		this.totalCommentRating = totalCommentRating;
	}

	@Override
	public String toString() {
		return "RestaurantVO [restaurantNo=" + restaurantNo + ", restaurantTel=" + restaurantTel + ", restaurantName="
				+ restaurantName + ", restaurantTaxIDNo=" + restaurantTaxIDNo + ", restaurantAccountInfo="
				+ restaurantAccountInfo + ", restaurantBusinessHour=" + restaurantBusinessHour + ", restaurantAddr="
				+ restaurantAddr + ", restaurantStatus=" + restaurantStatus + ", restaurantAccount=" + restaurantAccount
				+ ", restaurantPassword=" + restaurantPassword + ", restaurantCommentQuantity="
				+ restaurantCommentQuantity + ", totalCommentRating=" + totalCommentRating + "]";
	}

	public Integer getrestaurantNo() {
		return restaurantNo;
	}

	public void setrestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getrestaurantTel() {
		return restaurantTel;
	}

	public void setrestaurantTel(String restaurantTel) {
		this.restaurantTel = restaurantTel;
	}

	public String getrestaurantName() {
		return restaurantName;
	}

	public void setrestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getrestaurantTaxIDNo() {
		return restaurantTaxIDNo;
	}

	public void setrestaurantTaxIDNo(String restaurantTaxIDNo) {
		this.restaurantTaxIDNo = restaurantTaxIDNo;
	}

	public String getrestaurantAccountInfo() {
		return restaurantAccountInfo;
	}

	public void setrestaurantAccountInfo(String restaurantAccountInfo) {
		this.restaurantAccountInfo = restaurantAccountInfo;
	}

	public String getrestaurantBusinessHour() {
		return restaurantBusinessHour;
	}

	public void setrestaurantBusinessHour(String restaurantBusinessHour) {
		this.restaurantBusinessHour = restaurantBusinessHour;
	}

	public String getrestaurantAddr() {
		return restaurantAddr;
	}

	public void setrestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}

	public Boolean getrestaurantStatus() {
		return restaurantStatus;
	}

	public void setrestaurantStatus(Boolean restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}

	public String getrestaurantAccount() {
		return restaurantAccount;
	}

	public void setrestaurantAccount(String restaurantAccount) {
		this.restaurantAccount = restaurantAccount;
	}

	public String getrestaurantPassword() {
		return restaurantPassword;
	}

	public void setrestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public Integer getrestaurantCommentQuantity() {
		return restaurantCommentQuantity;
	}

	public void setrestaurantCommentQuantity(Integer restaurantCommentQuantity) {
		this.restaurantCommentQuantity = restaurantCommentQuantity;
	}

	public Integer getTotalCommentRating() {
		return totalCommentRating;
	}

	public void setTotalCommentRating(Integer totalCommentRating) {
		this.totalCommentRating = totalCommentRating;
	}

}
