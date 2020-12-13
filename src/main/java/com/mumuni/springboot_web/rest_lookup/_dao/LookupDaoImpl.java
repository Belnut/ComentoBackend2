package com.mumuni.springboot_web.rest_lookup._dao;

import com.mumuni.springboot_web.rest_lookup._vo.CountOfPeriodVO;
import java.util.List;

public class LookupDaoImpl implements LookupDAO {

    @Override
    public Integer getOrderCount(String order, String startDate, String endDate, String filter) {
        return null;
    }

    @Override
    public List<CountOfPeriodVO> getOrderCountMonthly(String order, String startDate, String endDate, String filter) {
        return null;
    }

    @Override
    public List<CountOfPeriodVO> getOrderCountDaily(String order, String startDate, String endDate, String filter) {
        return null;
    }

    @Override
    public Double getOrderCountDailyAverage(String order, String startDate, String endDate, String filter) {
        return null;
    }
}
