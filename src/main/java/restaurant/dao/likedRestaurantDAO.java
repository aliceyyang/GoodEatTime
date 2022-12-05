package restaurant.dao;

import java.util.List;

import restaurant.vo.LikedRestaurantVO;

public interface LikedRestaurantDAO {
	
	public void insert(LikedRestaurantVO likedRestaurantVO);

	public void delete(Integer memberNo,Integer restaurantNo);

	public List<LikedRestaurantVO> findByMemberNo(Integer memberNo);

}
