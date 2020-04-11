package com.envision.dao;

import com.envision.domain.QueryVo;
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

    @Select("select * from user where id=#{uuuuuuuuuuuuuid}")
    User findById(int id);

    @Select("select * from user u join user_role ur on u.id=ur.uid join role r on ur.rid=r.id where r.id=#{rid}")
    List<User> findUsersByRoleId(int roleId);

    /**
     *  #{}里放的参数可以直接写成vo中的属性。
     *  假设要写成#{vo.username}  必须在入参加入注解 @Param("vo") 让mybatis知道vo到底是啥
     */
    @Select("select * from user where username=#{username} and sex=#{sex}")
    User findByUsernameAndSex(QueryVo vo);
}
