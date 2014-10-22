package com.joy.lottery.cache;

import java.io.Serializable;

/**
 * Created by zhangjingbo on 14-10-22.
 */
public class Workspace implements Serializable {

    private static Workspace workspace = new Workspace();

    public static void initWorkspace(String path) {

    }

    public static Workspace getInstance() {
        return workspace;
    }
}
