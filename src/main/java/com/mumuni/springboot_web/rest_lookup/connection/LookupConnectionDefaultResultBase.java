package com.mumuni.springboot_web.rest_lookup.connection;


import com.mumuni.springboot_web.rest_lookup.LookupDefaultResultBase;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;


public class LookupConnectionDefaultResultBase<T> extends LookupDefaultResultBase<T> {

    @Builder
    public LookupConnectionDefaultResultBase(int resultCode, LocalDateTime requestTime, String order, int totalCount, List<T>data) {
        super(resultCode,requestTime,order,totalCount,data);
    }
}
