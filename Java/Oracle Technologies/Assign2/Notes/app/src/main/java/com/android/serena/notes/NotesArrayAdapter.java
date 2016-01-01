package com.android.serena.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by ian.clement on 2015-09-21.
 */
public class NotesArrayAdapter extends ArrayAdapter<Note> {

    public NotesArrayAdapter(Context context, List<Note> objects) {
        super(context, -1, objects);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    public String getCatetory(int position) {
        DatabaseHandler dbh = new DatabaseHandler(getContext());
        //List<Category> cat = dbh.getCategoryTable().getAllCategories(); // Get name of all the categories
        //return cat.get(position).toString(); // Return specific category we want via the ID
        return dbh.getCategoryTable().readCategory(position).getCategoryName();
    }

    int randomGenerator(long seed) {
        Random generator = new Random(seed); // Using CatID as the seed, so it's unique per category, but not "random"
        return generator.nextInt() * (2);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View newRow;

        if(convertView == null) {
            // inflate the new row from the XML layout
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            newRow = inflater.inflate(R.layout.list_row_note, parent, false);
        }
        else
            newRow = convertView;

        // set the name and phone number
        TextView titleTextView = (TextView) newRow.findViewById(R.id.title_textView);
        TextView descriptionTextView = (TextView) newRow.findViewById(R.id.description_textView);
        LabeledCircleView circleView = (LabeledCircleView) newRow.findViewById(R.id.circle_view);


        Note note = getItem(position);
        titleTextView.setText(note.getTitle());
        if(note.getComment().length() <= 20)
            descriptionTextView.setText(note.getComment()); // Comment has less than 20 characters and we should display entire thing
        else
            descriptionTextView.setText(note.getComment().substring(0, 20)); // Just get first 20 characters of comment to display

        circleView.setColor(randomGenerator(note.getCatID())*50, randomGenerator(note.getCatID())*75, randomGenerator(note.getCatID())*200); // Assigning the RBG colour from the generator
        circleView.setLabel(getCatetory((int)note.getCatID()).charAt(0));
        return newRow;
   }
}



























