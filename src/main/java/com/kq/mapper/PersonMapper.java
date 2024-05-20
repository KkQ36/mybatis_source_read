package com.kq.mapper;

import com.kq.model.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    /**
     * 获取表中全部信息
     */
    List<Person> getAll();
}
