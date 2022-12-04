package restaurant.service;

import java.util.List;

import restaurant.vo.LikedRestaurantVO;

public interface LikedRestaurantService {
	
	LikedRestaurantVO addLikedRestaurant(Integer memberNo,Integer restaurantNo);
	
	void deleteLikedRestaurant(Integer memberNo,Integer restaurantNo);
	
	List<LikedRestaurantVO> getListLikedRestaurant(Integer memberNo);

}
