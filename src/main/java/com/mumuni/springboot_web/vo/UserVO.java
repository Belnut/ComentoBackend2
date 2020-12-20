package com.mumuni.springboot_web.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter
@NoArgsConstructor
public class UserVO {
    private String user_id;
    private String user_name;

    public UserVO(UserVO vo) {
        user_id = vo.user_id;
        user_name = vo.user_name;
    }
}
