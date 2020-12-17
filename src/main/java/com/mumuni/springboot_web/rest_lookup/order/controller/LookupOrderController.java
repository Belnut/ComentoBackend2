package com.mumuni.springboot_web.rest_lookup.order.controller;

import com.mumuni.springboot_web.rest_lookup.LookupDefaultSingleResult;
import com.mumuni.springboot_web.rest_lookup.order.service.OrderGetService;
import com.mumuni.springboot_web.rest_lookup.type.DayType;
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

    @GetMapping("averagePerDay")
    public LookupDefaultSingleResult<HashMap<String, Double>> orderAverageCountPerDay
            (@PathVariable("order") String order,
             @RequestParam(value = "startDate", required = true ) String startDate,
             @RequestParam(value = "endDate", required = false ) String endDate) {
        if(endDate == null) endDate = LocalDate.now().toString();
        LookupDefaultSingleResult<HashMap<String, Double>> requestVO = getService.getAverageCountPerDay(order, startDate, endDate);
        return requestVO;
    }
}
