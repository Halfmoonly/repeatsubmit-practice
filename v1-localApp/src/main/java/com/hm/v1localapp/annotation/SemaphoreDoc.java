package com.hm.v1localapp.annotation;
import java.lang.annotation.*;
import java.lang.annotation.*;

/**
 * @Author: ly
 * @Date: 2024/2/24 19:50
 */


@Documented
@Target({ElementType.METHOD})//作用:方法
@Retention(RetentionPolicy.RUNTIME)
public @interface SemaphoreDoc {

    String key(); //建议设置，不然可能发生不同方法重复限流现象
    int limit() default 3;
    int blockingTime() default 3;

}
