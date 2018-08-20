package com.meiji.Interface;

import java.io.File;

/**
  *  描述：文件压缩回调
  *  时间：2018/8/14 10:39
  **/
public interface FileCallk {
    void Success(File file);
    void Error(Throwable s);
    void onStart();
}
