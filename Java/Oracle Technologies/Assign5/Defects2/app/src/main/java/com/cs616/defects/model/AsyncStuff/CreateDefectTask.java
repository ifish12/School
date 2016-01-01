package com.cs616.defects.model.AsyncStuff;

import android.os.AsyncTask;
import android.util.Log;

import com.cs616.defects.model.Defect;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import com.cs616.defects.utility.HttpJsonRequest;
import com.cs616.defects.utility.HttpResponse;


/**
 * Created by ian on 15-10-26.
 */
public class CreateDefectTask extends AsyncTask<Defect, Integer, Boolean> {

    public static final String SERVER = "localhost";
    public static final int PORT = 9999;
    public static final String PREFIX = "http://" + SERVER + ":" + String.valueOf(PORT);

    private static int REPORT_PROGRESS_RATE_IN_BYTES = 1024;

    private AsyncResponse delegate;
    public void setDelegate(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Boolean doInBackground(Defect... params) {

        Defect temp = params[0];

        try {
            HttpJsonRequest.make(PREFIX + "/defect/", "POST", temp.toJson());

        } catch (Exception e) {    // on error, report failure to download
            return false;
        }
        return true;
    }



    // not in background
    @Override
    protected void onPostExecute(Boolean result) {
        if(delegate != null)
            delegate.onAsyncTaskFinish(result);
    }


    // not in background
    @Override
    protected void onProgressUpdate(Integer... values) {
        if(delegate != null)
            delegate.onAsyncTaskProgressUpdate(values[0]);
        //bar.setProgress(values[0]);
        Log.d("DOWNLOAD", String.valueOf(values[0]));
    }
}