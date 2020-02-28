package com.envision.mybatis.session;

import com.envision.dao.IUserDao;

/**
 * 自定义mybatis与数据库交互的核心类
 * 创建Dao接口的方法代理
 */
public interface SqlSession {

    /**
     * 创建接口的代理方法
     * @param daoInterface 接口的字节码
     * @param <T> 要代理的接口
     * @return 要代理的接口实现
     */
    <T> T getMapper(Class<T> daoInterface);

    void close();
}
