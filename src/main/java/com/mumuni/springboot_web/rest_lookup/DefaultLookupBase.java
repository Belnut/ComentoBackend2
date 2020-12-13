package com.mumuni.springboot_web.rest_lookup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter @AllArgsConstructor
public abstract class DefaultLookupBase <T>{
    private int resultCode;
    private LocalDateTime requestTime;
    private String order;
    private int count;
    private List<T> data;
}