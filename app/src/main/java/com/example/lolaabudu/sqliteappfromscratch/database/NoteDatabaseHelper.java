package com.example.lolaabudu.sqliteappfromscratch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lolaabudu.sqliteappfromscratch.model.Note;

import java.util.ArrayList;
import java.util.List;

//Create Singleton Class for Subclassed SQLiteOpenHelper Instance (10 Minutes)
//Create a Singleton class using the Static Factory Method design pattern, to contain a unique single
// instance of the Subclassed SQLiteOpenHelper class.
public class NoteDatabaseHelper extends SQLiteOpenHelper {

    private static NoteDatabaseHelper myNoteDatabaseInstance;
    private static final int SCHEMA_VERSION = 1;
    private static final String DATABASE_NAME = "Notes_Database.db";
    private static final String TABLE_NAME = "NOTES";

    private NoteDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    public static synchronized NoteDatabaseHelper getSingleInstance(Context context){
        if(myNoteDatabaseInstance == null){
            myNoteDatabaseInstance = new NoteDatabaseHelper(context.getApplicationContext());
        }
        return myNoteDatabaseInstance;
    }

    //in Java, the title and message are type String but in SQL they are a type TEXT
    //below is writing in 2 dif languages SQLite and Java
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "title TEXT, message TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addNote(Note myNote){
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE title = '" + myNote.getTitle() +
                        "' AND message = '" + myNote.getMessage() + "';", null);
        if(cursor.getCount() == 0){
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME + "(title, message) VALUES('" +
                    myNote.getTitle() + "', '" +
                    myNote.getMessage() + "');");
        }
    }

    public List<Note> getNoteList(){
        List<Note> noteList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                do {
                    Note note = new Note(
                            cursor.getString(cursor.getColumnIndex("title")),
                            cursor.getString(cursor.getColumnIndex("message")));
                    noteList.add(note);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }
        return noteList;
    }
}
