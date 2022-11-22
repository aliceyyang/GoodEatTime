package restaurant.service;

import java.util.List;

import javax.naming.NamingException;

import restaurant.dao.RestaurantDao;
import restaurant.dao.impl.RestaurantDaoImpl;
import restaurant.vo.RestaurantVO;

public class RestaurantServiceImpl implements RestaurantService {
	private RestaurantDao dao;
	
	public RestaurantServiceImpl() throws NamingException {
		dao = new RestaurantDaoImpl();
	}
	
	@Override
	public List<RestaurantVO> findAll() {
		return dao.getAll();
	}

}
