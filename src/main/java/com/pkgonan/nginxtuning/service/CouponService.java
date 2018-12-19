package com.pkgonan.nginxtuning.service;

import com.pkgonan.nginxtuning.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public long getCouponStatisticsCursor(LocalDate criteriaDate) {
        return couponRepository.findById(criteriaDate).orElseThrow(NoSuchElementException::new).getCursorId();
    }
}
