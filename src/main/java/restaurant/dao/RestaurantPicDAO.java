package restaurant.dao;

import java.util.List;

import restaurant.vo.RestaurantPicVO;

public interface RestaurantPicDAO {
	
	public void insert(RestaurantPicVO restaurantPicVO);

	public void update(RestaurantPicVO restaurantPicVO);

	public void delete(Integer restaurantPicNo);

	public RestaurantPicVO findByPrimaryKey(Integer restaurantPicNo);

	public List<RestaurantPicVO> findByRestaurantNo(Integer restaurantNo);


}
