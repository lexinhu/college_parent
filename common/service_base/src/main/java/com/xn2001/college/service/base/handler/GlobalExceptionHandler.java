package com.xn2001.college.service.base.handler;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.ExceptionUtils;
import com.xn2001.college.service.base.exception.CollegeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @author 乐心湖
 * @date 2020/6/25 1:19
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        //后台记录日志，可通过配置xml记录到日志文件中去
        log.error(ExceptionUtils.getMessage(e));
        //返回json数据
        return R.error();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(HttpMessageNotReadableException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    //参数异常
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public R error(BindException e){
        String message = e.getFieldError().getDefaultMessage();
        return R.error().message(message);
    }
    //参数异常
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public R error(ConstraintViolationException e){
        String message = e.getMessage();
        return R.error().message(message);
    }
    //参数异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R error(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
        FieldError fieldError = bindingResult.getFieldError();
        String message = fieldError.getDefaultMessage();
        return R.error().message(message);
    }

    @ExceptionHandler(CollegeException.class)
    @ResponseBody
    public R error(CollegeException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }

}
