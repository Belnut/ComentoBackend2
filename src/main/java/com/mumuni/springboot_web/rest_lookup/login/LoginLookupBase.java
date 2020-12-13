package com.mumuni.springboot_web.rest_lookup.login;

import com.mumuni.springboot_web.rest_lookup.DefaultLookupBase;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class LoginLookupBase<T> extends DefaultLookupBase<T> {
    @Builder
    public LoginLookupBase(int resultCode, LocalDateTime requestTime, String order, int count, List<T> data) {
        super(resultCode,requestTime,order,count,data);
    }
}
