package com.mumuni.springboot_web.java_test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.registerCustomDateFormat;

public class LocalTimeTest {

    @Test
    public void localTimeTest(){
        LocalDate target = LocalDate.parse("2020-12-13");
        LocalDate cmp = LocalDate.now();

        Period period = Period.between(target, cmp);
        cmp = cmp.minus(period);

        assertThat(target.isEqual(cmp)).isTrue();

        LocalDateTime target2 = LocalDateTime.parse("2020-12-13T13:00:00");
        LocalDateTime cmp2 = LocalDateTime.now();

        assertThat(target2.isBefore(cmp2)).isTrue();
    }
}
