package com.envision.mybatis.session.impl;

import com.envision.mybatis.config.Configuration;
import com.envision.mybatis.proxy.MapperProxy;
import com.envision.mybatis.session.SqlSession;
import com.envision.utils.DataSourceUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {

    private Configuration config;

    private Connection connection;

    public DefaultSqlSession(Configuration config) {
        this.config = config;
        this.connection = DataSourceUtil.getConnection(config);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterface) {
        return (T)Proxy.newProxyInstance(daoInterface.getClassLoader(), new Class[]{daoInterface}, new MapperProxy(config.getMappers(), connection));
    }

    @Override
    public void close() {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
