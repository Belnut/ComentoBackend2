package com.mumuni.springboot_web.rest_lookup.order.service;

import com.mumuni.springboot_web.dao.LookupMapper;
import com.mumuni.springboot_web.rest_lookup.LookupDefaultListResult;
import com.mumuni.springboot_web.rest_lookup.LookupDefaultSingleResult;
import com.mumuni.springboot_web.rest_lookup.type.DayType;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.vo.TeamListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderGetService {
    @Autowired
    private LookupMapper lookupMapper;

    public LookupDefaultSingleResult<HashMap<String, Long>> getOrderCount(String order ,List<DayType> exceptDays) {
        LookupDefaultSingleResult<HashMap<String, Long>> vo;
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("order", order);
            List<Integer> conv_exceptDays = exceptDays.stream().map(i -> i.getIntValue()).collect(Collectors.toList());
            map.put("exceptDays", conv_exceptDays);

            Long count = lookupMapper.getOrderCount(map);
            HashMap<String, Long> data = new HashMap<>();
            data.put("count", count);

            vo = LookupDefaultSingleResult.<HashMap<String, Long>>builder()
                    .resultCode(200)
                    .order(order)
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
            log.info("Success to run getOrderCount");
        } catch (DateTimeParseException e) {
            vo = LookupDefaultSingleResult.<HashMap<String, Long>>builder()
                    .resultCode(410)
                    .order(order)
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getOrderCount -> ", e);
        } catch (Exception e) {
            vo = LookupDefaultSingleResult.<HashMap<String, Long>>builder()
                    .resultCode(444)
                    .order(order)
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getOrderCount -> ", e);
        }

        return vo;
    }

    public LookupDefaultSingleResult<HashMap<String, Double>> getAverageCountPerDay(
            String order, String startDate, String endDate) {
        LookupDefaultSingleResult<HashMap<String, Double>> vo;
        try {
            LocalDate sDate = LocalDate.parse(startDate);
            LocalDate eDate = LocalDate.parse(endDate);

            HashMap<String, Object> map = new HashMap<>();
            map.put("order", order);
            map.put("startDate", sDate.toString());
            map.put("endDate", eDate.toString());

            Long count = lookupMapper.getOrderCount(map);
            long dayCount = ChronoUnit.DAYS.between(sDate, eDate);

            Double average = count / (double)dayCount;
            HashMap<String, Double> data = new HashMap<>();
            data.put("average", average);

            vo = LookupDefaultSingleResult.<HashMap<String, Double>>builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
            log.info("Success to run getAverageCountPerDay");
        } catch (DateTimeParseException e) {
            vo = LookupDefaultSingleResult.<HashMap<String, Double>>builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getAverageCountPerDay -> ", e);
        } catch (Exception e) {
            vo = LookupDefaultSingleResult.<HashMap<String, Double>>builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getAverageCountPerDay -> ", e);
        }
        return vo;
    }

    public LookupDefaultListResult<CountOfPeriodVO> getOrderCounts(
            String order, LocalDate date, PeriodIntervalType type) {
        LookupDefaultListResult<CountOfPeriodVO> vo;
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
                itr.next().setIntervalType(type);
            }

            vo = LookupDefaultListResult.<CountOfPeriodVO> builder()
                    .resultCode(200)
                    .order("connect")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
            log.info("Success to run getOrderCounts");
        }catch(DateTimeParseException e) {
            vo = LookupDefaultListResult.<CountOfPeriodVO> builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getOrderCounts -> ", e);
        }catch (Exception e) {
            vo = LookupDefaultListResult.<CountOfPeriodVO> builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getOrderCounts -> ", e);
        }
        return vo;
    }
    public LookupDefaultListResult<TeamListVO<CountOfPeriodVO>> getOrderCountsByTeam(
            String order, List<String> teamCodes, LocalDate date, PeriodIntervalType type) {
        LookupDefaultListResult<TeamListVO<CountOfPeriodVO>> vo;
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

            HashMap<String, Object> map = new HashMap<>();
            map.put("order", order);
            map.put("dateFormat", dateFormat);
            map.put("startDate", startDate.toString());
            map.put("endDate", endDate.toString());
            map.put("teamCodes", teamCodes);

            List<TeamListVO<CountOfPeriodVO>> data = lookupMapper.getOrderCountsByTeam(map);

            vo = LookupDefaultListResult.<TeamListVO<CountOfPeriodVO>>builder()
                    .resultCode(200)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(data)
                    .totalCount(data.size())
                    .build();
            log.info("Success to run getOrderCountsByTeam");
        } catch (DateTimeParseException e) {
            vo = LookupDefaultListResult.<TeamListVO<CountOfPeriodVO>>builder()
                    .resultCode(410)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getOrderCountsByTeam -> ", e);
        } catch (Exception e) {
            vo = LookupDefaultListResult.<TeamListVO<CountOfPeriodVO>>builder()
                    .resultCode(444)
                    .order("*")
                    .requestTime(LocalDateTime.now())
                    .data(null)
                    .totalCount(0)
                    .build();
            log.error("Fail to run getOrderCountsByTeam -> ", e);
        }
        return vo;
    }
}
