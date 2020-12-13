package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;

import java.time.LocalDate;
import java.util.List;

public interface LookupDAO {
    public Integer getOrderCount(String order, LocalDate startDate, LocalDate endDate, String filter);

    public List<CountOfPeriodVO> getOrderCountMonthly(String order, LocalDate startDate, LocalDate endDate, String filter);
    public List<CountOfPeriodVO> getOrderCountDaily(String order, LocalDate startDate, LocalDate endDate, String filter);

    public List<CountOfPeriodVO> getConnectionCountMonthly(String order, LocalDate startDate, LocalDate endDate, String fileer);
    public List<CountOfPeriodVO> getConnectionCountDaily(String order, LocalDate startDate, LocalDate endDate, String fileer);

    public Double getOrderCountDailyAverage(String order, LocalDate startDate, LocalDate endDate, String filter);
}
