package com.envision.dao;

import com.envision.domain.Account;

import java.security.AccessControlContext;
import java.util.List;

public interface IAccountDao {

    List<Account>  findAll();
}
