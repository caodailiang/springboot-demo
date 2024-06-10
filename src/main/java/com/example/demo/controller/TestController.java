package com.example.demo.controller;

import com.example.demo.model.TestModel;
import com.example.demo.service.TestService;
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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public TestModel test(@PathVariable Integer id) {
        System.out.println("id:" + id);
        return testService.getById(id);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<TestModel> findAll() {
        System.out.println("findAll");
        return testService.findAll();
    }
}
