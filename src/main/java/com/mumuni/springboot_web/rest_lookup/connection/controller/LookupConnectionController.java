package com.mumuni.springboot_web.rest_lookup.connection.controller;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.ConnectionLookupBase;
import com.mumuni.springboot_web.rest_lookup.connection.service.ConnectionGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/connect")
public class LookupConnectionController {
    private final ConnectionGetService getService;

    @GetMapping("/lookup/login/monthlyLoginCount")
    public ConnectionLookupBase<CountOfPeriodVO> ConnectionCountMonthlyLookupRequest(
            @PathVariable Integer year) {
        ConnectionLookupBase<CountOfPeriodVO> requestVO = getService.getConnectionCountMonthly(year);
        return requestVO;
    }
}
