package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface LookupMapper {

    List<CountOfPeriodVO> getConnectionCountMonthly(Map<String, Object> map);
    List<CountOfPeriodVO> getConnectionCountDaily(Map<String, String> map);

    //List<CountOfPeriodVO> getOrderCountMonthly(Map<String, String> map);
    //List<CountOfPeriodVO> getOrderCountDaily(Map<String, String> map);

    Long getOrderCount(Map<String, Object> map);
    List<CountOfPeriodVO> getOrderCountByTeam(Map<String, Object> map);
}
