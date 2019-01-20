package com.example.lolaabudu.sqliteappfromscratch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lolaabudu.sqliteappfromscratch.controller.NoteAdapter;
import com.example.lolaabudu.sqliteappfromscratch.database.NoteDatabaseHelper;

public class NoteRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        NoteDatabaseHelper noteDatabaseHelper=NoteDatabaseHelper.getSingleInstance(this);
        recyclerView = findViewById(R.id.note_recyclerview);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        myadapter = new NoteAdapter(noteDatabaseHelper.getNoteList());
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
