package restaurant.service;

import java.util.List;

import restaurant.vo.RestaurantVO;

public interface RestaurantService {
	
	
	RestaurantVO addRestaurant(String restaurantTel,String restaurantName,String restaurantTaxIDNo,String restaurantAccountInfo,String restaurantBusinessHour,String restaurantAddr,
			Boolean restaurantStatus,String restaurantAccount,String restaurantPassword,Integer restaurantCommentQuantity,Integer totalCommentRating);
	
	RestaurantVO updateRestaurant(String restaurantTel,String restaurantName,String restaurantTaxIDNo,String restaurantAccountInfo,String restaurantBusinessHour,String restaurantAddr,
			String restaurantAccount,String restaurantPassword,Integer restaurantNO);

	void deleteRestaurant(StringBuffer errorMsg,Integer restaurantNo);
	
	List<RestaurantVO> getAll();
	
	RestaurantVO getOneRestaurant(StringBuffer errorMsg, Integer restaurantNo);
}
