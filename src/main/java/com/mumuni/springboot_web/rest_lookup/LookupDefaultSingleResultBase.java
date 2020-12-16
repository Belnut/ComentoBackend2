package com.mumuni.springboot_web.rest_lookup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class LookupDefaultSingleResultBase<T> extends LookupDefaultResultBase{
    private T data;
    public LookupDefaultSingleResultBase(int resultCode, LocalDateTime requestTime, String order, int totalCount, T data) {
        super(resultCode, requestTime, order, totalCount);
        this.data = data;
    }
}
