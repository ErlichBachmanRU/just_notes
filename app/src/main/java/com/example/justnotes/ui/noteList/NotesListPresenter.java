package com.example.justnotes.ui.noteList;

import com.example.justnotes.domain.Note;
import com.example.justnotes.domain.MockSomeNotesRepo;

import java.util.List;

public class NotesListPresenter {

    private final NotesListView view;

    private final MockSomeNotesRepo repository;

    public NotesListPresenter(NotesListView view, MockSomeNotesRepo repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        List<Note> gaveNotes = repository.getNotes();

        view.showNotes(gaveNotes);

    }
}
