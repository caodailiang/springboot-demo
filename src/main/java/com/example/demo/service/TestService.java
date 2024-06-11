package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public TestModel getById(Integer id) {
        String cacheKey = "test-model-id-" + id;
        ValueOperations<String, TestModel> ops = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(cacheKey);
        if (hasKey) {
            System.out.println("get from Redis");
            return ops.get(cacheKey);
        }

        System.out.println("get from MySQL");
        TestModel testModel = testMapper.getById(id);
        ops.set(cacheKey, testModel);

        return testModel;
    }

    public List<TestModel> findAll() {
        return testMapper.findAll();
    }
}
