package com.example.justnotes.ui.noteList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.domain.SomeNotesRepo;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    public static final String KEY_SELECTED_NOTE = "KEY_SELECTED_NOTE";
    public static final String ARG_NOTE = "ARG_NOTE";
    private NotesListPresenter presenter;
    private LinearLayout container;
    private OnNoteClicked onNoteClicked;

    public NotesListFragment() {
        super(R.layout.fragment_note_list);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteClicked = null;
        super.onDetach();
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
                    if (onNoteClicked != null) {
                        onNoteClicked.onNoteOnClicked(note);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(ARG_NOTE, note);
                    getParentFragmentManager().setFragmentResult(KEY_SELECTED_NOTE, bundle);
                }
            });
            TextView noteName = noteItem.findViewById(R.id.name_list_item);
            noteName.setText(note.getNameNote());
            container.addView(noteItem);
        }
    }

    public interface OnNoteClicked {
        void onNoteOnClicked(Note note);
    }
}
