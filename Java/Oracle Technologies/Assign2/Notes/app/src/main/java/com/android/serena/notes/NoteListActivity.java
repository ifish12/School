package com.android.serena.notes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NoteListActivity extends Activity {

    private List<Note> mNotes;

    private DatabaseHandler dbh;

    private ListView mNotesListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        //SeedDatabase.seed(this); // ian
        dbh = new DatabaseHandler(this);

        mNotes = dbh.getNotesTable().getAllNotes();



        NotesArrayAdapter adapter = new NotesArrayAdapter(this, mNotes);
        mNotesListView = (ListView)this.findViewById(R.id.notes_listView);
        mNotesListView.setAdapter(adapter);

        mNotesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //myItemClick(contacts.get(position).toString());
                Toast.makeText(NoteListActivity.this, mNotes.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

        mNotesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(NoteListActivity.this);
                dialogBuilder.setTitle("Delete Note?");

                View dialog_layout = getLayoutInflater().inflate(R.layout.alert_dialog_view, null);

                dialog_layout.setBackgroundColor(Color.TRANSPARENT); // Make our custom view match the background of the AlertDialog

                // Create the text field in the alert dialog...
                TextView title = (TextView) dialog_layout.findViewById(R.id.title_text_alert);
                TextView description = (TextView) dialog_layout.findViewById(R.id.description_text_alert);

                title.setText(mNotes.get(position).getTitle());
                description.setText(mNotes.get(position).getComment());

                dialogBuilder.setView(dialog_layout); // Assigning our custom view to the dialog

                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Delete Placeholder", mNotes.get(position).toString());
                        dbh.getNotesTable().deleteNote(mNotes.get(position));
                        mNotes = dbh.getNotesTable().getAllNotes();


                        NotesArrayAdapter adapter = new NotesArrayAdapter(NoteListActivity.this, mNotes);
                        mNotesListView = (ListView)NoteListActivity.this.findViewById(R.id.notes_listView);
                        mNotesListView.setAdapter(adapter);
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialogBuilder.show();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_list, menu);
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
}
