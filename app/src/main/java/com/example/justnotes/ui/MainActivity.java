package com.example.justnotes.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justnotes.R;
import com.example.justnotes.ui.noteList.NotesListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.item_menu_notes) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new NotesListFragment(), "NotesListFragment")
                        .addToBackStack("NotesListFragment")
                        .commit();
                return true;
            }
            if (item.getItemId() == R.id.item_menu_info) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new InfoAppFragment(), "InfoAppFragment")
                        .addToBackStack("InfoAppFragment")
                        .commit();
                return true;
            }
            if (item.getItemId() == R.id.item_menu_create_note) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new CreateNoteFragment(), "CreateNoteFragment")
                        .addToBackStack("CreateNoteFragment")
                        .commit();
                return true;
            }
            if (item.getItemId() == R.id.item_menu_login) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new AuthFragment(), "AuthFragment")
                        .addToBackStack("SigninFragment")
                        .commit();
                return true;
            }
            return false;
        });

    }
}