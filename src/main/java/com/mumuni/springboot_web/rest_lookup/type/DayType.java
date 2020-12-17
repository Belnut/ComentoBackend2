package com.mumuni.springboot_web.rest_lookup.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/* for MYSQL DB*/
@Getter
@AllArgsConstructor
public enum DayType {
    SUN(1), MON(2), TUE(3), WEN(4), THU(5), FRI(6), SAT(7);
    private int intValue;
}
