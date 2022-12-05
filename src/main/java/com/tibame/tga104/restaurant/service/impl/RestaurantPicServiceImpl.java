package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import com.tibame.tga104.restaurant.dao.RestaurantPicDAO;
import com.tibame.tga104.restaurant.dao.impl.RestaurantPicDaoImpl;
import com.tibame.tga104.restaurant.service.RestaurantPicService;
import com.tibame.tga104.restaurant.vo.RestaurantPicVO;

public class RestaurantPicServiceImpl implements RestaurantPicService {
	private RestaurantPicDAO dao;
	
	public RestaurantPicServiceImpl() {
		dao = new RestaurantPicDaoImpl();
	}

	@Override
	public RestaurantPicVO addRestaurantPic(Integer restaurantNO,byte[] restaurantPic,String restaurantPicRemark) {
		
		RestaurantPicVO vo = new RestaurantPicVO();
		vo.setRestaurantNo(restaurantNO);
		vo.setRestaurantPic(restaurantPic);
		vo.setRestaurantPicRemark(restaurantPicRemark);
		
		dao.insert(vo);
		
		return vo;
	}

	@Override
	public RestaurantPicVO updateRestaurantPic(byte[] restaurantPic,String restaurantPicRemark,Integer restaurantPicNo) {
		RestaurantPicVO vo = new RestaurantPicVO();
		vo.setRestaurantPic(restaurantPic);
		vo.setRestaurantPicRemark(restaurantPicRemark);
		vo.setRestaurantPicNo(restaurantPicNo);

		dao.update(vo);
		
		return vo;
	}

	@Override
	public void deleteRestaurantPic(Integer restaurantPicNo) {
			dao.delete(restaurantPicNo);
	}

	@Override
	public List<RestaurantPicVO> getRestaurantPic(Integer restaurantNo) {
		
		return dao.findByRestaurantNo(restaurantNo);
	}

	@Override
	public RestaurantPicVO getOneRestaurantPic(Integer restaurantPicNo) {
		return dao.findByPrimaryKey(restaurantPicNo);
	}
	

}
