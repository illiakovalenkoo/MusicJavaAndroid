package com.example.simplemusicplayer;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton playImg, stopImg;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        playImg = (ImageButton) findViewById(R.id.playImageButton);
        stopImg = (ImageButton) findViewById(R.id.stopImageButton);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bohemian_raphsody);
    }

    public void MusicPlay(View view) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playImg.setImageResource(R.drawable.ic_play);
        } else {
            mediaPlayer.start();
            playImg.setImageResource(R.drawable.ic_pause);
        }
    }

    public void MusicStop(View view) {
        mediaPlayer.stop();
        playImg.setImageResource(R.drawable.ic_play);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bohemian_raphsody);
    }
}