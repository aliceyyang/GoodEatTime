package com.tibame.tga104.restaurant.service.impl;

import java.util.List;

import com.tibame.tga104.restaurant.dao.LikedRestaurantDAO;
import com.tibame.tga104.restaurant.dao.impl.LikedRestaurantDAOImpl;
import com.tibame.tga104.restaurant.service.LikedRestaurantService;
import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

public class LikedRestaurantServiceimpl implements LikedRestaurantService {
	
	private LikedRestaurantDAO dao;
	
	public LikedRestaurantServiceimpl() {
		dao = new LikedRestaurantDAOImpl();
	}

	@Override
	public LikedRestaurantVO addLikedRestaurant(Integer memberNo, Integer restaurantNo) {
		LikedRestaurantVO vo = new LikedRestaurantVO();
		vo.setMemberNo(memberNo);
		vo.setRestaurantNo(restaurantNo);
		
		dao.insert(vo);
		return vo;
	}

	@Override
	public void deleteLikedRestaurant(Integer memberNo, Integer restaurantNo) {
		dao.delete(memberNo, restaurantNo);
		
	}

	@Override
	public List<LikedRestaurantVO> getListLikedRestaurant(Integer memberNo) {
		
		return dao.findByMemberNo(memberNo);
	}

}
