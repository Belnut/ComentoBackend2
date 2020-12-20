package com.mumuni.springboot_web.rest_lookup.vo;

import com.mumuni.springboot_web.vo.TeamVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TeamListVO<T> extends TeamVO {
    List<T> data;
}
