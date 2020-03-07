package com.envision.dao;

import com.envision.domain.Role;
import com.envision.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface IRoleDao {

    @Select("select * from role")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "role_name", property = "roleName"),
            @Result(column = "role_desc", property = "roleDesc"),
            @Result(column = "id", property = "users",
                    many = @Many(fetchType = FetchType.LAZY, select = "com.envision.dao.IUserDao.findUsersByRoleId"))
    })
    List<Role> findAll();

    @Select("select * from role r join user_role ur on r.id=ur.rid join user u on u.id=ur.uid where u.id=#{uid}")
    List<Role> findRolesByUserId(int userId);
 }
