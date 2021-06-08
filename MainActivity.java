package com.example.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing) {
                    case 0:
                        mpUkulele.start();
                        playing = 1;
                        button.setText("Pause Ukulele Song");
                        button2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpUkulele.pause();
                        playing = 0;
                        button.setText("Play Ukulele Song");
                        button2.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing) {
                    case 0:
                        mpDrums.start();
                        playing = 1;
                        button2.setText("Pause Drums Song");
                        button.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpDrums.pause();
                        playing = 0;
                        button2.setText("Play Drums Song");
                        button.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        mpUkulele = new MediaPlayer( );
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer( );
        mpDrums = MediaPlayer.create(this, R.raw.drums);

    }
}
