package restaurant.vo;

import java.io.Serializable;

public class likedRestaurantVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer memberNo;
	private Integer restaurantNo;
	
	
	public likedRestaurantVO() {
		
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

	@Override
	public String toString() {
		return "likedRestaurantVO [memberNo=" + memberNo + ", restaurantNo=" + restaurantNo + "]";
	}

	
	
	

}
