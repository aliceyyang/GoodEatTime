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

	public Integer getRestaurantNo() {
		return restaurantNo;
	}

	public void setRestaurantNo(Integer restaurantNo) {
		this.restaurantNo = restaurantNo;
	}

	public String getRestaurantTel() {
		return restaurantTel;
	}

	public void setRestaurantTel(String restaurantTel) {
		this.restaurantTel = restaurantTel;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantTaxIDNo() {
		return restaurantTaxIDNo;
	}

	public void setRestaurantTaxIDNo(String restaurantTaxIDNo) {
		this.restaurantTaxIDNo = restaurantTaxIDNo;
	}

	public String getRestaurantAccountInfo() {
		return restaurantAccountInfo;
	}

	public void setRestaurantAccountInfo(String restaurantAccountInfo) {
		this.restaurantAccountInfo = restaurantAccountInfo;
	}

	public String getRestaurantBusinessHour() {
		return restaurantBusinessHour;
	}

	public void setRestaurantBusinessHour(String restaurantBusinessHour) {
		this.restaurantBusinessHour = restaurantBusinessHour;
	}

	public String getRestaurantAddr() {
		return restaurantAddr;
	}

	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}

	public Boolean getRestaurantStatus() {
		return restaurantStatus;
	}

	public void setRestaurantStatus(Boolean restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}

	public String getRestaurantAccount() {
		return restaurantAccount;
	}

	public void setRestaurantAccount(String restaurantAccount) {
		this.restaurantAccount = restaurantAccount;
	}

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public Integer getRestaurantCommentQuantity() {
		return restaurantCommentQuantity;
	}

	public void setRestaurantCommentQuantity(Integer restaurantCommentQuantity) {
		this.restaurantCommentQuantity = restaurantCommentQuantity;
	}

	public Integer getTotalCommentRating() {
		return totalCommentRating;
	}

	public void setTotalCommentRating(Integer totalCommentRating) {
		this.totalCommentRating = totalCommentRating;
	}

}
