package com.mumuni.springboot_web.rest_lookup.vo;

import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CountOfPeriodVO {
    int count;
    String date;
    PeriodIntervalType intervalType;
}