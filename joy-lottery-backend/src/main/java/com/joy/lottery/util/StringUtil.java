package com.joy.lottery.util;

/**
 * Created by zhangjingbo on 14-10-22.
 */
public class StringUtil {

    public static String getFormatPath(String path) {
        if (!path.endsWith("/")) {
            return path + "/";
        }
        return path;
    }
}
