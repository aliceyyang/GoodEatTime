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
	public List<RestaurantVO> getAll() {
		return dao.getAll();
	}

	@Override
	public RestaurantVO addRestaurant(String restaurantTel, String restaurantName, String restaurantTaxIDNo,
			String restaurantAccountInfo, String restaurantBusinessHour, String restaurantAddr,
			Boolean restaurantStatus, String restaurantAccount, String restaurantPassword,
			Integer restaurantCommentQuantity, Integer totalCommentRating) {
		
		RestaurantVO vo = new RestaurantVO();
		vo.setrestaurantTel(restaurantTel);
		vo.setrestaurantName(restaurantName);
		vo.setrestaurantTaxIDNo(restaurantTaxIDNo);
		vo.setrestaurantAccountInfo(restaurantAccountInfo);
		vo.setrestaurantBusinessHour(restaurantBusinessHour);
		vo.setrestaurantAddr(restaurantAddr);
		vo.setrestaurantStatus(restaurantStatus);
		vo.setrestaurantAccount(restaurantAccount);
		vo.setrestaurantPassword(restaurantPassword);
		vo.setrestaurantCommentQuantity(restaurantCommentQuantity);
		vo.setTotalCommentRating(totalCommentRating);
		
		dao.insert(vo);
		return vo;
	}

	@Override
	public RestaurantVO updateRestaurant(String restaurantTel, String restaurantName,
			String restaurantTaxIDNo, String restaurantAccountInfo, String restaurantBusinessHour,
			String restaurantAddr, Boolean restaurantStatus, String restaurantAccount, String restaurantPassword,
			Integer restaurantCommentQuantity, Integer totalCommentRating,Integer restaurantNO) {
		
		RestaurantVO vo = new RestaurantVO();
		
		vo.setrestaurantTel(restaurantTel);
		vo.setrestaurantName(restaurantName);
		vo.setrestaurantTaxIDNo(restaurantTaxIDNo);
		vo.setrestaurantAccountInfo(restaurantAccountInfo);
		vo.setrestaurantBusinessHour(restaurantBusinessHour);
		vo.setrestaurantAddr(restaurantAddr);
		vo.setrestaurantStatus(restaurantStatus);
		vo.setrestaurantAccount(restaurantAccount);
		vo.setrestaurantPassword(restaurantPassword);
		vo.setrestaurantCommentQuantity(restaurantCommentQuantity);
		vo.setTotalCommentRating(totalCommentRating);
		vo.setrestaurantNo(restaurantNO);
		
		dao.update(vo);
		
		return vo;
	}

	@Override
	public void deleteRestaurant(StringBuffer errorMsg,Integer restaurantNo) {
		if(restaurantNo == null) {
			errorMsg.append("請輸入餐廳編號");
		}
		else {
			dao.delete(restaurantNo);
		}
	}

	@Override
	public RestaurantVO getOneRestaurant(StringBuffer errorMsg, Integer restaurantNo) {
		if(restaurantNo == null) {
			errorMsg.append("請輸入餐廳編號");
			return null;
		}
		
		
		return dao.findByPrimaryKey(restaurantNo);
	}


}
