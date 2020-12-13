package com.mumuni.springboot_web.rest_lookup._dao;

import com.mumuni.springboot_web.rest_lookup._vo.CountOfPeriodVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookupDAO {
    public Integer getOrderCount(String order, String startDate, String endDate, String filter);

    public List<CountOfPeriodVO> getOrderCountMonthly(String order, String startDate, String endDate, String filter);
    public List<CountOfPeriodVO> getOrderCountDaily(String order, String startDate, String endDate, String filter);

    public Double getOrderCountDailyAverage(String order, String startDate, String endDate, String filter);
}
