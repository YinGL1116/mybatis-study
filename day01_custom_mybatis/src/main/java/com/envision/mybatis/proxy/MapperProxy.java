package com.envision.mybatis.proxy;

import com.envision.mybatis.config.Mapper;
import com.envision.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;

    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1首先要获取方法名
        String methodName = method.getName();
        //2方法所在类的名字
        String className = method.getDeclaringClass().getName();
        //3组合
        String key = className + "." + methodName;
        //4取出mapper
        Mapper mapper = mappers.get(key);
        if (null == mapper) {
            throw new IllegalArgumentException("wrong argument !");
        }

        return new Executor().selectList(mapper, connection);
    }
}
