package com.android.serena.notes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends Activity {
    private Button                 mNewCategory;
    private Spinner                mCategorySpinner;
    private DatabaseHandler        dbh;
    private ArrayAdapter<Category> mAdapter;
    private List<Category>         categories;

    private TextView               mTitle;
    private TextView               mNoteText;
    private Category               mCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final DatabaseHandler dbh = new DatabaseHandler(this);

        dbh = new DatabaseHandler(this);
        categories = dbh.getCategoryTable().getAllCategories();


        mTitle      = (TextView)findViewById(R.id.main_editTitle);
        mNoteText   = (TextView)findViewById(R.id.main_editText);


        mAdapter = new ArrayAdapter<Category>(this,
                R.layout.spinner_row_main,
                categories);

        mCategorySpinner = (Spinner)findViewById(R.id.notes_spinner);
        mNewCategory = (Button)findViewById(R.id.main_new_CatButton);

        mCategorySpinner.setAdapter(mAdapter);

        mNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Add new Category");

                final EditText input = new EditText(MainActivity.this);
                dialogBuilder.setView(input);

                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCategory(input.getText().toString());

                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialogBuilder.show();
            }
        });


    }
    private void addCategory(String name){
        // I know this is a dirty hack and I hate using it. I know there is a better way
        // I know notifyDatasetChanged() is a function is the adapter class, but it
        // wasn't working, so I opted for this (awful) way of doing it
        Category temp = new Category();
        temp.setCategoryName(name);
        dbh.getCategoryTable().createCategory(temp);
        Log.d("Serena Input Test", "Success!");
        categories = dbh.getCategoryTable().getAllCategories();
        mAdapter = new ArrayAdapter<>(this, R.layout.spinner_row_main, categories);
        mCategorySpinner.setAdapter(mAdapter);

    }
    private void saveNote() {
        Category   cat     = (Category)mCategorySpinner.getSelectedItem();
        long       catID   = cat.getId();

        Note temp          = new Note();
        temp.setTitle(mTitle.getText().toString());
        temp.setComment(mNoteText.getText().toString());
        temp.setCatID(catID);

        dbh.getNotesTable().createNote(temp);
        Log.d("Serena Input Notes Test", "Success!");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        else if (id == R.id.action_save) {
            saveNote();
            return true;
        }
        else if (id == R.id.action_debug) {
            Log.d("SQLITE", "=== Start of CategoryTable ===");
            for(Category c : dbh.getCategoryTable().getAllCategories())
                Log.d("SQLITE", " " + c.toString());
            Log.d("SQLITE", "=== End of CategoryTable ===");

            Log.d("SQLITE", "=== Start of NotesTable ===");
            for(Note n : dbh.getNotesTable().getAllNotes())
                Log.d("SQLITE", " " + n.toString());
            Log.d("SQLITE", "=== End of NotesTable ===");
        }

        return super.onOptionsItemSelected(item);
    }
}
