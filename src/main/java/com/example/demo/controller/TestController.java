package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import com.example.demo.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo/test")
public class TestController {

    @Autowired
    private TestService testService;

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public TestEntity test(@PathVariable Integer id) {
        logger.info("get user by id:" + id);
        return testService.getById(id);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<TestEntity> getAll() {
        logger.info("get all users");
        return testService.getAll();
    }
}
