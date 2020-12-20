package com.mumuni.springboot_web.rest_lookup.vo;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter @Setter
@NoArgsConstructor
public class TeamVO {
    private String team_code;
    private String team_name;

    public TeamVO (TeamVO t) {
        team_code = t.team_code;
        team_name = t.team_name;
    }
}
