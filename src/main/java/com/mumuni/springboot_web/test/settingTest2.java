package com.mumuni.springboot_web.test;

import com.mumuni.springboot_web.rest_lookup.type.PeriodIntervalType;
//import com.mumuni.springboot_web.test.service.TestService;
import com.mumuni.springboot_web.rest_lookup.vo.TeamVO;
import com.mumuni.springboot_web.test.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/rest_test")
public class settingTest2 {
//    @Autowired
//    private TestService testService;

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

    @RequestMapping("/getEnum")
    public PeriodIntervalType getEnum() {
        return PeriodIntervalType.DAY;
    }

    @RequestMapping("/getTeamVOByBody")
    public TeamVO getTeamVOByBody (@RequestBody TeamVO input) {
        return input;
    }

}
