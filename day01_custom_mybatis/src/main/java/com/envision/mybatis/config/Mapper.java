package com.envision.mybatis.config;

/**
 * 用于封装sql语句与返回值类型
 */
public class Mapper {

    // sql语句
    private String QueryString;

    // 返回值类型
    private String ResultType;

    public String getQueryString() {
        return QueryString;
    }

    public void setQueryString(String queryString) {
        QueryString = queryString;
    }

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }
}
