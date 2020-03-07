package com.envision.dao;

import com.envision.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
public interface IAccountDao {

    @Select("select * from account")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "user",
                    one = @One(fetchType = FetchType.EAGER, select = "com.envision.dao.IUserDao.findById"))
    })
    List<Account>  findAll();

    @Select("select * from account a join user u on a.uid=u.id where u.id=#{uid}")
    List<Account> findAccountsByUserId(int userId);

}
