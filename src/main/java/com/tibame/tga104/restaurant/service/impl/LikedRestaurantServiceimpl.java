package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga104.restaurant.dao.LikedRestaurantDAO;
import com.tibame.tga104.restaurant.service.LikedRestaurantService;
import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

@Component
public class LikedRestaurantServiceimpl implements LikedRestaurantService {
	
	@Autowired
	private LikedRestaurantDAO dao;
	
	@Override
	public boolean addLikedRestaurant(LikedRestaurantVO likedRestaurantVO) {
		return dao.insert(likedRestaurantVO);
	}

	@Override
	public void deleteLikedRestaurant(LikedRestaurantVO likedRestaurantVO) {
		dao.delete(likedRestaurantVO);
	}

	@Override
	public List<LikedRestaurantVO> getListLikedRestaurant(Integer memberNo) {
		
		return dao.findByMemberNo(memberNo);
	}

}
