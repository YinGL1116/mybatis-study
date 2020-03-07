package com.envision.dao;

import com.envision.domain.QueryVo;
import com.envision.domain.Role;
import com.envision.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    List<User> findByName(String name);

    int countSex(String sex);

    List<User> findByVo(QueryVo vo);

    List<User> findByCondition(QueryVo vo);

    List<User> findUsersByRoleId(int roleId);
}
