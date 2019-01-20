package com.example.lolaabudu.sqliteappfromscratch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lolaabudu.sqliteappfromscratch.database.NoteDatabaseHelper;
import com.example.lolaabudu.sqliteappfromscratch.model.Note;


public class NoteSubmissionActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText messageEditText;
    private Button saveToDatabaseButton;
    private Note myNote;
    private NoteDatabaseHelper noteDatabaseHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_submission);

        titleEditText = findViewById(R.id.title_editText);
        messageEditText = findViewById(R.id.message_editText);
        saveToDatabaseButton = findViewById(R.id.save_to_database_button);
        noteDatabaseHelper = NoteDatabaseHelper.getSingleInstance(getApplicationContext());


        saveToDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String title = titleEditText.getText().toString();
                    String message = messageEditText.getText().toString();
                    myNote = new Note(title, message);
                    noteDatabaseHelper.addNote(myNote);
                    Toast.makeText(v.getContext(), "Your notes have been added to Database", Toast.LENGTH_SHORT).show();

                    //used just to log in the logcat that the note is being saved into database
                    for(int i = 0; i < noteDatabaseHelper.getNoteList().size(); i++){
                        Log.d("DatabaseRow", "it works" + " " +
                                noteDatabaseHelper.getNoteList().get(i).getTitle() + " " +
                                noteDatabaseHelper.getNoteList().get(i).getMessage());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
