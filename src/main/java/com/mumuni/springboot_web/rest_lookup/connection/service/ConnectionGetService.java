package com.mumuni.springboot_web.rest_lookup.connection.service;

import com.mumuni.springboot_web.dao.LookupMapper;
import com.mumuni.springboot_web.rest_lookup.LookupDefaultListResult;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ConnectionGetService {

    @Autowired
    private LookupMapper lookupMapper;

    //TODO: 질문1: Builder를 이렇게 사용해도 괜찮은가요?
    public LookupDefaultListResult<CountOfPeriodVO>
    getConnectionCounts(LocalDate date, PeriodIntervalType type) {
        LookupDefaultListResult<CountOfPeriodVO> vo;
        PeriodIntervalType period = type;
        String dateFormat;
        try {
            LocalDate startDate, endDate;
            switch(type) {
                case MONTH:
                    startDate = date.withMonth(1).withDayOfMonth(1);
                    endDate = date.plusYears(1).withMonth(1).withDayOfMonth(1);
                    dateFormat = "%Y-%m";
                    break;
                case DAY:
                    startDate = date.withDayOfMonth(1);
                    endDate = date.plusMonths(1).withDayOfMonth(1);
                    dateFormat = "%Y-%m-%d";
                    break;
                default:
                    throw new Exception("Unknown PeriodIntervalType : " + type);
            }

            HashMap<String,Object> map = new HashMap<>();
            map.put("startDate", startDate.toString());
            map.put("endDate", endDate.toString());
            map.put("dateFormat", dateFormat);

            List<CountOfPeriodVO> data = lookupMapper.getConnectionCounts(map);

            Iterator<CountOfPeriodVO> itr = data.iterator();
            while(itr.hasNext()) {
                itr.next().setIntervalType(PeriodIntervalType.MONTH);
            }

            vo = LookupDefaultListResult.<CountOfPeriodVO> builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
            log.info("Success to run getConnectionCountMonthly");
        }catch(DateTimeParseException e) {
            vo = LookupDefaultListResult.<CountOfPeriodVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getConnectionCountMonthly -> ", e);
        }catch (Exception e) {
            vo = LookupDefaultListResult.<CountOfPeriodVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getConnectionCountMonthly -> ", e);
        }
        return vo;
    }
}
