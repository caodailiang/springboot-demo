package com.example.demo.service;

import com.example.demo.mapper.TestMapper;
import com.example.demo.entity.TestEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private RedisTemplate<String, TestEntity> redisTemplate;

    private static final Logger logger = LogManager.getLogger(TestService.class);

    public TestEntity getById(Integer id) {
        String cacheKey = "test-entity-id-" + id;
        ValueOperations<String, TestEntity> ops = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(cacheKey);
        if (hasKey) {
            logger.info("get from Redis");
            return ops.get(cacheKey);
        }

        logger.info("get from MySQL");
        TestEntity testEntity = testMapper.getById(id);
        ops.set(cacheKey, testEntity);

        return testEntity;
    }

    public List<TestEntity> getAll() {
        return testMapper.getAll();
    }
}
