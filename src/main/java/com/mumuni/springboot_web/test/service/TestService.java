package com.mumuni.springboot_web.test.service;

import com.mumuni.springboot_web.dao.TestDAO;
import com.mumuni.springboot_web.test.DefaultTestResultBase;
import com.mumuni.springboot_web.test.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestDAO dao;

    public DefaultTestResultBase<TestVO> getAllUsers() {
        DefaultTestResultBase<TestVO> response;
        List<TestVO> data = dao.selectAllUsers();

        response = DefaultTestResultBase.<TestVO>builder()
                .resultCode(200)
                .requestTime(LocalDateTime.now())
                .count(data.size())
                .data(data)
                .build();

        return response;
    }
}
