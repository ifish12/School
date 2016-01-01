package com.cs616.defects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cs616.defects.model.AsyncStuff.AsyncResponse;
import com.cs616.defects.model.AsyncStuff.ReadAllDefectTask;
import com.cs616.defects.model.Defect;
//import com.cs616.fects.model.stub.StubDefectRepository;de

import java.util.List;

public class DefectListActivity extends Activity implements AsyncResponse<List<Defect>> {

    public static final String SERVER = "localhost";
    public static final int PORT = 9999;
    public static final String PREFIX = "http://" + SERVER + ":" + String.valueOf(PORT);

  //  private StubDefectRepository defectRepository;
    private ExpandableListView defectListView;
    private List<Defect> defects;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_list);
/*        getActionBar().setDisplayUseLogoEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
*/

       // defectRepository = new StubDefectRepository();

        ReadAllDefectTask task = new ReadAllDefectTask();
        task.setDelegate(new AsyncResponse<List<Defect>>() {
            @Override
            public void onAsyncTaskFinish(List<Defect> result) {
                defects = result;
                initializeListView();
            }

            @Override
            public void onAsyncTaskProgressUpdate(int progress) {

            }
        });


        initializeListView();
    }

    private void initializeListView() {
        defectListView = (ExpandableListView) findViewById(R.id.defectListView);
        final DefectExpandableListAdapter adapter = new DefectExpandableListAdapter(this, defects);
        defectListView.setAdapter(adapter);

        // when a user clicks the defect, launch the details activity
        defectListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(DefectListActivity.this, DefectDetailActivity.class);
                intent.putExtra("mode", DefectApplication.REQUEST_EDIT);

                // get defect ID from the adapter instead of the ID passed as an argument to this method, since it only works for long's
                Defect defect = (Defect) adapter.getChild(groupPosition, childPosition);
                intent.putExtra("defectId", defect.getUrl());

                startActivityForResult(intent, 1);
                return true;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            ReadAllDefectTask task = new ReadAllDefectTask();
            task.setDelegate(new AsyncResponse<List<Defect>>() {
                @Override
                public void onAsyncTaskFinish(List<Defect> result) {
                    defects = result;
                    initializeListView();
                }

                @Override
                public void onAsyncTaskProgressUpdate(int progress) {

                }
            });

            // TODO I had planned to use the notification feature but ran out of time
            // defectListView.deferNotifyDataSetChanged();

            // until we can notify the listview that the dataset has changed, we manually reset the listview
            initializeListView();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_defect_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAsyncTaskFinish(List<Defect> success) {
//        if(success)
//            progressBar.setProgress(100);
//        else
//            Toast.makeText(this, "Download failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAsyncTaskProgressUpdate(int progress) {
        //progressBar.setProgress(progress);
    }
}
