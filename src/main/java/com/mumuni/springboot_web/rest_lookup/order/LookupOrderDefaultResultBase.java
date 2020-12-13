package com.mumuni.springboot_web.rest_lookup.order;

import com.mumuni.springboot_web.rest_lookup.LookupDefaultResultBase;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class LookupOrderDefaultResultBase<T> extends LookupDefaultResultBase<T> {
    @Builder
    public LookupOrderDefaultResultBase(int resultCode, LocalDateTime requestTime, String order, int totalCount, List<T> data) {
        super(resultCode,requestTime,order,totalCount,data);
    }
}
