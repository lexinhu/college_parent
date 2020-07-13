package com.xn2001.college.service.base.exception;

import com.xn2001.college.common.base.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 乐心湖
 * @date 2020/7/2 20:08
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class CollegeException extends RuntimeException{

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public CollegeException(Integer code, String message) {
        super(message);
        this.setCode(code);
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public CollegeException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.setCode(resultCodeEnum.getCode());
    }

    @Override
    public String toString() {
        return "CollegeException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
