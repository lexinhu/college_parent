package com.atguigu.guli.service.base.exception;

import com.atguigu.guli.common.base.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author 乐心湖
 * @date 2020/7/2 20:08
 **/
@Data
public class GuliException extends RuntimeException{

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public GuliException(Integer code,String message) {
        super(message);
        this.setCode(code);
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.setCode(resultCodeEnum.getCode());
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
