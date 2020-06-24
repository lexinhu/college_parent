package com.atguigu.guli.service.base.handler;

import com.atguigu.guli.common.base.result.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 乐心湖
 * @date 2020/6/25 1:19
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        //控制台输出
        e.printStackTrace();
        return R.error();
    }
}
