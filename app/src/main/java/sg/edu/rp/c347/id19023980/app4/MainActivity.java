package sg.edu.rp.c347.id19023980.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.ionbit.ionalert.IonAlert;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.melodic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThemeChoice.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        mediaPlayer.pause();
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}