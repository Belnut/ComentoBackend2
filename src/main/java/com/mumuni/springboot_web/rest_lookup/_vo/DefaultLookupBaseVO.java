package com.mumuni.springboot_web.rest_lookup._vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter @Setter
public abstract class DefaultLookupBaseVO <T>{
    private int resultCode;
    private String requestLog;
    private List<T> data;
}