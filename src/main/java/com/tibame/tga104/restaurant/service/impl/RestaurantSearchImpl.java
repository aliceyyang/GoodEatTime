package com.tibame.tga104.restaurant.service.impl;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.RestaurantSearchDAO;
import com.tibame.tga104.restaurant.service.RestaurantSearchService;
import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

@Component
public class RestaurantSearchImpl implements RestaurantSearchService {

	@Autowired
	private RestaurantSearchDAO dao;

	@Override
	public List<RestaurantSearchVO> getAll() {
		List<RestaurantSearchVO> list = dao.getAll();
		for (RestaurantSearchVO vo : list) {
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
		System.out.println(list);
		return list;
		// if (restaurantName != null) {
//			return dao.selectByrestaurantName(restaurantName);
//		}
//		return null;
	}

	@Override
	public List<RestaurantSearchVO> selectNewrestaurant() {
		List<RestaurantSearchVO> AllList = dao.getAll();
		for (RestaurantSearchVO vo : AllList) {
			final byte[] carouselPic = vo.getCarouselPic();
			if (carouselPic != null && carouselPic.length != 0) {
				vo.setCarouselPicStr(Base64.getEncoder().encodeToString(carouselPic));
				vo.setCarouselPic(null);
			}
		}
		List<RestaurantSearchVO> newlist = new LinkedList<>();

		for (int i = 1; i <= 3; i++) {
			newlist.add(AllList.get(AllList.size() - i));
		}
//		newlist.add(AllList.get(AllList.size() - 1));
//		newlist.add(AllList.get(AllList.size() - 2));
//		newlist.add(AllList.get(AllList.size() - 3));
//		newlist.add(AllList.get(AllList.size() - 4));

		return newlist;

	}

	@Override
	public List<RestaurantSearchVO> selectByrestaurantNo(Integer restaurantNo) {
		List<RestaurantSearchVO> list = dao.selectByrestaurantNo(restaurantNo);
		for (RestaurantSearchVO vo : list) {
			final byte[] carouselPic = vo.getCarouselPic();
			if (carouselPic != null && carouselPic.length != 0) {
				vo.setCarouselPicStr(Base64.getEncoder().encodeToString(carouselPic));
				vo.setCarouselPic(null);
		}
		
		}
		return list;
	}

}
