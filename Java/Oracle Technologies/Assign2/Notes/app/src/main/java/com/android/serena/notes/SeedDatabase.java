package com.android.serena.notes;

import android.content.Context;

/**
 * Created by ian on 15-10-18.
 */
public class SeedDatabase {

    public static void seed(Context context){
        DatabaseHandler dbh = new DatabaseHandler(context);

        Category foo = new Category();
        foo.setCategoryName("Foo");
        dbh.getCategoryTable().createCategory(foo);

        Category bar = new Category();
        bar.setCategoryName("Bar");
        dbh.getCategoryTable().createCategory(bar);

        Note note1 = new Note();
        note1.setTitle("FooNote");
        note1.setCatID(foo.getId());
        note1.setComment("Body of FooNote");
        dbh.getNotesTable().createNote(note1);

        Note note2 = new Note();
        note2.setTitle("BarNote");
        note2.setCatID(bar.getId());
        note2.setComment("Body of BarNote");
        dbh.getNotesTable().createNote(note2);

        Note note3 = new Note();
        note3.setTitle("FooNote 2");
        note3.setCatID(foo.getId());
        note3.setComment("Body of FooNote 2");
        dbh.getNotesTable().createNote(note3);
    }
}
