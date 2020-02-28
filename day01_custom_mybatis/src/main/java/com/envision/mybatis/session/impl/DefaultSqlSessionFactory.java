package com.envision.mybatis.session.impl;

import com.envision.mybatis.config.Configuration;
import com.envision.mybatis.session.SqlSession;
import com.envision.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration config;

    public DefaultSqlSessionFactory(Configuration config) {
        this.config = config;
    }

    /**
     * 创建数据库连接对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(config);
    }
}
