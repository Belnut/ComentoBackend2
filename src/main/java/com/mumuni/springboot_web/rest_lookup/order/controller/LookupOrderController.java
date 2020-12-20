package com.mumuni.springboot_web.rest_lookup.order.controller;

import com.mumuni.springboot_web.rest_lookup.LookupDefaultListResult;
import com.mumuni.springboot_web.rest_lookup.LookupDefaultSingleResult;
import com.mumuni.springboot_web.rest_lookup.order.service.OrderGetService;
import com.mumuni.springboot_web.rest_lookup.type.DayType;
import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.vo.TeamListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/{order}")
public class LookupOrderController {
    private final OrderGetService getService;

    @GetMapping("count")
    public LookupDefaultSingleResult<HashMap<String, Long>> orderCount
            (@PathVariable("order") String order,
             @RequestParam(value="except_days", required = false, defaultValue = "null") List<DayType> exceptDays)  {
        return getService.getOrderCount(order, exceptDays);
    }

    @GetMapping("average/daily")
    public LookupDefaultSingleResult<HashMap<String, Double>> orderAverageCountPerDay
            (@PathVariable("order") String order,
             @RequestParam(value = "start_date", required = true ) String startDate,
             @RequestParam(value = "end_date", required = false ) String endDate) {
        if(endDate == null) endDate = LocalDate.now().toString();
        LookupDefaultSingleResult<HashMap<String, Double>> requestVO = getService.getAverageCountPerDay(order, startDate, endDate);
        return requestVO;
    }

    @GetMapping("count/monthly")
    public LookupDefaultListResult<? extends Object> orderCountMonthly
            (@PathVariable("order") String order,
             @RequestParam Integer year,
             @RequestParam(value = "team_codes", required = false) List<String> teamCodes) {
        LocalDate target_date = LocalDate.of(year, 1, 1);

        if(teamCodes!= null) {
            LookupDefaultListResult<TeamListVO<CountOfPeriodVO>>
                    requestVO = getService.getOrderCountsByTeam(order, teamCodes, target_date, PeriodIntervalType.MONTH);
            return requestVO;
        }
        else {
            LookupDefaultListResult<CountOfPeriodVO>
                    requestVO = getService.getOrderCounts(order ,target_date, PeriodIntervalType.MONTH);
            return requestVO;
        }
    }
}
