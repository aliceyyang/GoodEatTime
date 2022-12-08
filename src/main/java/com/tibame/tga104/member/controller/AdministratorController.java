package com.tibame.tga104.member.controller;

import com.tibame.tga104.member.service.AdministratorService;
import com.tibame.tga104.member.vo.AdministratorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/administrator-read-adminNo/{adminNo}")
    private ResponseEntity<AdministratorVO> read(@PathVariable Integer adminNo){
        AdministratorVO administratorVO = administratorService.getByAdminNo(adminNo);
        System.out.println("查詢系統管理員編號");
        return ResponseEntity.status(HttpStatus.OK).body(administratorVO);
    }
    @GetMapping("/administrator-read-adminAccount/{adminAccount}")
    private ResponseEntity<AdministratorVO> read(@PathVariable String adminAccount){
        AdministratorVO administratorVO = administratorService.getByAdminAccount(adminAccount);
        System.out.println("查詢帳號");
        return ResponseEntity.status(HttpStatus.OK).body(administratorVO);
    }

    @PostMapping("/administrator-create")
    public ResponseEntity<AdministratorVO> create(@RequestBody AdministratorVO administratorVO) {
        Integer adminNo = administratorService.insert(administratorVO);
        AdministratorVO newAccount = administratorService.getByAdminNo(adminNo);
        System.out.println("新增一筆管理員帳號");
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }
    @PutMapping("/administrator-update/{adminNo}")
    public ResponseEntity<AdministratorVO> update(@PathVariable Integer adminNo,
                                                  @RequestBody AdministratorVO administratorVO){
        administratorVO.setAdminNo(adminNo);
        administratorService.update(administratorVO);
        System.out.println("更新帳號資訊");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/administrator-delete/{adminNo}")
    public ResponseEntity delete(@PathVariable Integer adminNo) {
        administratorService.deleteByAdminNo(adminNo);
        System.out.println("刪除一筆帳號");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
