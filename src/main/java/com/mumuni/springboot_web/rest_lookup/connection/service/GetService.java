package com.mumuni.springboot_web.rest_lookup.connection.service;

import com.mumuni.springboot_web.rest_lookup._vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.ConnectionLookupBase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GetService {
    public ConnectionLookupBase<CountOfPeriodVO> getConnectionCountMonthly(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    public ConnectionLookupBase<CountOfPeriodVO> getConnectionCountDaily(LocalDate startDate, LocalDate endDate) {
        return null;
    }
}
