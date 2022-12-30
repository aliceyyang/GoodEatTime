package com.tibame.tga104.member.controller;

import com.tibame.tga104.member.dto.MemberRequest;
import com.tibame.tga104.member.service.MemberSpringService;
import com.tibame.tga104.member.vo.AdminVO;
import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.restaurant.dto.RestaurantRequest;
import com.tibame.tga104.restaurant.service.RestaurantService;
import com.tibame.tga104.restaurant.vo.RestaurantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class UserAccountController {

    @Autowired
    private MemberSpringService memberSpringService;
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/admin/member-accounts")
    public ResponseEntity<List<MemberVO>> getMemberByAll(HttpSession httpSession
            /*@SessionAttribute(name = "adminVO") AdminVO adminVO*/) {
        AdminVO adminSession = (AdminVO) httpSession.getAttribute("adminVO");
        if (adminSession == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        AdminVO loginAdmin = new AdminVO();
        loginAdmin.setAdminNo(adminSession.getAdminNo());

        List<MemberVO> memberVOList = memberSpringService.getMemberByAll();
        return ResponseEntity.status(HttpStatus.OK).body(memberVOList);

    }

    @GetMapping("/admin/member-accounts/{memberNo}")
    public ResponseEntity<MemberVO> getMemberByNo(/*@SessionAttribute(name = "adminVO") AdminVO adminVO,*/
            @PathVariable Integer memberNo) {
//        if (adminVO == null) return null;

        MemberVO memberVO = memberSpringService.getMemberByNo(memberNo);
        return ResponseEntity.status(HttpStatus.OK).body(memberVO);
    }

    @PutMapping("/admin/member-accounts/{memberNo}")
    public ResponseEntity<MemberVO> updateMemberByNo(/*@SessionAttribute(name = "adminVO") AdminVO adminVO,*/
            @PathVariable Integer memberNo,
            @RequestBody @Valid MemberRequest memberRequest) {
//        if (adminVO == null) return null;

        memberSpringService.updateMemberByNo(memberNo, memberRequest);
        MemberVO memberVO = memberSpringService.getMemberByNo(memberNo);
        return ResponseEntity.status(HttpStatus.OK).body(memberVO);

    }

    @GetMapping("/admin/restaurant-accounts")
    public ResponseEntity<List<RestaurantVO>> getRestaurantByAll(/*@SessionAttribute(name = "adminVO") AdminVO adminVO*/) {
//        if (adminVO == null) {
//            return null;
//        }

        List<RestaurantVO> restaurantVOList = restaurantService.getRestaurantByAll();
        return ResponseEntity.status(HttpStatus.OK).body(restaurantVOList);
    }

    @GetMapping("/admin/restaurant-accounts/{restaurantNo}")
    public ResponseEntity<RestaurantVO> getRestaurantByNo(/*@SessionAttribute(name = "adminVO") AdminVO adminVO,*/ @PathVariable Integer restaurantNo) {
//        if (adminVO == null) return null;

        RestaurantVO restaurantVO = restaurantService.getRestaurantByNo(restaurantNo);
        return ResponseEntity.status(HttpStatus.OK).body(restaurantVO);
    }

    @PutMapping("/admin/restaurant-accounts/{restaurantNo}")
    public ResponseEntity<RestaurantVO> updateRestaurantByNo(/*@SessionAttribute(name = "adminVO") AdminVO adminVO,*/
            @PathVariable Integer restaurantNo,
            @RequestBody @Valid RestaurantRequest restaurantRequest) {
//        if (adminVO == null) return null;

        restaurantService.updateRestaurantByNo(restaurantNo, restaurantRequest);
        RestaurantVO restaurantVO = restaurantService.getRestaurantByNo(restaurantNo);
        return ResponseEntity.status(HttpStatus.OK).body(restaurantVO);

    }

}
