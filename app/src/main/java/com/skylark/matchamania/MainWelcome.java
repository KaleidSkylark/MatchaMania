package com.skylark.matchamania;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class MainWelcome extends AppCompatActivity {

    private ImageButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_main);

        // Find the play button from the layout
        playButton = findViewById(R.id.play_button);

        // Set a click listener for the play button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the PlayScreen activity
                Intent playScreenIntent = new Intent(MainWelcome.this, PlayScreen.class);
                startActivity(playScreenIntent);
            }
        });
    }
}