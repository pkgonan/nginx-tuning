package com.pkgonan.nginxtuning.repository;

import com.pkgonan.nginxtuning.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, LocalDate> {

}
