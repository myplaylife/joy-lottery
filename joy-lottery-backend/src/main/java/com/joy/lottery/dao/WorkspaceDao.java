package com.joy.lottery.dao;

import com.google.common.collect.Lists;
import com.joy.lottery.cache.BaseData;
import com.joy.lottery.cache.Workspace;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangjingbo on 14-10-22.
 */
@Component("workspaceDao")
@Scope("prototype")
public class WorkspaceDao {

    // TODO 格式化字符串怎么写？
    private static String format = "YYYY-MM-DD HH:mm:SS.mmm";

    public void persistWorkspace() throws IOException {
        long currentTime = System.currentTimeMillis();
        DateTime dt = new DateTime(currentTime);
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(getVersionPath(dt.toString(format))));
        outputStream.writeObject(Workspace.getInstance());
    }

    public Workspace deserializeWorkspace(String version) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(getVersionPath(version)));
        Workspace workspace = (Workspace) inputStream.readObject();
        return workspace;
    }

    public List<String> getWorkspaceVersions() {
        String workspacePath = BaseData.getWorkspacePath();
        File workspace = new File(workspacePath);
        File[] directories = workspace.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        List<String> versions = Lists.newArrayList();
        for (File file : directories) {
            DateTime dt = new DateTime(Long.valueOf(file.getName()));
            versions.add(dt.toString(format));
        }
        Collections.sort(versions);
//        Collections.reverse(versions);
        return versions;
    }

    private static String getVersionPath(String version) {
        return BaseData.getWorkspacePath() + version;
    }
}
