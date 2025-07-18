package com.mangojellypudding.mangojs.utils;

import java.lang.reflect.Field;

public class MangoJSUtils {
    public static Object getFieldValue(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(null); // static 欄位
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
