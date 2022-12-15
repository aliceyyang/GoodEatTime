package com.tibame.tga104.member.controller;

import com.tibame.tga104.member.service.AdministratorService;
import com.tibame.tga104.member.service.MemberSpringService;
import com.tibame.tga104.member.vo.Administrator;
import com.tibame.tga104.member.vo.MemberVO;
import com.tibame.tga104.restaurant.service.RestaurantService;
import com.tibame.tga104.restaurant.vo.RestaurantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MemberSpringService memberSpringService;

    
    @GetMapping("/administrator/member-accounts")
    public ResponseEntity<List<MemberVO>> getMemberAccountsByAll() {
        List<MemberVO> memberList = memberSpringService.getAccountByAll();
        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

    @GetMapping("/administrator/restaurant-accounts")
    public ResponseEntity<List<RestaurantVO>> getRestaurantAccountsByAll() {
        List<RestaurantVO> restaurantList = restaurantService.getAccountByAll();
        return ResponseEntity.status(HttpStatus.OK).body(restaurantList);
    }


    @GetMapping("/administrator")
    public ResponseEntity<List<Administrator>> getByAll() {
        List<Administrator> administratorList = administratorService.getByAll();
        return ResponseEntity.status(HttpStatus.OK).body(administratorList);
    }

    @GetMapping("/administrator/{adminNo}")
    private ResponseEntity<Administrator> read(@PathVariable Integer adminNo) {
        Administrator administrator = administratorService.getByAdminNo(adminNo);
        System.out.println("查詢系統管理員編號");
        return ResponseEntity.status(HttpStatus.OK).body(administrator);
    }

    @GetMapping("/administrator/{adminAccount}")
    private ResponseEntity<Administrator> read(@PathVariable String adminAccount) {
        Administrator administrator = administratorService.getByAdminAccount(adminAccount);
        System.out.println("查詢帳號");
        return ResponseEntity.status(HttpStatus.OK).body(administrator);
    }

    @PostMapping("/administrator")
    public ResponseEntity<Administrator> create(@RequestBody Administrator administrator) {
        Integer adminNo = administratorService.insert(administrator);
        Administrator newAccount = administratorService.getByAdminNo(adminNo);
        System.out.println("新增一筆管理員帳號");
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @PutMapping("/administrator-update/{adminNo}")
    public ResponseEntity<Administrator> update(@PathVariable Integer adminNo,
                                                @RequestBody Administrator administrator) {
        Administrator byAdministrator = administratorService.getByAdminNo(adminNo);
        if(byAdministrator!=null){
            administratorService.update(adminNo, administrator);
            Administrator updateAdmin = administratorService.getByAdminNo(adminNo);
            System.out.println("更新帳號資訊");
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/administrator-delete/{adminNo}")
    public ResponseEntity delete(@PathVariable Integer adminNo) {
        administratorService.deleteByAdminNo(adminNo);
        System.out.println("刪除一筆帳號");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
