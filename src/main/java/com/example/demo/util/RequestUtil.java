package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Author: leesanghyuk
 * Date: 2019-05-16 14:23
 * Description:参数检查工具类
 */
public class RequestUtil {
    public static Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    public static void checkObjFiledsIsNull(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(obj) == null) {
                throw new Exception("缺少参数：" + field);
            }
        }
    }
}
