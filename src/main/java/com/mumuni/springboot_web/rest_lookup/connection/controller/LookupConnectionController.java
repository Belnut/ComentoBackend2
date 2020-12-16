package com.mumuni.springboot_web.rest_lookup.connection.controller;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.LookupConnectionDefaultListResultBase;
import com.mumuni.springboot_web.rest_lookup.connection.service.ConnectionGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/connection")
public class LookupConnectionController {
    private final ConnectionGetService getService;

    @GetMapping("/monthlyConnectionCount")
    public LookupConnectionDefaultListResultBase<CountOfPeriodVO> ConnectionCountMonthlyLookupRequest(
            @RequestParam Integer year) {
        LookupConnectionDefaultListResultBase<CountOfPeriodVO> requestVO = getService.getConnectionCountMonthly(year);
        return requestVO;
    }

    @GetMapping("/dailyConnectionCount")
    LookupConnectionDefaultListResultBase<CountOfPeriodVO> ConnectionCountDailyLookupRequest(
            @RequestParam Integer year, Integer month) {
        LookupConnectionDefaultListResultBase<CountOfPeriodVO> requestVO = getService.getConnectionCountDaily(year, month);
        return requestVO;
    }
}
