package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public TestModel getById(Integer id) {
        return testMapper.getById(id);
    }

    public List<TestModel> findAll() {
        return testMapper.findAll();
    }
}
