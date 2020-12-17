package com.mumuni.springboot_web.rest_lookup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class LookupDefaultSingleResult<T> extends LookupDefaultResultBase{
    private T data;
    @Builder
    public LookupDefaultSingleResult(int resultCode, LocalDateTime requestTime, String order, int totalCount, T data) {
        super(resultCode, requestTime, order, totalCount);
        this.data = data;
    }
}
