package com.tibame.tga104.restaurant.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.restaurant.service.MenuService;
import com.tibame.tga104.restaurant.service.RestaurantCarouselPicService;
import com.tibame.tga104.restaurant.service.RestaurantPostService;
import com.tibame.tga104.restaurant.vo.MenuVO;
import com.tibame.tga104.restaurant.vo.RestaurantCarouselPicVO;
import com.tibame.tga104.restaurant.vo.RestaurantPostVO;
import com.tibame.tga104.restaurant.vo.RestaurantVO;

@RestController
public class UpdatePicController {

	@Autowired
	private RestaurantCarouselPicService carouselPicService;
	@Autowired
	private RestaurantPostService postService;
	@Autowired
	private MenuService menuService;

//	查詢該餐廳所有輪播圖片/貼文/菜單
	@GetMapping("/restaurant-readInfo/{management}/{restaurantNo}")
	public ResponseEntity<List> getByRestaurantNo(HttpSession httpSession,
												 @PathVariable String management,
												 @PathVariable Integer restaurantNo) {
		
		RestaurantMemberVO session = (RestaurantMemberVO)httpSession.getAttribute("restaurantMemberVO");
		if (session != null) {
            restaurantNo = session.getRestaurantNo();
        }
			switch (management) {
		case "CarouselPic": {
			List<RestaurantCarouselPicVO> carouselPicVO = carouselPicService.findByRestaurantNo(restaurantNo);
			for (RestaurantCarouselPicVO vo : carouselPicVO) {
				if (vo.getCarouselPic() != null) {
					String base64 = Base64.getEncoder().encodeToString(vo.getCarouselPic());
					vo.setCarouselPicStr(base64);
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(carouselPicVO);
		}
		
		case "Post": {
			List<RestaurantPostVO> postVO = postService.findByRestaurantNo(restaurantNo);
			for (RestaurantPostVO vo : postVO) {
				if (vo.getPostPic() != null) {
					String base64 = Base64.getEncoder().encodeToString(vo.getPostPic());
					vo.setPostPicStr(base64);
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(postVO);
		}
		
		case "Menu": {
			List<MenuVO> menuVO = menuService.findByRestaurantNo(restaurantNo);
			for (MenuVO vo : menuVO) {
				if (vo.getMenuPic() != null) {
					String base64 = Base64.getEncoder().encodeToString(vo.getMenuPic());
					vo.setMenuPicstr(base64);
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(menuVO);
		}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PutMapping("/restaurant-updatePost")
	public void updatePost(@RequestBody RestaurantPostVO post) {
		byte[] postPic = Base64.getDecoder().decode(post.getPostPicStr());
		post.setPostPic(postPic);
		postService.updateRestaurantPost(post);
	}

	@PutMapping("/restaurant-updateMenu")
	public void updateMenu(@RequestBody MenuVO menu) {
		byte[] menuPic = Base64.getDecoder().decode(menu.getMenuPicstr());
		menu.setMenuPic(menuPic);
		menuService.updateMenu(menu);
	}

//	透過輪播圖片/貼文/菜單的PK進行刪除
	@DeleteMapping("/restaurant-deleteInfo/{management}/{primaryKey}")
	public ResponseEntity<Boolean> deleteByPrimaryKey(@PathVariable String management,
			@PathVariable Integer primaryKey) {
		Boolean del = null;
		switch (management) {
		case "CarouselPic": {
			del = carouselPicService.deleteRestaurantCarouselPic(primaryKey);
			break;
		}
		case "Post": {
			del = postService.deleteRestaurantPost(primaryKey);
			break;
		}
		case "Menu": {
			del = menuService.deleteMenu(primaryKey);
			break;
		}
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(del);

	}
}
