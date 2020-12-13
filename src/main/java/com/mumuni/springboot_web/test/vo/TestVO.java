package com.mumuni.springboot_web.test.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter @Setter @ToString
public class TestVO {
    private int count;
    private List<Integer> lists;
}
