package com.mumuni.springboot_web.rest_lookup.connection.controller;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.LookupConnectionDefaultResultBase;
import com.mumuni.springboot_web.rest_lookup.connection.service.ConnectionGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/connection")
public class LookupConnectionController {
    private final ConnectionGetService getService;

    @GetMapping("/monthlyConnectionCount")
    public LookupConnectionDefaultResultBase<CountOfPeriodVO> ConnectionCountMonthlyLookupRequest(
            @RequestParam Integer year) {
        LookupConnectionDefaultResultBase<CountOfPeriodVO> requestVO = getService.getConnectionCountMonthly(year);
        return requestVO;
    }

    @GetMapping("/dailyConnectionCount")
    LookupConnectionDefaultResultBase<CountOfPeriodVO> ConnectionCountDailyLookupRequest(
            @RequestParam Integer year, Integer month) {
        LookupConnectionDefaultResultBase<CountOfPeriodVO> requestVO = getService.getConnectionCountDaily(year, month);
        return requestVO;
    }
}
