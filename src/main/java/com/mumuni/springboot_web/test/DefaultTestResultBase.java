package com.mumuni.springboot_web.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder @Getter @Setter
public class DefaultTestResultBase<T>{
    private int resultCode;
    private LocalDateTime requestTime;
    private int totalCount;
    private List<T> data;
}
