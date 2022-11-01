package com.example.yuye.biz.annotation;

import java.lang.reflect.Field;

/**
 * @author zhouliang
 * @date 2022/8/17 2:52 PM
 */
public class AnnotationTest {

    @MyField(description = "Light", length = 13)
    private String userName;

    public static void main(String[] args) {
        //获取类模版
        Class<AnnotationTest> annotationTestClass = AnnotationTest.class;
        for (Field f : annotationTestClass.getDeclaredFields()) {
            if (f.isAnnotationPresent(MyField.class)) {
                MyField annotation = f.getAnnotation(MyField.class);
                System.out.println(annotation.description()+annotation.length());
            }
        }
    }
}
