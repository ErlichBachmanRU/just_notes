package com.example.justnotes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.ui.noteBody.NoteBodyActivity;
import com.example.justnotes.ui.noteList.NotesListFragment;

public class MainActivity extends AppCompatActivity implements NotesListFragment.OnNoteClicked {
    public static final String ARG_NOTE_BODY = "ARG_NOTE_BODY";
    private Note selectedNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.item_menu_create_note).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new CreateNoteFragment(), "CreateNoteFragment")
                        .addToBackStack(null)
                        .commit();

                Toast.makeText(MainActivity.this, "clicked Create", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.item_menu_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new InfoAppFragment(), "InfoAppFragment")
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(MainActivity.this, "clicked info", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.item_menu_notes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new NotesListFragment(), "NotesListFragment")
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(MainActivity.this, "clicked NotesList", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onNoteOnClicked(Note note) {
        selectedNote = note;
        if (getResources().getBoolean(R.bool.itsLandscape)) {
        } else {
            Intent intent = new Intent(this, NoteBodyActivity.class);
            intent.putExtra(NoteBodyActivity.ARG_NOTE_BODY, note);
            startActivity(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (selectedNote != null) {
            outState.putParcelable(ARG_NOTE_BODY, selectedNote);
        }
        super.onSaveInstanceState(outState);
    }
}