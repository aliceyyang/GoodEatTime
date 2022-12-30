package com.tibame.tga104.order.controller;

import com.tibame.tga104.member.vo.AdminVO;
import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.member.vo.RestaurantMemberVO;
import com.tibame.tga104.order.dto.AdOrderRequest;
import com.tibame.tga104.order.service.AdOrderService;
import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AdOrderController {
    @Autowired
    private AdOrderService adOrderService;

    @GetMapping("/adOrders/admin")
    private ResponseEntity<List<AdOrder>> getByAll(HttpSession httpSession) {
        AdminVO adminSession = (AdminVO) httpSession.getAttribute("adminVO");
        if (adminSession == null) {
            System.out.println("尚未登入");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        AdminVO adminVOLogin = new AdminVO();
        Integer adminNoFromLogin = adminSession.getAdminNo();
        adminVOLogin.setAdminNo(adminNoFromLogin);

        List<AdOrder> getAdOrderVOList = adOrderService.getByAll();
        return ResponseEntity.status(HttpStatus.OK).body(getAdOrderVOList);
    }

    @GetMapping("/adOrders/adOrderNo/{adOrderNo}")
    private ResponseEntity<AdOrder> getByAdOrderNo(@PathVariable Integer adOrderNo) {
        AdOrder adOrder = adOrderService.getByAdOrderNo(adOrderNo);
        if (adOrder != null) {
            return ResponseEntity.status(HttpStatus.OK).body(adOrder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/adOrders/restaurantNo/{restaurantNo}")
    public ResponseEntity<List<AdOrder>> getByRestaurantNo(HttpSession httpSession,
//                                                           @SessionAttribute(name = "restaurantMemberVO") RestaurantMemberVO resLogin,
                                                           @PathVariable Integer restaurantNo) {

        // get the session if it exists
        RestaurantMemberVO resSession = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
        // use restaurantNo from the session object as the path variable

        if (resSession == null ) {
            System.out.println("尚未登入，redirect");
            return null;
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        RestaurantMemberVO restaurantMemberVO = new RestaurantMemberVO();
        restaurantNo = resSession.getRestaurantNo();
        restaurantMemberVO.setRestaurantNo(restaurantNo);

        List<AdOrder> adOrderList = adOrderService.getByRestaurantNo(restaurantNo);
        if (adOrderList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(adOrderList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adOrders")
    private ResponseEntity<AdOrder> createAdOrder(HttpSession httpSession,
//                                                  @SessionAttribute(name = "restaurantMemberVO") RestaurantMemberVO resLogin,
                                                  @RequestBody @Valid AdOrderRequest adOrderRequest) {

        RestaurantMemberVO resSession = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");

        if (resSession == null) {
            System.out.println("尚未登入，redirect");
//            return null;
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            RestaurantMemberVO restaurantMemberVO = new RestaurantMemberVO();
            Integer restaurantNoFromLogin = resSession.getRestaurantNo();
            restaurantMemberVO.setRestaurantNo(restaurantNoFromLogin);

            Integer newAdOrderNo = adOrderService.createAdOrder(restaurantNoFromLogin, adOrderRequest);
            AdOrder newAdOrder = adOrderService.getByAdOrderNo(newAdOrderNo);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAdOrder);
        }
    }

    @PutMapping("/adOrders/admin/{adOrderNo}")
    public ResponseEntity<AdOrder> updateAdOrderByAdmin(HttpSession httpSession,
                                                 @PathVariable Integer adOrderNo,
                                                 @RequestBody @Valid AdOrderRequest adOrderRequest) {
        AdminVO adminSession = (AdminVO) httpSession.getAttribute("adminVO");
//        RestaurantMemberVO restaurantMemberVO = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
        if (adminSession == null) {
            System.out.println("尚未登入");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        AdminVO adminVOLogin = new AdminVO();
        Integer adminNoFromLogin = adminSession.getAdminNo();
        adOrderRequest.setAdminNo(adminNoFromLogin);
        adminVOLogin.setAdminNo(adminNoFromLogin);

        adOrderService.updateAdOrder(adOrderNo, adOrderRequest);
        AdOrder adOrder = adOrderService.getByAdOrderNo(adOrderNo);
        System.out.println("已成功修改訂單編號 " + adOrderNo);
        return ResponseEntity.status(HttpStatus.OK).body(adOrder);
    }

    @PutMapping("/adOrders/restaurant/{adOrderNo}")
    public ResponseEntity<AdOrder> updateAdOrderByRes(HttpSession httpSession,
                                                 @PathVariable Integer adOrderNo,
                                                 @RequestBody @Valid AdOrderRequest adOrderRequest) {
//        AdminVO adminSession = (AdminVO) httpSession.getAttribute("adminVO");
        RestaurantMemberVO resSession = (RestaurantMemberVO) httpSession.getAttribute("restaurantMemberVO");
        if (resSession == null) {
            System.out.println("尚未登入");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        RestaurantMemberVO resLogin = new RestaurantMemberVO();
        Integer resNoFromLogin = resSession.getRestaurantNo();
        adOrderRequest.setRestaurantNo(resNoFromLogin);
        resLogin.setRestaurantNo(resNoFromLogin);

        adOrderService.updateAdOrder(adOrderNo, adOrderRequest);
        AdOrder adOrder = adOrderService.getByAdOrderNo(adOrderNo);
        System.out.println("已成功修改訂單編號 " + adOrderNo);
        return ResponseEntity.status(HttpStatus.OK).body(adOrder);
    }

    @DeleteMapping("/adOrders/{adOrderNo}")
    public ResponseEntity<AdOrder> deleteByAdOrderNo(@PathVariable Integer adOrderNo) {
        adOrderService.deleteByAdOrderNo(adOrderNo);
        System.out.println("已成功刪除訂單編號 " + adOrderNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
