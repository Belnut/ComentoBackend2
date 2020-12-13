package com.mumuni.springboot_web.rest_lookup;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter
public abstract class DefaultLookupBase <T>{
    private int resultCode;
    private LocalDateTime requestTime;
    private String order;
    private int count;
    private List<T> data;
}