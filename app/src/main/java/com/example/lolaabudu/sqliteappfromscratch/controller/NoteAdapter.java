package com.example.lolaabudu.sqliteappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lolaabudu.sqliteappfromscratch.R;
import com.example.lolaabudu.sqliteappfromscratch.model.Note;
import com.example.lolaabudu.sqliteappfromscratch.view.NoteViewHolder;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    List<Note> myNote;

    public NoteAdapter(List<Note> myNote) {
        this.myNote = myNote;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_itemview, parent, false);
        return new NoteViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int position) {
        noteViewHolder.onBind(myNote.get(position));
    }

    @Override
    public int getItemCount() {
        return myNote.size();
    }
}
