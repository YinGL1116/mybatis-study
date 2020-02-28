package com.envision.mybatis.session;

import com.envision.mybatis.config.Configuration;
import com.envision.mybatis.session.impl.DefaultSqlSessionFactory;
import com.envision.utils.XMLConfigBuilder;

import java.io.InputStream;
import java.sql.Connection;

public class SqlSessionFactoryBuilder {

    /**
     * 根据配置文件字节输入流的来创建工厂
     * @param config 配置文件字节输入流
     * @return factory
     */
    public SqlSessionFactory build(InputStream config) {
        // 注意这个关系 使用配置文件的字节输入流来创建 config对象
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }


}
