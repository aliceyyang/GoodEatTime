package restaurant.service;

import java.util.List;

import restaurant.vo.RestaurantPicVO;


public interface RestaurantPicService {
	
	RestaurantPicVO addRestaurantPic(Integer restaurantNO,byte[] restaurantPic,String restaurantPicRemark);
	
	RestaurantPicVO updateRestaurant(byte[] restaurantPic,String restaurantPicRemark,Integer restaurantPicNo);

	void deleteRestaurant(StringBuffer errorMsg,Integer restaurantPicNo);
	
	List<RestaurantPicVO> getRestaurantPic(Integer restaurantNo);
	
	RestaurantPicVO getOneRestaurantPic(StringBuffer errorMsg, Integer restaurantPicNo);

}
