package com.cs616.defects.model.AsyncStuff;

/**
 * Created by 1224868 on 2015-11-09.
 */
public interface AsyncResponse <T> {
    void onAsyncTaskFinish(T result);
    void onAsyncTaskProgressUpdate(int progress);
}