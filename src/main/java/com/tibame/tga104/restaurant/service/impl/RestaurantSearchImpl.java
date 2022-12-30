package com.tibame.tga104.restaurant.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.RestaurantSearchDAO;
import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;
@Component
public class RestaurantSearchImpl implements RestaurantSearchDAO{

	@Autowired
	private RestaurantSearchDAO dao;

	@Override
	public List<RestaurantSearchVO> getAll() {
		List<RestaurantSearchVO> list = dao.getAll();
		for (RestaurantSearchVO vo :list) {
			final byte[] carouselPic = vo.getCarouselPic();
			if (carouselPic != null && carouselPic.length != 0) {
				vo.setCarouselPicStr(Base64.getEncoder().encodeToString(carouselPic));
				vo.setCarouselPic(null);
			}
		}
		return list;
	}

	@Override
	public List<RestaurantSearchVO> selectByrestaurantName(String restaurantName) {
		List<RestaurantSearchVO> list = dao.selectByrestaurantName(restaurantName);
		for (RestaurantSearchVO vo : list) {
			final byte[] carouselPic = vo.getCarouselPic();
			if (carouselPic != null && carouselPic.length != 0) {
				vo.setCarouselPicStr(Base64.getEncoder().encodeToString(carouselPic));
				vo.setCarouselPic(null);
			}
		}
		return list;
		//		if (restaurantName != null) {
//			return dao.selectByrestaurantName(restaurantName);
//		}
//		return null;
	}
	

}
