package com.example.justnotes.domain;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class FireStoreNotesRepository implements NoteRepository{
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    public List<Note> getNotes() {
        return null;
    }
}
