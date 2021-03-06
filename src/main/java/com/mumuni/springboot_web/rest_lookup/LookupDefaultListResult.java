package com.mumuni.springboot_web.rest_lookup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter
public class LookupDefaultListResult<T> extends LookupDefaultResultBase{
    private List<T> data;
    @Builder
    public LookupDefaultListResult(int resultCode, LocalDateTime requestTime, String order, int totalCount, List<T> data) {
        super(resultCode, requestTime, order, totalCount);
        this.data = data;
    }
}