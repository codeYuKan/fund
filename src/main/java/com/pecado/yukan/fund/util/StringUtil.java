package com.pecado.yukan.fund.util;

/**
 * @author yukan
 */
public class StringUtil {

    /**
     * 判断对象是否为空
     *
     * @param obj Object
     * @return boolean 空返回true,非空返回false
     */
    public static boolean isNull(Object obj) {
        return null == obj;
    }

    /**
     * Description:判断字符串是否为空
     *
     * @param str String
     * @return boolean 空返回true,非空返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
