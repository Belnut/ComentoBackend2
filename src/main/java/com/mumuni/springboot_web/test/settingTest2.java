package com.mumuni.springboot_web.test;

import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
import com.mumuni.springboot_web.test.vo.TestVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/rest_test")
public class settingTest2 {
    @RequestMapping("/getParameter")
    public String checkGetParameter(@RequestParam String startDate, String endDate) throws Exception {
        if(startDate == null) {
            return "check start Date";
        }
        return startDate + " -> " + endDate;
    }

    @RequestMapping("/getNowDate")
    public LocalDate getDate() throws Exception {
        return LocalDate.now();
    }

    @RequestMapping("/getNowDateTime")
    public LocalDateTime getDateTime() throws Exception {
        return LocalDateTime.now();
    }

    @RequestMapping("/getVO")
    public TestVO getVO() {
        List<Integer> x = new LinkedList<>();
        x.add(10);
        x.add(20);
        x.add(30);
        x.add(40);

        TestVO vo = TestVO.builder().count(x.size()).lists(x).build();
        return vo;
    }

    @RequestMapping("/getEnum")
    public PeriodIntervalType getEnum() {
        return PeriodIntervalType.DAY;
    }

}
