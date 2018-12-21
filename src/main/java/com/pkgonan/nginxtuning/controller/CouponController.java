package com.pkgonan.nginxtuning.controller;

import com.pkgonan.nginxtuning.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/coupon/cursor/{criteriaDate}")
    public Long getCursor(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate criteriaDate){
        return couponService.getCouponStatisticsCursor(criteriaDate);
    }

    @GetMapping("/coupons/{id}")
    public Long getCoupon(@PathVariable long id){
        return id;
    }

    @GetMapping("/nothing")
    public void doNothing(){
    }
}
