package com.envision.dao;

import com.envision.domain.Role;
import com.envision.domain.User;

import java.util.List;

public interface IRoleDao {

    List<Role> findAll();

    List<Role> findRolesByUserId(int userId);
 }
