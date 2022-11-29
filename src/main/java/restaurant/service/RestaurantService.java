package restaurant.service;

import java.util.List;

import restaurant.vo.RestaurantVO;

public interface RestaurantService {
	
	RestaurantVO addRestaurant(String restaurantTel,String restaurantName,String restaurantTaxIDNo,String restaurantAccountInfo,String restaurantBusinessHour,String restaurantAddr,
			Boolean restaurantStatus,String restaurantAccount,String restaurantPassword,Integer restaurantCommentQuantity,Integer totalCommentRating);
	
	RestaurantVO updateRestaurant(String restaurantTel,String restaurantName,String restaurantTaxIDNo,String restaurantAccountInfo,String restaurantBusinessHour,String restaurantAddr,
			Boolean restaurantStatus,String restaurantAccount,String restaurantPassword,Integer restaurantCommentQuantity,Integer totalCommentRating,Integer restaurantNO);

	void deleteRestaurant(Integer restaurantNo);
	
	RestaurantVO getOneRestaurant(Integer restaurantNo);
	
	List<RestaurantVO> getAll();
}
