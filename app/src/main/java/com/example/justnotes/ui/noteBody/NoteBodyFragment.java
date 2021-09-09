package com.example.justnotes.ui.noteBody;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.ui.noteList.NotesListFragment;

public class NoteBodyFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";
    private TextView nameItem;
    private TextView bodyNote;

    public NoteBodyFragment() {
        super(R.layout.fragment_note_body);
    }

    public static NoteBodyFragment newInstance(Note note) {
        NoteBodyFragment fragmants = new NoteBodyFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_NOTE, note);
        fragmants.setArguments(arguments);
        return fragmants;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameItem = view.findViewById(R.id.name_list_item);
        bodyNote = view.findViewById(R.id.body_note);

        getParentFragmentManager().setFragmentResultListener(NotesListFragment.KEY_SELECTED_NOTE, getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Note note = result.getParcelable(NotesListFragment.ARG_NOTE);
                displayNote(note);
            }
        });
        if (getArguments() != null && getArguments().containsKey(ARG_NOTE)) {
            Note note = getArguments().getParcelable(ARG_NOTE);
            if (note != null) {
                displayNote(note);
            }
        }
    }

    private void displayNote(Note note) {
        bodyNote.setText(note.getBodyNote());
        nameItem.setText(note.getNameNote());
    }
}
