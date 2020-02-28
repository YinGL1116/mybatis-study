package com.envison;

import com.envision.dao.IUserDao;
import com.envision.domain.User;
import com.envision.mybatis.io.Resources;
import com.envision.mybatis.session.SqlSession;
import com.envision.mybatis.session.SqlSessionFactory;
import com.envision.mybatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        in.close();
        sqlSession.close();
    }
}
