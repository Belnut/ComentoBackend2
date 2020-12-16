package com.mumuni.springboot_web.rest_lookup.order;

import com.mumuni.springboot_web.rest_lookup.LookupDefaultListResultBase;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class LookupOrderDefaultListResultBase<T> extends LookupDefaultListResultBase<T> {
    @Builder
    public LookupOrderDefaultListResultBase(int resultCode, LocalDateTime requestTime, String order, int totalCount, List<T> data) {
        super(resultCode,requestTime,order,totalCount,data);
    }
}
