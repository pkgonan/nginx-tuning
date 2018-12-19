package com.pkgonan.nginxtuning.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "couponStatisticsCursor")
@Getter
public class Coupon {

    @Id
    private LocalDate criteriaDate;
    private long cursorId;

    Coupon() {}
}
