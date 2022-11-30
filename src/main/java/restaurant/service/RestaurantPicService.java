package restaurant.service;

import java.util.List;

import restaurant.vo.RestaurantVO;

public interface RestaurantPicService {
	
	RestaurantVO addRestaurantPic(Integer restaurantNO,byte[] restaurantPic,String restaurantPicRemark);
	
	RestaurantVO updateRestaurant(Integer restaurantPicNo,Integer restaurantNo,byte[] restaurantPic,String restaurantPicRemark);

	void deleteRestaurant(StringBuffer errorMsg,Integer restaurantPicNo);
	
	List<RestaurantVO> getAll();
	
	RestaurantVO getOneRestaurant(StringBuffer errorMsg, Integer restaurantPicNo);

}
