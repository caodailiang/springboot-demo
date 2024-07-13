package com.example.demo.mapper;

import com.example.demo.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    TestEntity getById(Integer id);

    @Select("SELECT * FROM test")
    List<TestEntity> getAll();
}
