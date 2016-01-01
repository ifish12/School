package com.cs616.defects;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cs616.defects.model.AsyncStuff.AsyncResponse;
import com.cs616.defects.model.AsyncStuff.CreateDefectTask;
import com.cs616.defects.model.CRUDRepository;
import com.cs616.defects.model.Defect;
import com.cs616.defects.model.Severity;
import com.cs616.defects.model.Status;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefectDetailActivity extends Activity implements AsyncResponse<Boolean> {

    private EditText summaryEditText;
    private Spinner statusSpinner;
    private Spinner severitySpinner;
    private TextView createdTextView;
    private TextView createdByTextView;
    private TextView modifiedTextView;
    private int currentMode;
    private Defect defect;
    private CRUDRepository<Long, Defect> defectRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_detail);

        // determine the "mode" the activity was launced for: EDIT or CREATE
        currentMode = getIntent().getExtras().getInt("mode");

        // initialize control references
        summaryEditText = (EditText) findViewById(R.id.summaryEditText_Defect_Detail);
        statusSpinner = (Spinner) findViewById(R.id.statusSpinner_Defect_Details);
        severitySpinner = (Spinner) findViewById(R.id.severitySpinner_Defect_Details);
        createdByTextView = (TextView) findViewById(R.id.createdByTextView_Defect_Detail);
        createdTextView = (TextView) findViewById(R.id.createdOnTextView_Defect_Detail);
        modifiedTextView = (TextView) findViewById(R.id.modifiedTextView_Defect_Detail);

        // populate spinners with enum values.
        statusSpinner.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_row, Status.values()));
        severitySpinner.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_row_severity, R.id.severityTextView_Spinner_Row, Severity.values()));

         /* TODO: the plan was to add severity colors or icons, but I ran out of time.
        severitySpinner.setAdapter(new ArrayAdapter<Severity>(this, R.layout.spinner_row_severity, Severity.values()) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View rowView;
                if(convertView != null)
                    rowView = convertView;
                else {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    rowView = inflater.inflate(R.layout.spinner_row_severity, parent, false);
                }
                Severity severity = getItem(position);

                TextView severityTextView = (TextView) rowView.findViewById(R.defectId.severityTextView_Spinner_Row);
                severityTextView.setText(severity.toString());

                ImageView severityImageView = (ImageView) rowView.findViewById(R.defectId.severityImageView_Spinner_Row);
                severityImageView.setBackgroundColor(SeverityColor.get(severity));

                return rowView;
            }
        })
        */

        defectRepository = DefectApplication.getDefectRepository();

        if(currentMode == DefectApplication.REQUEST_EDIT) {

            // get defect from the repository
            long defectId = (long) getIntent().getExtras().get("defectId");
            try {
                defect = defectRepository.read(defectId);
            } catch (IOException e) {
                Log.e("DEFECTS", e.getMessage());
                return;
            }

            // populate controls

            summaryEditText.setText(defect.getSummary());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            createdTextView.setText(format.format(defect.getCreated()));
            modifiedTextView.setText(format.format(defect.getModified()));

            statusSpinner.setSelection(find(Status.values(), defect.getStatus()));
            severitySpinner.setSelection(find(Severity.values(), defect.getSeverity()));

            createdByTextView.setText(defect.getCreatedByUrl());
        }
        else
            // create a new defect
            defect = new Defect();
    }

    /**
     * Find an element in an array and return the position
     * @param arr
     * @param elem
     * @param <T>
     * @return position in the array, -1 if not found
     */
    private <T> int find(T[] arr, T elem) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == elem)
                return i;
        return -1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_defect_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {

            // common to both: set the modifiable fields
            defect.setSummary(summaryEditText.getText().toString());
            defect.setSeverity(Severity.values()[severitySpinner.getSelectedItemPosition()]);
            defect.setStatus(Status.values()[statusSpinner.getSelectedItemPosition()]);

            Date now = new Date();
            if(currentMode == DefectApplication.REQUEST_CREATE) {

                // create the defect in the repository
                defect.setCreated(now);
                defect.setModified(new Date(now.getTime() + 1000));
                defect.setCreatedByUrl(DefectApplication.getCurrentUser().getUrl());
                CreateDefectTask task = new CreateDefectTask();
                // downloadProgressBar.setProgress(0);
                task.setDelegate(new AsyncResponse<Boolean>() {
                    @Override
                    public void onAsyncTaskFinish(Boolean success) {
                        if (success) {
                            setResult(RESULT_OK);
                            finish();
                        } else
                            Toast.makeText(getApplication(), "Upload failed", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAsyncTaskProgressUpdate(int progress) {

                    }
                });
                task.execute(defect);

            }
            else {
                // modift the defect in the repository
                defect.setModified(now);
                CreateDefectTask task = new CreateDefectTask();
                // downloadProgressBar.setProgress(0);
                task.setDelegate(new AsyncResponse<Boolean>() {
                    @Override
                    public void onAsyncTaskFinish(Boolean success) {
                        if(success) {
                            setResult(RESULT_OK);
                            finish();
                        }
                        else
                            Toast.makeText(getApplication(), "Modification failed", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAsyncTaskProgressUpdate(int progress) {

                    }
                });
                task.execute(defect);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAsyncTaskFinish(Boolean success) {
        if(success) {
            setResult(RESULT_OK);
            finish();
        }
        else
            Toast.makeText(this, "Upload failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAsyncTaskProgressUpdate(int progress) {

    }
}
