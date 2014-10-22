package com.joy.lottery.cache;

import com.joy.lottery.util.StringUtil;

/**
 * Created by zhangjingbo on 14-10-22.
 */
public class BaseData {

    private static String baseDataPath = "";
    private static String workspacePath = "";

    public static String getBaseDataPath() {
        return baseDataPath;
    }

    public static void setBaseDataPath(String baseDataPath) {
        BaseData.baseDataPath = StringUtil.getFormatPath(baseDataPath);
    }

    public static String getWorkspacePath() {
        return workspacePath;
    }

    public static void setWorkspacePath(String workspacePath) {
        BaseData.workspacePath = StringUtil.getFormatPath(workspacePath);
    }
}
