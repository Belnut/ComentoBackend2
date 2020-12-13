package com.mumuni.springboot_web.rest_lookup.connection.controller;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.ConnectionLookupBase;
import com.mumuni.springboot_web.rest_lookup.connection.service.ConnectionGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/connection")
public class LookupConnectionController {
    private final ConnectionGetService getService;

    @GetMapping("monthlyConnectionCount")
    public ConnectionLookupBase<CountOfPeriodVO> ConnectionCountMonthlyLookupRequest(
            @RequestParam Integer year) {
        ConnectionLookupBase<CountOfPeriodVO> requestVO = getService.getConnectionCountMonthly(year);
        return requestVO;
    }

    @GetMapping("dailyConnectionCount")
    ConnectionLookupBase<CountOfPeriodVO> ConnectionCountDailyLookupRequest(
            @RequestParam Integer year, Integer month) {
        ConnectionLookupBase<CountOfPeriodVO> requestVO = getService.getConnectionCountDaily(year, month);
        return requestVO;
    }
}
