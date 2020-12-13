package com.mumuni.springboot_web.rest_lookup.login.controller;

import com.mumuni.springboot_web.rest_lookup._vo.CountOfPeriodVO;
import com.mumuni.springboot_web.rest_lookup.login.LoginLookupBase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequiredArgsConstructor
@RestController
public class LoginLookUpRestController {
    //private final GetService getService;

    @GetMapping("/lookup/login/monthlyLoginCount")
    public LoginLookupBase<CountOfPeriodVO> loginCountLookupRequest(@PathVariable Date date) {
        LoginLookupBase<CountOfPeriodVO> requestVO=null;
        return requestVO;
    }
}
