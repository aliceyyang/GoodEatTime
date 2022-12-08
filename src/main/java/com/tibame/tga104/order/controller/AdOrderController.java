package com.tibame.tga104.order.controller;

import com.tibame.tga104.order.service.AdOrderService;
import com.tibame.tga104.order.vo.AdOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdOrderController {
    @Autowired
    private AdOrderService adOrderService;

    @GetMapping("/adOrder-read/{adOrderNo}")
    private ResponseEntity<AdOrderVO> read(@PathVariable Integer adOrderNo){
        AdOrderVO adOrderVO = adOrderService.getByAdOrderNo(adOrderNo);
        return ResponseEntity.status(HttpStatus.OK).body(adOrderVO);
    }

    @PostMapping("/adOrder-create")
    private ResponseEntity<AdOrderVO> create(@RequestBody AdOrderVO adOrderVO){
        Integer adOrderNo = adOrderService.insert(adOrderVO);
        AdOrderVO newAdOrder = adOrderService.getByAdOrderNo(adOrderNo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAdOrder);

    }
    @PutMapping("/adOrder-update/{adOrderNo}")
    public ResponseEntity<AdOrderVO> update(@PathVariable Integer adOrderNo,
                       @RequestBody AdOrderVO adOrderVO){
        adOrderVO.setAdOrderNo(adOrderNo);
        adOrderService.update(adOrderVO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/adOrder-delete/{adOrderNo}")
    public ResponseEntity<AdOrderVO> delete(@PathVariable Integer adOrderNo){
        adOrderService.deleteByAdOrderNo(adOrderNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
