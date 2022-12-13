package com.tibame.tga104.order.controller;

import com.tibame.tga104.order.service.AdOrderService;
import com.tibame.tga104.order.vo.AdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AdOrderController {
    @Autowired
    private AdOrderService adOrderService;

    @GetMapping("/adOrder")
    private ResponseEntity<List<AdOrder>> getByAll() {
        List<AdOrder> getAdOrderVOList = adOrderService.getByAll();
        return ResponseEntity.status(HttpStatus.OK).body(getAdOrderVOList);
    }
    @GetMapping("/adOrder/adOrderNo/{adOrderNo}")
    private ResponseEntity<AdOrder> getByAdOrderNo(@PathVariable Integer adOrderNo) {
        AdOrder adOrder = adOrderService.getByAdOrderNo(adOrderNo);
        if (adOrder != null) {
            return ResponseEntity.status(HttpStatus.OK).body(adOrder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/adOrder/restaurantNo/{restaurantNo}")
    public ResponseEntity<AdOrder> getByRestaurantNo(@PathVariable Integer restaurantNo) {
        AdOrder adOrder = adOrderService.getByRestaurantNo(restaurantNo);
        if (adOrder != null) {
            return ResponseEntity.status(HttpStatus.OK).body(adOrder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adOrder")
    private ResponseEntity<AdOrder> createAdOrder(@RequestBody @Valid AdOrder adOrder) {
        Integer newAdOrderNo = adOrderService.createAdOrder(adOrder);
        AdOrder newAdOrder = adOrderService.getByAdOrderNo(newAdOrderNo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAdOrder);
    }

    @PutMapping("/adOrder/{adOrderNo}")
    public ResponseEntity<AdOrder> updateAdOrder(@PathVariable Integer adOrderNo,
                                                 @RequestBody @Valid AdOrder adOrder) {
        AdOrder byAdOrderNo = adOrderService.getByAdOrderNo(adOrderNo);
        if (byAdOrderNo != null) {
            adOrderService.updateAdOrder(adOrderNo, adOrder);
            AdOrder updateAdOrder = adOrderService.getByAdOrderNo(adOrderNo);
            return ResponseEntity.status(HttpStatus.OK).body(updateAdOrder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/adOrder/{adOrderNo}")
    public ResponseEntity<AdOrder> deleteByAdOrderNo(@PathVariable Integer adOrderNo) {
        adOrderService.deleteByAdOrderNo(adOrderNo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
