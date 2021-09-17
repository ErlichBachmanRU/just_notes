package com.example.justnotes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justnotes.R;
import com.example.justnotes.domain.Note;
import com.example.justnotes.ui.noteBody.NoteBodyActivity;
import com.example.justnotes.ui.noteList.NotesListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity  {
    public static final String ARG_NOTE_BODY = "ARG_NOTE_BODY";
    private Note selectedNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_menu_notes) {
                    Toast.makeText(MainActivity.this, "clicked NotesList", Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (item.getItemId() == R.id.item_menu_info) {
                    Toast.makeText(MainActivity.this, "clicked Info", Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (item.getItemId() == R.id.item_menu_create_note) {
                    Toast.makeText(MainActivity.this, "clicked Create", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

    }


//    @Override
//    public void onNoteOnClicked(Note note) {
//        selectedNote = note;
//        if (getResources().getBoolean(R.bool.itsLandscape)) {
//        } else {
//            Intent intent = new Intent(this, NoteBodyActivity.class);
//            intent.putExtra(NoteBodyActivity.ARG_NOTE_BODY, note);
//            startActivity(intent);
//        }
//    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (selectedNote != null) {
            outState.putParcelable(ARG_NOTE_BODY, selectedNote);
        }
        super.onSaveInstanceState(outState);
    }
}