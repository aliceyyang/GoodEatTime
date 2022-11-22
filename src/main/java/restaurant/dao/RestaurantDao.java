package restaurant.dao;

import java.util.*;

import restaurant.vo.RestaurantVO;

public interface RestaurantDao {

	public void insert(RestaurantVO restaurantVO);

	public void update(RestaurantVO restaurantVO);

	public void delete(Integer restaurantNo);

	public RestaurantVO findByPrimaryKey(Integer restaurantNo);

	public List<RestaurantVO> getAll();

}
