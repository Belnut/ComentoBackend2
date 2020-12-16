package com.mumuni.springboot_web.rest_lookup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter @AllArgsConstructor
public abstract class LookupDefaultResultBase{
    private int resultCode;
    private LocalDateTime requestTime;
    private String order;
    private int totalCount;
}
