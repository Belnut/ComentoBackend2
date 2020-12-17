package com.mumuni.springboot_web.rest_lookup.connection.controller;

import com.mumuni.springboot_web.rest_lookup.LookupDefaultListResult;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.service.ConnectionGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/connection")
public class LookupConnectionController {
    private final ConnectionGetService getService;

    @GetMapping("/count/monthly")
    public LookupDefaultListResult<CountOfPeriodVO> ConnectionCountMonthlyLookupRequest(
            @RequestParam Integer year) {
        LocalDate target_date = LocalDate.of(year, 1, 1);
        LookupDefaultListResult<CountOfPeriodVO> requestVO = getService.getConnectionCounts(target_date, PeriodIntervalType.MONTH);
        return requestVO;
    }

    @GetMapping("/count/daily")
    LookupDefaultListResult<CountOfPeriodVO> ConnectionCountDailyLookupRequest(
            @RequestParam Integer year, Integer month) {
        LocalDate target_date = LocalDate.of(year, month, 1);
        LookupDefaultListResult<CountOfPeriodVO> requestVO = getService.getConnectionCounts(target_date, PeriodIntervalType.DAY);
        return requestVO;
    }
}
