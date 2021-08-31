package com.example.justnotes.ui.noteBody;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;

public class NoteBodyFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";

    public static NoteBodyFragment newInstance(Note note){
        NoteBodyFragment fragmants = new NoteBodyFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_NOTE,note);
        fragmants.setArguments(arguments);
        return fragmants;
    }

    public NoteBodyFragment(){
        super(R.layout.fragment_note_body);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Note note = getArguments().getParcelable(ARG_NOTE);

        TextView nameItem = view.findViewById(R.id.name_list_item);
        nameItem.setText(note.getNameNote());

        TextView bodyNote = view.findViewById(R.id.body_note);
        bodyNote.setText(note.getBodyNote());
    }
}
