package com.mumuni.springboot_web.rest_lookup._vo;

import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Getter @Setter
public class CountOfPeriodVO {
    int count;
    String date;
    PeriodIntervalType intervalType;
}