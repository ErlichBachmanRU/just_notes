package com.example.justnotes.ui.noteList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.domain.SomeNotesRepo;
import com.example.justnotes.ui.noteBody.NoteBodyActivity;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    private NotesListPresenter presenter;
    private LinearLayout container;

    public NotesListFragment() {
        super(R.layout.fragment_note_list);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesListPresenter(this, new SomeNotesRepo());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = view.findViewById(R.id.list_notes);
        presenter.requestNotes();
    }

    @Override
    public void showNotes(List<Note> notes) {
        for (Note note : notes) {
            View noteItem = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, container, false);

            noteItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(requireContext(), NoteBodyActivity.class);
                    intent.putExtra(NoteBodyActivity.ARG_NOTE_BODY, note);
                    startActivity(intent);
                    Toast.makeText(requireContext(), note.getNameNote(), Toast.LENGTH_SHORT).show();
                }
            });
            TextView noteName = noteItem.findViewById(R.id.name_list_item);
            noteName.setText(note.getNameNote());


            container.addView(noteItem);
        }
    }
}
