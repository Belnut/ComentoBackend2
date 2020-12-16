package com.mumuni.springboot_web.config;

/* 사용 보류,
* insert 같은 테이블을 하나만 사용할 경우 유용하나 그렇지 않는 경우는 애매하다고 생각됨
* 차라리 각 테이블에 일치하는 VO를 두고 거기에 TABLE 명, 컬럼 명을 두는 것이 적합하다고 생각함
* */
@Deprecated
public class DatabaseStatic {
    public static final String NAME_REQUESTHISTORY_TB = "REQUESTHISTORY_TB";
    public static final String NAME_TEAMINFO_TB = "TEANINFO_TB";
    public static final String NAME_USERINFO_TB = "USERINFO_TB";
    public static final String NAME_REQUESTCODEINFO_TB = "REQUESTCODEINFO_TB";
}
