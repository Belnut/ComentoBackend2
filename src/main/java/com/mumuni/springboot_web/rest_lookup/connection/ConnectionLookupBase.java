package com.mumuni.springboot_web.rest_lookup.connection;


import com.mumuni.springboot_web.rest_lookup.DefaultLookupBase;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


public class ConnectionLookupBase<T> extends DefaultLookupBase<T> {

    @Builder
    public ConnectionLookupBase(int resultCode,LocalDateTime requestTime, String order,int count, List<T>data) {
        super(resultCode,requestTime,order,count,data);
    }
}
