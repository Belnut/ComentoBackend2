package com.mumuni.springboot_web.rest_lookup.order.service;

import com.mumuni.springboot_web.dao.LookupMapper;
import com.mumuni.springboot_web.rest_lookup.connection.LookupConnectionDefaultResultBase;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.order.LookupOrderDefaultResultBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderGetService {
    private final LookupMapper lookupMapper;

    //TODO : DAO 연결할 것
    public LookupOrderDefaultResultBase<HashMap<String, Long>> getOrderCountExceptWeekend(String order) {
        LookupOrderDefaultResultBase<HashMap<String, Long>> vo;
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("order", order);

            Long count = lookupMapper.getOrderCountExceptWeekend(map);
            List<HashMap<String, Long>> data = new LinkedList<>();
            HashMap<String, Long> hm = new HashMap<>();
            hm.put("count", count);
            data.add(hm);

            vo = LookupOrderDefaultResultBase.<HashMap<String, Long>>builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
        } catch (DateTimeParseException e) {
            vo = LookupOrderDefaultResultBase.<HashMap<String, Long>>builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        } catch (Exception e) {
            vo = LookupOrderDefaultResultBase.<HashMap<String, Long>>builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        }

        return vo;
    }

    public LookupOrderDefaultResultBase<HashMap<String, Double>> getAverageCountOfOrderPerDay(
            String order, String startDate, String endDate) {
        LookupOrderDefaultResultBase<HashMap<String, Double>> vo;
        try {
            LocalDate sDate = LocalDate.parse(startDate);
            LocalDate eDate = LocalDate.parse(endDate);

            HashMap<String, String> map = new HashMap<>();
            map.put("order", order);
            map.put("startDate", sDate.toString());
            map.put("endDate", eDate.toString());

            Long count = lookupMapper.getOrderCount(map);
            long dayCount = ChronoUnit.DAYS.between(sDate, eDate);

            Double average = count / (double)dayCount;
            List<HashMap<String, Double>> data = new LinkedList<>();
            HashMap<String, Double> hm = new HashMap<>();
            hm.put("average", average);
            data.add(hm);

            vo = LookupOrderDefaultResultBase.<HashMap<String, Double>>builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
        } catch (DateTimeParseException e) {
            vo = LookupOrderDefaultResultBase.<HashMap<String, Double>>builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        } catch (Exception e) {
            vo = LookupOrderDefaultResultBase.<HashMap<String, Double>>builder()
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
