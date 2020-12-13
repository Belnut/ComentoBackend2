package com.mumuni.springboot_web.dao;

import com.mumuni.springboot_web.rest_lookup.vo.CountOfPeriodVO;
import com.mumuni.springboot_web.test.vo.TestVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    TODO: 질문: DAO를 여러개 사용해도 되는가? 그런 경우가 있는가?
    의문 해소시 삭제

    protected static final String NAMESPACE = "com.mumuni.springboot_web.hello.";

    @Autowired
    private SqlSession sqlSession;

    public List<TestVO> selectAllUsers(){
        return sqlSession.selectList(NAMESPACE + "selectAllUsers");
    }

 */

@Repository
public class LookupDaoImpl implements LookupDAO {
    protected static final String NAMESPACE = "com.mumuni.springboot_web.lookup.";

    @Autowired
    private SqlSession sqlSession;

    public List<TestVO> selectAllUsers(){
        return sqlSession.selectList(NAMESPACE + "selectAllUsers");
    }

    @Override
    public Integer getOrderCount(String order, LocalDate startDate, LocalDate endDate, String filter) {
        return null;
    }

    @Override
    public List<CountOfPeriodVO> getOrderCountMonthly(String order, LocalDate startDate, LocalDate endDate, String filter) {
        return null;
    }

    @Override
    public List<CountOfPeriodVO> getOrderCountDaily(String order, LocalDate startDate, LocalDate endDate, String filter) {
        return null;
    }

    @Override
    public List<CountOfPeriodVO> getConnectionCountMonthly(String order, LocalDate startDate, LocalDate endDate, String fileer) {
        return sqlSession.selectList(NAMESPACE + "selectAllUsers"  );
    }

    @Override
    public List<CountOfPeriodVO> getConnectionCountDaily(String order, LocalDate startDate, LocalDate endDate, String fileer) {
        return null;
    }

    @Override
    public Double getOrderCountDailyAverage(String order, LocalDate startDate, LocalDate endDate, String filter) {
        return null;
    }
}
