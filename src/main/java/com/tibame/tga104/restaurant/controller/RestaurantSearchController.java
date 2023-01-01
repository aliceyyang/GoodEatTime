package com.tibame.tga104.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga104.restaurant.service.impl.RestaurantSearchImpl;
import com.tibame.tga104.restaurant.vo.RestaurantSearchVO;

@RestController
@RequestMapping("/search_restaurant")
public class RestaurantSearchController {
	
	@Autowired
	private RestaurantSearchImpl restaurantSearchImpl;
	
	
	
	
	@GetMapping("/search")
	public List<RestaurantSearchVO> search(@RequestParam String restaurantName) {
		System.out.println(restaurantName);
		List<RestaurantSearchVO> list = restaurantSearchImpl.selectByrestaurantName(restaurantName);
		System.out.println(list);
			if (list != null && !list.isEmpty()) {
//				System.out.println("b");
//				System.out.println(list);
				return list;
			} else {
				List<RestaurantSearchVO> listAll =  restaurantSearchImpl.getAll();
//				System.out.println("a");
//				System.out.println(listAll);
				return listAll;
			}
	}
	
	@GetMapping("/newrestaurant")
	public List<RestaurantSearchVO> newrestaurant() {
		List<RestaurantSearchVO> newlist = restaurantSearchImpl.selectNewrestaurant();
		System.out.println(newlist);
		return newlist;
	}
}
