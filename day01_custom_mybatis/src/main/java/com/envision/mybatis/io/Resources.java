package com.envision.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取xml配置文件
 */
public class Resources {

    /**
     * 根据传入的文件地址 找到文件 获取字节输入流
     * @param file 配置文件地址
     * @return 包含配置信息的字节输入流
     */
    public static InputStream getResourceAsStream(String file) {
        return Resources.class.getClassLoader().getResourceAsStream(file);
    }

}
