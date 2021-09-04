package com.example.justnotes.ui.noteList;

import com.example.justnotes.domain.Note;
import com.example.justnotes.domain.SomeNotesRepo;

import java.util.List;

public class NotesListPresenter {

    private final NotesListView view;

    private final SomeNotesRepo repository;

    public NotesListPresenter(NotesListView view, SomeNotesRepo repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        List<Note> gaveNotes = repository.getNotes();

        view.showNotes(gaveNotes);

    }
}
