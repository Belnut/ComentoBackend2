package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface LookupMapper {
//    public Integer getOrderCount(String order, LocalDate startDate, LocalDate endDate, String filter);
//
    List<CountOfPeriodVO> getOrderCountDaily(Map<String, String> map);
    List<CountOfPeriodVO> getOrderCountMonthly(Map<String, String> map);

    List<CountOfPeriodVO> getConnectionCountMonthly(Map<String, String> map);
    List<CountOfPeriodVO> getConnectionCountDaily(Map<String, String> map);
//
//    public Double getOrderCountDailyAverage(String order, LocalDate startDate, LocalDate endDate, String filter);
}
