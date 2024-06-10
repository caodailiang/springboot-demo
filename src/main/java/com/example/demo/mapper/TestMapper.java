package com.example.demo.mapper;

import com.example.demo.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    TestModel getById(Integer id);

    @Select("SELECT * FROM test")
    List<TestModel> findAll();
}
