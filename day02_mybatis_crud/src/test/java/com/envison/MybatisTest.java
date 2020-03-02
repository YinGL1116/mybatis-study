package com.envison;

import com.envision.dao.IAccountDao;
import com.envision.dao.IUserDao;
import com.envision.domain.Account;
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
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);

    }

    @After
    public void destroy() throws Exception{
        //自动提交 auto commit 默认是false 所以没办法持久化 必须手动commit
        sqlSession.commit();
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
        user.setUsername("save_test_last");
        user.setAddress("shanghai");
        user.setSex("男");
        user.setBirthday(new Date());
        //保存前 注意id
        System.out.println(user);
        userDao.save(user);
        //保存后 注意id
        System.out.println(user);


    }

    @Test
    public void deleteTest() {
        userDao.deleteById(52);

    }

    @Test
    public void findByNameTest() {
        List<User> users = userDao.findByName("%王%");
        System.out.println(users);
    }

    @Test
    public void countSexTest() {
        int number = userDao.countSex("男");
        System.out.println(number);
    }

    @Test
    public void accountFindAllTest() {
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
    }


}
