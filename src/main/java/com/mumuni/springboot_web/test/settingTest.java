package com.mumuni.springboot_web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class settingTest {

    @RequestMapping("/test")
    public ModelAndView test() throws Exception {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "mumuni");
        List<String> resultList = new ArrayList<>();

        resultList.add("Hello World!");
        resultList.add("Hello World!!!");
        resultList.add("Hello World!!!!");
        resultList.add("Hello World!!!!!");
        resultList.add("Hello World!!!!!!");

        mav.addObject("list", resultList);

        return mav;
    }

}
