package com.ghkindel.android.condition_56;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    Button playagain;
    TextView score,bestscore;
    private Handler handler=new Handler(){};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final MediaPlayer beeplo = MediaPlayer.create(this, R.raw.beeplo);
        playagain=findViewById(R.id.playagain);
        score=findViewById(R.id.score);
        bestscore=findViewById(R.id.bestscore);
        playagain.setEnabled(false);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                playagain.setEnabled(true);
            }
        };
        handler.postDelayed(runnable,1000);
        Intent intent=getIntent();
        int scores=intent.getIntExtra("score",0);
        score.setText(""+scores);

        SharedPreferences prefs=getSharedPreferences("PREFS",MODE_PRIVATE);
        int bestscores=prefs.getInt("bestscore",0);
        if (scores>bestscores){
            SharedPreferences.Editor editor=getSharedPreferences("PREFS",MODE_PRIVATE).edit();
            editor.putInt("bestscore",scores);
            editor.apply();
           // beeplo.start();
            bestscore.setText(""+scores);
        }
        else { bestscore.setText(""+bestscores);

    }
    playagain.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View view){
            startActivity(new Intent(ResultActivity.this,MainActivity.class));
            finish();
        }
    });
}}