package com.example.lolaabudu.sqliteappfromscratch.model;

//model class is just a class that holds data
//Make data model class(es) based on how we want our Rows to store Data (10 Minutes)
//Consider a note, which is meant to be unique, then structure a class to contain the note's contents.
public class Note {

    private String title;
    private String message;

    public Note(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
