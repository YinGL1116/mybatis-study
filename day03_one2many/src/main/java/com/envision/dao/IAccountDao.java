package com.envision.dao;

import com.envision.domain.Account;
import com.envision.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    List<Account>  findAll();

    List<AccountUser> findAllAccount();

}
