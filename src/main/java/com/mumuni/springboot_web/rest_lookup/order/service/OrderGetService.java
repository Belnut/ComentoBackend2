package com.mumuni.springboot_web.rest_lookup.order.service;

import com.mumuni.springboot_web.dao.LookupMapper;
import com.mumuni.springboot_web.rest_lookup.order.LookupOrderDefaultListResultBase;
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
    public LookupOrderDefaultListResultBase<HashMap<String, Long>> getOrderCount(String order, boolean exceptWeekend) {
        LookupOrderDefaultListResultBase<HashMap<String, Long>> vo;
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("order", order);
            if(exceptWeekend) map.put("execptWeeked", exceptWeekend);

            Long count = lookupMapper.getOrderCountExceptWeekend(map);
            List<HashMap<String, Long>> data = new LinkedList<>();
            HashMap<String, Long> hm = new HashMap<>();
            hm.put("count", count);

            data.add(hm);

            vo = LookupOrderDefaultListResultBase.<HashMap<String, Long>>builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
        } catch (DateTimeParseException e) {
            vo = LookupOrderDefaultListResultBase.<HashMap<String, Long>>builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        } catch (Exception e) {
            vo = LookupOrderDefaultListResultBase.<HashMap<String, Long>>builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        }

        return vo;
    }

    public LookupOrderDefaultListResultBase<HashMap<String, Double>> getAverageCountOfOrderPerDay(
            String order, String startDate, String endDate) {
        LookupOrderDefaultListResultBase<HashMap<String, Double>> vo;
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

            vo = LookupOrderDefaultListResultBase.<HashMap<String, Double>>builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
        } catch (DateTimeParseException e) {
            vo = LookupOrderDefaultListResultBase.<HashMap<String, Double>>builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
        } catch (Exception e) {
            vo = LookupOrderDefaultListResultBase.<HashMap<String, Double>>builder()
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
