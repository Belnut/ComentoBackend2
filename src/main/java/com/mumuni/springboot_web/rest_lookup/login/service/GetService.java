package com.mumuni.springboot_web.rest_lookup.login.service;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.login.LoginLookupBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class GetService {
    //private final LoginLookupDAO dao;

    //TODO : DAO 연결할 것
    public LoginLookupBase<CountOfPeriodVO> getLoginCountMonthly(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    public LoginLookupBase<CountOfPeriodVO> getLoginCountDaily(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    //TODO : 부서별 월별 조회 어떻게 만들지...? 아이디어가 너무 많음
}
