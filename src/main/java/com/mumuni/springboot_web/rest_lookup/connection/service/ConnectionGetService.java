package com.mumuni.springboot_web.rest_lookup.connection.service;

import com.mumuni.springboot_web.dao.LookupMapper;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.LookupConnectionDefaultResultBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class ConnectionGetService {

    @Autowired
    private LookupMapper lookupMapper;

    //TODO: 질문1: Builder를 이렇게 사용해도 괜찮은가요?
    public LookupConnectionDefaultResultBase<CountOfPeriodVO> getConnectionCountMonthly(int year) {
        LookupConnectionDefaultResultBase<CountOfPeriodVO> vo;
        try {
            LocalDate sDate = LocalDate.of(year, 1,1);
            LocalDate eDate = LocalDate.of(year+1, 1,1);

            HashMap<String,String> map = new HashMap<>();
            map.put("startDate", sDate.toString());
            map.put("endDate", eDate.toString());
            List<CountOfPeriodVO> data = lookupMapper.getConnectionCountMonthly(map);

            Iterator<CountOfPeriodVO> itr = data.iterator();
            while(itr.hasNext()) {
                itr.next().setIntervalType(PeriodIntervalType.MONTH);
            }

            vo = LookupConnectionDefaultResultBase.<CountOfPeriodVO> builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
        }catch(DateTimeParseException e) {
            vo = LookupConnectionDefaultResultBase.<CountOfPeriodVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        }catch (Exception e) {
            vo = LookupConnectionDefaultResultBase.<CountOfPeriodVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        }

        return vo;
    }

    public LookupConnectionDefaultResultBase<CountOfPeriodVO> getConnectionCountDaily
            (int year, int month) {
        LookupConnectionDefaultResultBase<CountOfPeriodVO> vo;
        try {
            LocalDate sDate = LocalDate.of(year, month,1);
            LocalDate eDate = LocalDate.of(year, month+1,1);

            HashMap<String,String> map = new HashMap<>();
            map.put("startDate", sDate.toString());
            map.put("endDate", eDate.toString());
            List<CountOfPeriodVO> data = lookupMapper.getConnectionCountDaily(map);

            Iterator<CountOfPeriodVO> itr = data.iterator();
            while(itr.hasNext()) {
                itr.next().setIntervalType(PeriodIntervalType.DAY);
            }

            vo = LookupConnectionDefaultResultBase.<CountOfPeriodVO> builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
        }catch(DateTimeParseException e) {
            vo = LookupConnectionDefaultResultBase.<CountOfPeriodVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        }catch (Exception e) {
            vo = LookupConnectionDefaultResultBase.<CountOfPeriodVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        }

        return vo;
    }
}
