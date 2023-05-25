package com.skylark.matchamania;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PlayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        // Load the first round fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new MainGameFragment())
                .commit();
    }
}