package com.envison;

import com.envision.dao.IUserDao;
import com.envision.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        in.close();
        sqlSession.close();
    }

    @Test
    public void findAllTest() {

        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void findByIdTest() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void saveTest() {
        User user = new User();
        user.setUsername("save_test");
        user.setAddress("shanghai");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.save(user);
        //自动提交 auto commit 默认是false 所以没办法持久化 必须手动commit
        sqlSession.commit();
    }


}
