package com.envision.dao;

import com.envision.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    List<User> findByName(String name);

    int countSex(String sex);
}
