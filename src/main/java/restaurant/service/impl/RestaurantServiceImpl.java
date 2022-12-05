package restaurant.service.impl;

import java.util.List;

import javax.naming.NamingException;

import restaurant.dao.RestaurantDao;
import restaurant.dao.impl.RestaurantDaoImpl;
import restaurant.service.RestaurantService;
import restaurant.vo.RestaurantVO;

public class RestaurantServiceImpl implements RestaurantService {
	private RestaurantDao dao;
	
	public RestaurantServiceImpl(){
		dao = new RestaurantDaoImpl();
	}
	
	@Override
	public List<RestaurantVO> getAll() {
		return dao.getAll();
	}

	@Override
	public RestaurantVO addRestaurant(String restaurantTel, String restaurantName, String restaurantTaxIDNo,
			String restaurantAccountInfo, String restaurantBusinessHour, String restaurantAddr,
			Boolean restaurantStatus, String restaurantAccount, String restaurantPassword,
			Integer restaurantCommentQuantity, Integer totalCommentRating) {
		
		RestaurantVO vo = new RestaurantVO();
		vo.setRestaurantTel(restaurantTel);
		vo.setRestaurantName(restaurantName);
		vo.setRestaurantTaxIDNo(restaurantTaxIDNo);
		vo.setRestaurantAccountInfo(restaurantAccountInfo);
		vo.setRestaurantBusinessHour(restaurantBusinessHour);
		vo.setRestaurantAddr(restaurantAddr);
		vo.setRestaurantStatus(restaurantStatus);
		vo.setRestaurantAccount(restaurantAccount);
		vo.setRestaurantPassword(restaurantPassword);
		vo.setRestaurantCommentQuantity(restaurantCommentQuantity);
		vo.setTotalCommentRating(totalCommentRating);
		
		dao.insert(vo);
		return vo;
	}

	@Override
	public RestaurantVO updateRestaurant(String restaurantTel, String restaurantName,
			String restaurantTaxIDNo, String restaurantAccountInfo, String restaurantBusinessHour,
			String restaurantAddr,String restaurantAccount, String restaurantPassword,
			Integer restaurantNO) {
		
		RestaurantVO vo = new RestaurantVO();
		
		vo.setRestaurantTel(restaurantTel);
		vo.setRestaurantName(restaurantName);
		vo.setRestaurantTaxIDNo(restaurantTaxIDNo);
		vo.setRestaurantAccountInfo(restaurantAccountInfo);
		vo.setRestaurantBusinessHour(restaurantBusinessHour);
		vo.setRestaurantAddr(restaurantAddr);
		vo.setRestaurantAccount(restaurantAccount);
		vo.setRestaurantPassword(restaurantPassword);
		vo.setRestaurantNo(restaurantNO);
		
		dao.update(vo);
		
		return vo;
	}

	@Override
	public void setStatus(Integer restaurantNo,Boolean restaurantStatus){
			dao.setStatus(restaurantNo, restaurantStatus);
	}


	@Override
	public RestaurantVO getOneRestaurant(Integer restaurantNo) {
		return dao.findByPrimaryKey(restaurantNo);
	}




}
