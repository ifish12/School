package com.android.serena.notes;

/**
 * Created by Serena on 15-09-11.
 */
public class Note {


    private long     id;


    private String   noteTitle;
    private String   noteComment;
    private long     noteCatID;

    public Note() {

    }

    public Note(String noteTitle, String noteComment, long noteCatID) {
        this.noteTitle = noteTitle;
        this.noteComment = noteComment;
        this.noteCatID = noteCatID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return noteTitle;
    }

    public void setTitle(String title) {
        this.noteTitle = title;
    }

    public String getComment() {
        return noteComment;
    }

    public void setComment(String comment) {
        this.noteComment = comment;
    }

    public long getCatID() {
        return noteCatID;
    }

    public void setCatID(long catID) {
        this.noteCatID = catID;
    }

//    public String toString() {
//        return noteTitle;
//    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteComment='" + noteComment + '\'' +
                ", noteCatID=" + noteCatID +
                '}';
    }
}
