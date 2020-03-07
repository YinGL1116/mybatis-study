package com.envision.dao;

import com.envision.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "address", property = "address"),
            @Result(column = "id", property = "accounts", many = @Many(
                    fetchType = FetchType.LAZY,
                    select = "com.envision.dao.IAccountDao.findAccountsByUserId"
            )),
            @Result(column = "id", property = "roles", many = @Many(
                    fetchType = FetchType.LAZY,
                    select = "com.envision.dao.IRoleDao.findRolesByUserId"
            ))
    })
    List<User> findAll();

    @Select("select * from user where id=#{uid}")
    User findById(int id);

    @Select("select * from user u join user_role ur on u.id=ur.uid join role r on ur.rid=r.id where r.id=#{rid}")
    List<User> findUsersByRoleId(int roleId);
}
