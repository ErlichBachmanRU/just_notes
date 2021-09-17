package com.example.justnotes.ui.noteList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.domain.SomeNotesRepo;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    public static final String KEY_SELECTED_NOTE = "KEY_SELECTED_NOTE";
    public static final String ARG_NOTE = "ARG_NOTE";
    private NotesListPresenter presenter;
//    private LinearLayout container;
//    private OnNoteClicked onNoteClicked;

    private NotesAdapter adapter = new NotesAdapter();

    public NotesListFragment() {
        super(R.layout.fragment_note_list);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        if (context instanceof OnNoteClicked) {
//            onNoteClicked = (OnNoteClicked) context;
//        }
    }

    @Override
    public void onDetach() {
//        onNoteClicked = null;
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
        RecyclerView notes_list = view.findViewById(R.id.notes_list);

        notes_list.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));
        notes_list.setAdapter(adapter);

        presenter.requestNotes();
    }

    @Override
    public void showNotes(List<Note> notes) {
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();

    }

//    public interface OnNoteClicked {
//        void onNoteOnClicked(Note note);
//    }
}
