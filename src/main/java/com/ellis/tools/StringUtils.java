package com.ellis.tools;

/**
 * Created by fudw on 16-12-3.
 */
public class StringUtils {

    public static Boolean isBlank(String string) {
        if(string == null || "".equals(string)) {
            return true;
        }
        return false;
    }

    public static String firstLetterUpper(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }

        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
        }
    }


    /**
     *  Converts a string to a hump
     * @param value string to camel case
     * @param replace pattern like "_"
     * @return
     */
    public static String toCamelCase(String value, char replace) {
        if (value == null || "".equals(value)) {
            return "";
        }

        StringBuffer resoult = new StringBuffer();
        String lower = value.toLowerCase();
        char[] charArry = lower.toCharArray();

        boolean flag = false;
        for (int i = 0; i < charArry.length; i++) {
            char cur = charArry[i];
            if (cur == replace) {
                flag = true;
                continue;
            } else {
                if (flag) {
                    char tmp = Character.toUpperCase(cur);
                    resoult.append(tmp);
                    flag = false;
                } else {
                    resoult.append(cur);
                }
            }
        }

        return resoult.toString();
    }


    /**
     *  covers string like "ecirlce_community"  to the string like "Ecircle_Community"
     * @param value
     * @return
     */
    public static String firstLetterUpper(String value, char replace) {
        if (value == null || "".equals(value)) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        char[] charArray = value.toCharArray();
        boolean flag = false;
        int firstLetter =0;
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0) {
                builder.append(Character.toUpperCase(charArray[i]));
            } else {
                if (flag) {
                    builder.append(Character.toUpperCase(charArray[i]));
                    flag = false;
                } else {
                    if (charArray[i] == replace) {
                        flag = true;
                    }
                    builder.append(charArray[i]);
                }

            }
        }
        return builder.toString();
    }

    public static String firstLetterLower(String value) {
        if (value == null || "".equals(value)) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        char[] charArray = value.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            builder.append(Character.toLowerCase(charArray[i]));
        }
        return builder.toString();
    }
}
