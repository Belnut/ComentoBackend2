package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.vo.FreeBoardVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository @Mapper
public interface BoardMapper {
    @Insert({
            "INSERT INTO `FREEBOARD_TB` ",
            "(`ID`, `TITLE`, `USERID`, `CONTENT`, `CREATE_DATE`, `UPDATE_DATE`)",
            "VALUES ( null,'${title}', '${author.user_id}', '${content}', NOW(), NOW())"
    })
    @SelectKey(statement ="SELECT LAST_INSERT_ID()", keyProperty="id", keyColumn = "ID", before = false, resultType=int.class)
    int insertPost(FreeBoardVO vo);

    @Update({
            "UPDATE `FREEBOARD_TB` ",
            "SET `TITLE` = '${title}', `CONTENT` = '${content}', `UPDATE_DATE` = NOW() WHERE (`ID` = ${id} AND `USERID` = '${author.user_id}')"
    })
    @Options(useGeneratedKeys=true, keyProperty = "id")
    int updatePost(FreeBoardVO vo);

    @Delete({
            "DELETE FROM `FREEBOARD_TB` ",
            "WHERE `ID` = ${id} AND `USERID` = '${author.user_id}'"
    })
    @Options(useGeneratedKeys=true, keyProperty = "id")
    int deletePost(FreeBoardVO vo);

    FreeBoardVO selectPost(long id);
}
