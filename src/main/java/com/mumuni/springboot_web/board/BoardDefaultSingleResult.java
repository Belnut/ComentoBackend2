package com.mumuni.springboot_web.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardDefaultSingleResult<T> extends BoardDefaultResultBase {
    private T data;
    @Builder
    public BoardDefaultSingleResult(int resultCode, LocalDateTime requestTime, String order, T data) {
        super(resultCode, requestTime, order);
        this.data = data;
    }
}
