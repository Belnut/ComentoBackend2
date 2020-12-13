package com.mumuni.springboot_web.rest_lookup.connection.service;

import com.mumuni.springboot_web.dao.LookupMapper;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.ConnectionLookupBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ConnectionGetService {

    @Autowired
    private LookupMapper lookupDAO;

    //TODO: 질문1: Builder를 이렇게 사용해도 괜찮은가요?
    public ConnectionLookupBase<CountOfPeriodVO> getConnectionCountMonthly(int year) {
        ConnectionLookupBase<CountOfPeriodVO> vo;
        try {
            LocalDate sDate = LocalDate.of(year, 1,1);
            LocalDate eDate = LocalDate.of(year+1, 1,1);

            HashMap<String,String> map = new HashMap<>();
            map.put("startDate", sDate.toString());
            map.put("endDate", eDate.toString());
            List<CountOfPeriodVO> data = lookupDAO.getConnectionCountMonthly(map);

            Iterator<CountOfPeriodVO> itr = data.iterator();
            while(itr.hasNext()) {
                itr.next().setIntervalType(PeriodIntervalType.MONTH);
            }

            vo = ConnectionLookupBase.<CountOfPeriodVO> builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .count(data.size())
                    .build();
        }catch(DateTimeParseException e) {
            vo = ConnectionLookupBase.<CountOfPeriodVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .count(0)
                    .build();
        }catch (Exception e) {
            vo = ConnectionLookupBase.<CountOfPeriodVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .count(0)
                    .build();
        }

        return vo;
    }

    public ConnectionLookupBase<CountOfPeriodVO> getConnectionCountDaily
            (int year, int month) {
        ConnectionLookupBase<CountOfPeriodVO> vo;
        try {
            LocalDate sDate = LocalDate.of(year, month,1);
            LocalDate eDate = LocalDate.of(year, month+1,1);

            HashMap<String,String> map = new HashMap<>();
            map.put("startDate", sDate.toString());
            map.put("endDate", eDate.toString());
            List<CountOfPeriodVO> data = lookupDAO.getConnectionCountMonthly(map);

            Iterator<CountOfPeriodVO> itr = data.iterator();
            while(itr.hasNext()) {
                itr.next().setIntervalType(PeriodIntervalType.DAY);
            }

            vo = ConnectionLookupBase.<CountOfPeriodVO> builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .count(data.size())
                    .build();
        }catch(DateTimeParseException e) {
            vo = ConnectionLookupBase.<CountOfPeriodVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .count(0)
                    .build();
        }catch (Exception e) {
            vo = ConnectionLookupBase.<CountOfPeriodVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .count(0)
                    .build();
        }

        return vo;
    }
}
