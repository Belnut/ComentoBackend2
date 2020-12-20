package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.vo.TeamListVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository @Mapper
public interface LookupMapper {

    // List Type
    List<CountOfPeriodVO> getConnectionCounts(Map<String, Object> map);
    List<CountOfPeriodVO> getOrderCounts(Map<String, Object> map);
    List<TeamListVO<CountOfPeriodVO>> getOrderCountsByTeam(Map<String, Object> map);
    //Single Type
    Long getOrderCount(Map<String, Object> map);
}
