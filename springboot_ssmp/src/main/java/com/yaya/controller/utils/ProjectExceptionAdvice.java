package com.yaya.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



//标记为AOP的异常处理类,将数据为RequestBody返回.
@RestControllerAdvice
public class ProjectExceptionAdvice {


    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    R doException(Exception e) {
        e.printStackTrace();
        return new R( "服务器故障,请稍后再试");
    }

}