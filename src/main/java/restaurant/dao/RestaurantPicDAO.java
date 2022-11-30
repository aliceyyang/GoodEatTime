package restaurant.dao;

import java.util.List;

import restaurant.vo.RestaurantPicVo;

public interface RestaurantPicDAO {
	
	public void insert(RestaurantPicVo restaurantPicVO);

	public void update(RestaurantPicVo restaurantPicVO);

	public void delete(Integer restaurantPicNo);

	public RestaurantPicVo findByPrimaryKey(Integer restaurantPicNo);

	public List<RestaurantPicVo> getAll();


}
