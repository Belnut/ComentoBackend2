package com.mumuni.springboot_web.rest_lookup.order.controller;

import com.mumuni.springboot_web.rest_lookup.order.service.OrderGetService;
import com.mumuni.springboot_web.rest_lookup.order.LookupOrderDefaultListResultBase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest_lookup/order")
public class LookupOrderController {
    private final OrderGetService getService;

    @GetMapping("{order}/Count")
    public LookupOrderDefaultListResultBase<HashMap<String, Long>> orderCountExceptWeekendRequest
            (@PathVariable("order") String order,
             @RequestParam(value="except_weekend", required = false, defaultValue = "false") boolean exceptWeekend )  {
        return getService.getOrderCount(order, exceptWeekend);
    }

    @GetMapping("{order}/AveragePerDay")
    public LookupOrderDefaultListResultBase<HashMap<String, Double>> orderAverageCountPerDay
            (@PathVariable("order") String order,
             @RequestParam(value = "startDate", required = true ) String startDate,
             @RequestParam(value = "endDate", required = false ) String endDate) {
        if(endDate == null) endDate = LocalDate.now().toString();
        LookupOrderDefaultListResultBase<HashMap<String, Double>> requestVO = getService.getAverageCountOfOrderPerDay(order, startDate, endDate);
        return requestVO;
    }
}
