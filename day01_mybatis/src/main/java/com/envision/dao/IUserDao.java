package com.envision.dao;

import com.envision.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
