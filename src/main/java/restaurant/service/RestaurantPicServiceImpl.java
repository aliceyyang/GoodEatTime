package restaurant.service;

import java.util.List;

import restaurant.dao.RestaurantPicDAO;
import restaurant.dao.impl.RestaurantPicDaoImpl;
import restaurant.vo.RestaurantPicVO;

public class RestaurantPicServiceImpl implements RestaurantPicService {
	private RestaurantPicDAO dao;
	
	public RestaurantPicServiceImpl() {
		dao = new RestaurantPicDaoImpl();
	}

	@Override
	public RestaurantPicVO addRestaurantPic(Integer restaurantNO,byte[] restaurantPic,String restaurantPicRemark) {
		
		RestaurantPicVO vo = new RestaurantPicVO();
		vo.setrestaurantNo(restaurantNO);
		vo.setrestaurantPic(restaurantPic);
		vo.setrestaurantPicRemark(restaurantPicRemark);
		
		dao.insert(vo);
		
		return vo;
	}

	@Override
	public RestaurantPicVO updateRestaurant(byte[] restaurantPic,String restaurantPicRemark,Integer restaurantPicNo) {
		RestaurantPicVO vo = new RestaurantPicVO();
		vo.setrestaurantPic(restaurantPic);
		vo.setrestaurantPicRemark(restaurantPicRemark);
		vo.setrestaurantPicNo(restaurantPicNo);

		dao.update(vo);
		
		return vo;
	}

	@Override
	public void deleteRestaurant(StringBuffer errorMsg, Integer restaurantPicNo) {
		if(restaurantPicNo == null) {
			errorMsg.append("請輸入餐廳編號");
		}
		else {
			dao.delete(restaurantPicNo);
		}
		
	}

	@Override
	public List<RestaurantPicVO> getRestaurantPic(Integer restaurantNo) {
		
		return dao.findByRestaurantNo(restaurantNo);
	}

	@Override
	public RestaurantPicVO getOneRestaurantPic(StringBuffer errorMsg, Integer restaurantPicNo) {
		if(restaurantPicNo == null) {
			errorMsg.append("請輸入餐廳編號");
			return null;
		}
		
		return dao.findByPrimaryKey(restaurantPicNo);
	}
	

}
