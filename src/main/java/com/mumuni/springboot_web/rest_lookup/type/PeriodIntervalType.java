package com.mumuni.springboot_web.rest_lookup.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum PeriodIntervalType {
    MONTH(0, "MONTH"), DAY(1, "DAY");

    private int intValue;
    private String stringValue;

    public static final String MonthFormat = "yyyy-MM";
    public static final String DayFormat = "yyyy-MM-dd";
}
