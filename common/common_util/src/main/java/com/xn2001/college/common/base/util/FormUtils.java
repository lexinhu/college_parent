package com.xn2001.college.common.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 *
 * @author qy
 * @since 1.0
 */
public class FormUtils {

    /**
     * 手机号验证
     */
    public static boolean isMobile(String str) {
        Pattern p = Pattern.compile("^[1][3,4,5,7,8,9][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 邮箱验证
     */
    public static boolean isEmail(String str) {
        Pattern p = Pattern.compile("^\\w+@[a-z0-9]+\\.[a-z]{2,4}$"); // 验证邮箱
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
