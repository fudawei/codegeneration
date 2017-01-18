package com.ellis.tools;

/**
 * Created by fudw on 16-12-3.
 */
public class Tools {

    public static String getMethodName(String property) {
        if (StringUtils.isBlank(property)) {
           return "";
        }
        return "get" + StringUtils.firstLetterUpper(property);
    }

    public static String setMethodName(String property) {
        if (StringUtils.isBlank(property)) {
            return "";
        }
        return "set" + StringUtils.firstLetterUpper(property);
    }
}
