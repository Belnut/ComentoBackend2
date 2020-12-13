package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.test.vo.TestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestDAO {
    protected static final String NAMESPACE = "com.mumuni.springboot_web.hello.";

    @Autowired
    private SqlSession sqlSession;

    public List<TestVO> selectAllUsers(){
        Map<String, String> map = new HashMap<>();
        map.put("userName", "tester4");
        return sqlSession.selectList(NAMESPACE + "selectAllUsers", map);
    }
}
