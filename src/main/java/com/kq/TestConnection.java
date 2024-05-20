package com.kq;

import com.kq.mapper.PersonMapper;
import com.kq.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestConnection {

    static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    static void init() throws IOException {
        String resource = "config" + File.separator +"mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testConnection() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            List<Person> person = mapper.getAll();
            System.out.println(mapper.getClass());
            System.out.println(person);
        }
    }
}