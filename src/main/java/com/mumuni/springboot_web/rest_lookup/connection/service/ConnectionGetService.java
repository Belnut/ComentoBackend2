package com.mumuni.springboot_web.rest_lookup.connection.service;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.connection.ConnectionLookupBase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Service
public class ConnectionGetService {
    //private final LookupDAO lookupDAO;

    public ConnectionLookupBase<CountOfPeriodVO> getConnectionCountMonthly(int year) {
        ConnectionLookupBase<CountOfPeriodVO> vo = new ConnectionLookupBase<>();
        vo.setRequestTime(LocalDateTime.now());

        try {
            LocalDate sDate = LocalDate.of(year, 1,1);
            LocalDate eDate = LocalDate.of(year+1, 1,1);
            //List<CountOfPeriodVO> data = lookupDAO.getConnectionCountMonthly("*", sDate, eDate, null);
            //vo.setCount(data.size());
            //vo.setData(data);
        }catch(DateTimeParseException e) {
            vo.setResultCode(410);
            vo.setOrder("*");
            vo.setData(null);
        }catch (Exception e) {
            vo.setResultCode(444);
            vo.setOrder("*");
            vo.setData(null);
        }

        return vo;
    }

    public ConnectionLookupBase<CountOfPeriodVO> getConnectionCountDaily(String startDate, String endDate) {
        return null;
    }
}
