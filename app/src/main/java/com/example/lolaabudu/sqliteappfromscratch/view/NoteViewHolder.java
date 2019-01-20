package com.example.lolaabudu.sqliteappfromscratch.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lolaabudu.sqliteappfromscratch.R;
import com.example.lolaabudu.sqliteappfromscratch.model.Note;


public class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView messageTextView;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.title_recyclerview);
        messageTextView = itemView.findViewById(R.id.text_recyclerview);
    }

    public void onBind(Note note) {
        titleTextView.setText(note.getTitle());
        messageTextView.setText(note.getMessage());
    }
}
