package restaurant.service;

import java.util.List;

import restaurant.vo.RestaurantVO;

public interface RestaurantService {

	List<RestaurantVO> findAll();
}
