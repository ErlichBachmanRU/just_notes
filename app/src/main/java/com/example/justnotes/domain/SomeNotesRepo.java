package com.example.justnotes.domain;

import com.example.justnotes.R;

import java.util.ArrayList;
import java.util.List;

public class SomeNotesRepo implements NoteRepository {

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note(R.string.name_note1, R.string.body_name_note1));
        notes.add(new Note(R.string.name_note2, R.string.body_name_note2));
        notes.add(new Note(R.string.name_note3, R.string.body_name_note3));

        for (int i = 0; i < 10 ; i++) {
            notes.add(new Note(R.string.name_note3, R.string.body_name_note3));

        }
        return notes;
    }
}
