package com.envison;

import com.envision.dao.IAccountDao;
import com.envision.dao.IRoleDao;
import com.envision.dao.IUserDao;
import com.envision.domain.*;
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
    private IRoleDao roleDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
        roleDao = sqlSession.getMapper(IRoleDao.class);


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
        users.forEach(user -> {
            System.out.println("------------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
            System.out.println(user.getRoles());
            System.out.println("------------------");
        });
    }

    @Test
    public void findByIdTest() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    //垃圾
    @Test
    public void findAllAccountTest() {
        List<AccountUser> accountUsers = accountDao.findAllAccount();
        accountUsers.forEach(System.out::println);
    }

    @Test
    public void accountFindAllTest() {
        List<Account> accounts = accountDao.findAll();
        accounts.forEach(account -> {
            System.out.println("------------------");
            System.out.println(account);
            System.out.println(account.getUser());
            System.out.println("------------------");
        });
    }

    @Test
    public void findAllRoleTest() {
        List<Role> roles = roleDao.findAll();
        roles.forEach(role -> {
            System.out.println("------------------");
            System.out.println(role);
            System.out.println(role.getUsers());
            System.out.println("------------------");
        });
    }


}
