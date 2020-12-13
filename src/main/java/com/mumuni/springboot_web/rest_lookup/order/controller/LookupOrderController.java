package com.mumuni.springboot_web.rest_lookup.order.controller;

import com.mumuni.springboot_web.rest_lookup.order.service.OrderGetService;
import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.order.LookupOrderDefaultResultBase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/order")
public class LookupOrderController {
    private final OrderGetService getService;

    @GetMapping("{order}/CountExceptWeeeked")
    public LookupOrderDefaultResultBase<HashMap<String, Long>> orderCountExceptWeekendRequest
            (@PathVariable("order") String order) {
        LookupOrderDefaultResultBase<HashMap<String, Long>> requestVO = getService.getOrderCountExceptWeekend(order);
        return requestVO;
    }

    @GetMapping("{order}/AveragePerDay")
    public LookupOrderDefaultResultBase<HashMap<String, Double>> orderAverageCountPerDay
            (@PathVariable("order") String order,
             @RequestParam(value = "startDate", required = true ) String startDate,
             @RequestParam(value = "endDate", required = false ) String endDate) {
        if(endDate == null) endDate = LocalDate.now().toString();
        LookupOrderDefaultResultBase<HashMap<String, Double>> requestVO = getService.getAverageCountOfOrderPerDay(order, startDate, endDate);
        return requestVO;
    }
}
