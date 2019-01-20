package com.example.lolaabudu.sqliteappfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button noteSubmissionButton;
    Button displayRecyclerViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteSubmissionButton = findViewById(R.id.note_submission_button);
        displayRecyclerViewButton = findViewById(R.id.note_display_recyclerView_button);

        noteSubmissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NoteSubmissionActivity.class);
                startActivity(intent);
            }
        });

        displayRecyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NoteRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
