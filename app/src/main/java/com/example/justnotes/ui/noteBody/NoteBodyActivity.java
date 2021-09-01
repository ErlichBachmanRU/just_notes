package com.example.justnotes.ui.noteBody;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;

public class NoteBodyActivity extends AppCompatActivity {

    public static final String ARG_NOTE_BODY = "ARG_NOTE_BODY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_body);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Note note = getIntent().getParcelableExtra(ARG_NOTE_BODY);

        fragmentManager.beginTransaction()
                .replace(R.id.containerBody, NoteBodyFragment.newInstance(note), "NoteBodyFragment")
                .commit();
    }
}