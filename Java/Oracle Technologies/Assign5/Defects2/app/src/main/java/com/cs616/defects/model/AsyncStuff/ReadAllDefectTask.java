package com.cs616.defects.model.AsyncStuff;

import android.os.AsyncTask;
import android.util.Log;

import com.cs616.defects.model.Defect;
import com.cs616.defects.model.User;
import com.cs616.defects.utility.HttpJsonRequest;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.List;

/**
 * Created by 1224868 on 2015-11-09.
 */
public class ReadAllDefectTask  extends AsyncTask<Defect, Integer, List<Defect>> {

    public static final String SERVER = "localhost";
    public static final int PORT = 9999;
    public static final String PREFIX = "http://" + SERVER + ":" + String.valueOf(PORT);

    private static int REPORT_PROGRESS_RATE_IN_BYTES = 1024;

    private AsyncResponse<List<Defect>> delegate;
    public void setDelegate(AsyncResponse<List<Defect>> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected List<Defect> doInBackground(Defect... params) {
        List<Defect> defect = null;
        try {
            JSONObject root = new JSONObject(new JSONTokener(HttpJsonRequest.make(PREFIX + "/defect/", "GET").getBody()));
            defect = Defect.fromJson(root.getJSONObject("_embedded").getJSONArray("defect"));

        } catch (Exception e) {    // on error, report failure to download
            return defect;
        }
        return defect;
    }



    // not in background
    @Override
    protected void onPostExecute(List<Defect> result) {
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
