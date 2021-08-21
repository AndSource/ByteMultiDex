package com.bytedance.boost_multidex;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaolin(xiaolin.gan@bytedance.com) on 2019/4/8.
 */
public class Result {
    private static Result result = new Result();

    public boolean modified;

    // 执行前剩余空间
    public long freeSpaceBefore;
    //执行后剩余空间
    public long freeSpaceAfter;
    // dalvik vm lib名字
    public String vmLibName;
    // 是否为阿里云OS
    public boolean isYunOS;

    public File dataDir;

    public File rootDir;

    public File dexDir;

    public File optDexDir;

    public File zipDir;

    // 执行中的异常
    public Throwable fatalThrowable;
    // 执行中的异常列表
    public List<Throwable> unFatalThrowable = new ArrayList<>();
    // pathList dex列表
    public List<String> dexInfoList = new ArrayList<>();
    // 是否支持快速加载dex
    public boolean supportFastLoadDex;

    public static Result get() {
        if (result != null) {
            return result;
        } else {
            Log.w(Constants.TAG, "Avoid npe, but return a invalid tmp result");
            return new Result();
        }
    }

    private Result() {
    }

    public void setDirs(File dataDir, File rootDir, File dexDir, File optDexDir, File zipDir) {
        this.dataDir = dataDir;
        this.rootDir = rootDir;
        this.dexDir = dexDir;
        this.optDexDir = optDexDir;
        this.zipDir = zipDir;
    }

    public void setFatalThrowable(Throwable tr) {
        fatalThrowable = tr;
    }

    public void addUnFatalThrowable(Throwable tr) {
        unFatalThrowable.add(tr);
    }

    public void addDexInfo(String dexInfo) {
        dexInfoList.add(dexInfo);
    }
}
