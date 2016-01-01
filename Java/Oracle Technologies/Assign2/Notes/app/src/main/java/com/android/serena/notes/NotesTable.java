package com.android.serena.notes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serena on 15-09-11.
 */
public class NotesTable {

    private static final String TABLE_NAME = "notestable";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_COMMENT = "comment";
    private static final String COLUMN_CATID = "categoryID";


    private static final String[] allColumns = { "_id", COLUMN_TITLE, COLUMN_COMMENT, COLUMN_CATID };

    // DatabaseHandler creation sql statement

    // TODO: This works, but if you need to add another table
    // TODO: and you don't upgrade the database, it won't work because it'll
    // TODO: not see the table, but my drop table syntax is broken
    private static final String CREATE_TABLE = "create table " + TABLE_NAME
    + "(_id integer primary key autoincrement, "
            + COLUMN_TITLE + " text not null unique, "
            + COLUMN_COMMENT + " text not null, "
            + COLUMN_CATID + " integer,"
            + " foreign key(" + COLUMN_CATID + ")"
            + " references project(_id));";
    //    + " references project(_id) on delete set default);";
    private DatabaseHandler databaseHandle;

    public NotesTable(DatabaseHandler databaseHandle) {
        this.databaseHandle = databaseHandle;
    }

    public String getCreateSQL() {
        return CREATE_TABLE;
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    private Note cursorToNote(Cursor cursor) {
        Note project = new Note();
        project.setId(cursor.getLong(0));
        project.setTitle(cursor.getString(1));
        project.setComment(cursor.getString(2));
        project.setCatID(cursor.getLong(3));
        return project;
    }

    /**
     * Insert the Note data into the table.
     * @param note The note to be inserted.
     * @postconditions The category's ID field will be set to the value returned by the database.
     */
    public void createNote(Note note) {

        SQLiteDatabase database = databaseHandle.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(COLUMN_TITLE, category.getCategoryName());

        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_COMMENT, note.getComment());
        values.put(COLUMN_CATID, note.getCatID());


        long insertId = database.insertOrThrow(TABLE_NAME, null, values);
        note.setId(insertId);

        database.close();
    }

    /**
     * Read the category specified by id.
     * @param id The ID of the category.
     * @return The Category object containing the values from the database.
     */
    public Note readNote(long id) {
        SQLiteDatabase db = databaseHandle.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { "_id", COLUMN_TITLE }, "_id =?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Note note = cursorToNote(cursor);
        return note;
    }

    /**
     * Read the category specified by name.
     * @param name The name of the category.
     * @return The Category object containing the values from the database.
     */
    public Note readNoteByName(String name) {
        SQLiteDatabase db = databaseHandle.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { "_id", COLUMN_TITLE }, COLUMN_TITLE + " =?",
                new String[] { name }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Note note = cursorToNote(cursor);
        return note;
    }


    /**
     * Read all categories from the table.
     * @return All rows from the table as a List of Category objects.
     */
    public List<Note> getAllNotes() {
        SQLiteDatabase database = databaseHandle.getReadableDatabase();
        List<Note> comments = new ArrayList<>();

        Cursor cursor = database.query(TABLE_NAME, allColumns, null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                comments.add(cursorToNote(cursor));
                cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();
        }
        return comments;
    }

    /**
     * Get the number of rows in the table.
     * @return The number of rows in the table.
     */
    public int getNoteCount() {
        SQLiteDatabase database = databaseHandle.getReadableDatabase();

        Cursor cursor = database.query(TABLE_NAME, new String[]{"select(*)"}, null, null, null, null, null);
        int result = cursor.getCount();
        return result;
    }


    /**
     * Update a row in the table.
     * @param note The Category object containing updates. The ID field is used to retrieve the correct row.
     * @return boolean whether it was successful or not
     */
    public boolean updateNote(Note note) {

        SQLiteDatabase database = databaseHandle.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_COMMENT, note.getComment());
        values.put(COLUMN_CATID, note.getCatID());

        int rowNum = database.update(TABLE_NAME, values, "_id =?",
                new String[] { String.valueOf(note.getId()) }
        );

        database.close();
        return rowNum == 1;
    }

    /**
     * Delete a row from the table.
     * @param note The Category object containing the row to delete. The ID fields is used to
     */
    public void deleteNote(Note note) {
        SQLiteDatabase database = databaseHandle.getWritableDatabase();
        database.delete(TABLE_NAME, "_id = " + note.getId(), null);
        database.close();
    }


}
