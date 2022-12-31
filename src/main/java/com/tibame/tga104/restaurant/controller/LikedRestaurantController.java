package com.tibame.tga104.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.restaurant.service.LikedRestaurantService;
import com.tibame.tga104.restaurant.vo.LikedRestaurantVO;

@RestController
public class LikedRestaurantController {
	
	@Autowired
	private LikedRestaurantService service;
	
	//加入最愛餐廳
	@PostMapping("/LikedRestaurant-add")
	public boolean addLikedRestaurant(HttpSession httpSession, @RequestBody LikedRestaurantVO likedRestaurantVO) {
		MemberVO session = (MemberVO)httpSession.getAttribute("memberVO");
		if(session == null) {
			System.out.println("會員尚未登入");
			return false;
		}
		likedRestaurantVO.setMemberNo(session.getMemberNo());
		return service.addLikedRestaurant(likedRestaurantVO);
	}
	
	//刪除最愛餐廳
	@DeleteMapping("/LikedRestaurant-delete")
	public void deleteLikedRestaurant(HttpSession httpSession, @RequestBody LikedRestaurantVO likedRestaurantVO) {
		MemberVO session = (MemberVO)httpSession.getAttribute("memberVO");
		if(session != null) {
			likedRestaurantVO.setMemberNo(session.getMemberNo());
		}
		service.deleteLikedRestaurant(likedRestaurantVO);
	}
	
	//列出該會員所有最愛餐廳
	@GetMapping("/LikedRestaurant-list/{memberNo}")
	public List<LikedRestaurantVO> getListLikedRestaurant(HttpSession httpSession, @PathVariable Integer memberNo){
		MemberVO session = (MemberVO)httpSession.getAttribute("memberVO");
		if (session != null) {
			memberNo = session.getMemberNo();
        }
		
		return service.getListLikedRestaurant(memberNo);
	}

}
