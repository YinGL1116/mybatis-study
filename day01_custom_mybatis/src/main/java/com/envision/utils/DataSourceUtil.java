package com.envision.utils;

import com.envision.mybatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {

    public static Connection getConnection(Configuration config) {
        try {
            Class.forName(config.getDriver());
            return DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
