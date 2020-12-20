package com.mumuni.springboot_web.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FreeBoardVO {
    private Long id;
    private String title;
    private UserVO author;
    private String content;
}
