package com.example.justnotes.ui.noteList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.domain.MockSomeNotesRepo;
import com.example.justnotes.ui.noteBody.NoteBodyActivity;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    public static final String KEY_SELECTED_NOTE = "KEY_SELECTED_NOTE";
    public static final String ARG_NOTE = "ARG_NOTE";
    private final NotesAdapter adapter = new NotesAdapter();
    private NotesListPresenter presenter;

    public NotesListFragment() {
        super(R.layout.fragment_note_list);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NotesListPresenter(this, new MockSomeNotesRepo());
        adapter.setOnNoteClicked(new NotesAdapter.OnNoteClicked() {
            @Override
            public void onNoteOnClicked(Note note) {
                Intent intent = new Intent(requireContext(), NoteBodyActivity.class);
                intent.putExtra(NoteBodyActivity.ARG_NOTE_BODY, note);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView notes_list = view.findViewById(R.id.notesList);

        notes_list.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        notes_list.setAdapter(adapter);

        presenter.requestNotes();
    }

    @Override
    public void showNotes(List<Note> notes) {
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();

    }
}
