package restaurant.service.impl;

import java.util.List;

import restaurant.dao.LikedRestaurantDAO;
import restaurant.dao.impl.LikedRestaurantDAOImpl;
import restaurant.service.LikedRestaurantService;
import restaurant.vo.LikedRestaurantVO;

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
