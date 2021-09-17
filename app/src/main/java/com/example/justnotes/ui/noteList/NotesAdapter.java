package com.example.justnotes.ui.noteList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private final ArrayList<Note> data = new ArrayList<>();
    private OnNoteClicked onNoteClicked;

    public OnNoteClicked getOnNoteClicked() {
        return onNoteClicked;
    }

    public void setOnNoteClicked(OnNoteClicked onNoteClicked) {
        this.onNoteClicked = onNoteClicked;
    }



    public void setNotes(List<Note> toSet) {
        data.clear();
        data.addAll(toSet);
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        Note note = data.get(position);
        holder.getNoteName().setText(note.getNameNote());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    interface OnNoteClicked {
        void onNoteOnClicked(Note note);
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {
        private final TextView noteName;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            noteName = itemView.findViewById(R.id.name_list_item);
        }

        public TextView getNoteName() {
            return noteName;
        }
    }
}
