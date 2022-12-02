package restaurant.dao;

import java.util.List;

import restaurant.vo.likedRestaurantVO;

public interface likedRestaurantDAO {
	
	public void insert(likedRestaurantVO likedRestaurantVO);

	public void delete(Integer restaurantNo,Integer memberNo);

	public List<likedRestaurantVO> findByMemberNo(Integer memberNo);

}
