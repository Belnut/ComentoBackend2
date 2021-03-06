package com.mumuni.springboot_web.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter @AllArgsConstructor
public abstract class BoardDefaultResultBase{
    private int resultCode;
    private LocalDateTime requestTime;
    private String order;
}
