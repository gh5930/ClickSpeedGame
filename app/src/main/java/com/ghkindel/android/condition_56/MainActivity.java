package com.ghkindel.android.condition_56;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class MainActivity extends Activity implements View.OnClickListener{//appcompatactivity это строка состояния сверху

    RelativeLayout field;

    Button play,score,time,indikator;
    int count=0;

    int  lowedgebase[]={0,  0,  0,  0,  0,  0,
                    0,  0,  0,  0,  0,  0,
                    0,  0,  0,  0,  0,  0,
                    0, 33, 33, 33,  0,  0,
                    0, 33, 33, 33,  0,  0,
                    0, 33, 33, 33,  0,  0,
                    33,33, 33, 33, 33,  0,
                    33,33, 33, 33, 33,  0,
                    0, 33, 0,  33,  0,  0};//length 54
    int lowedge[]={0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0,
            0,  0,  0,  0,  0,  0};
    int  highedgebase[]={0,  0,  0,  0,  0,  0,
                    0,  0,  0,  0,  0,  0,
                    0,  0,  0,  0,  0,  0,
                    0, 66, 66, 66,  0,  0,
                    0, 66, 66, 66,  0,  0,
                    0, 66, 66, 66,  0,  0,
                    66,66, 66, 66, 66,  0,
                    66,66, 66, 66, 66,  0,
                    0, 66, 0,  66,  0,  0};
int highedge[]={0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0};


    int[]      decr={19,20,21,25,  26,27,31,32,33,36,37,38,39,40,42,43,44,45,46,49,51};
    int countIndikator=0;
    boolean mPaused=true;
    int mLives;
    private CountDownTimer countDownTimer;
    private Handler mHandler = new Handler();
    private long timemilliseconds=1000000;// 10 seconds
int val1=0;

    double  ugol[]={0,        0,          0,          0,          0,         0,
                    0,        0,          0,          0,          0,         0,
                    0,        0,          0,          0,          0,         0,
                    0,        0.00005,    0.00005,    0.00004,   0,         0,
                    0,        0.00002,    0.00008,   0.00006,    0,         0,
                    0,        0.000035,   0.00008,    0.00006,   0,         0,
                    0.00006,  0.00002,    0.00006,    0.00003,    0.00005,   0,
                    0.00002,  0.00003,    0.00001,    0.00004,    0.00006,   0,
                    0,        0.00009,    0,          0.00005,    0,         0};
double stressesSum=0;
double stressesFinal=0;
    double[] cats = new double[54];

    private Button[] btn = new Button[54];
    // plus or minus
    int delta=0;
    int tempdelta=1;

    Random r= new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);play.setTextColor(Color.WHITE);
        field = findViewById(R.id.field);
        score = findViewById(R.id.score);
        time = findViewById(R.id.time);
       time.setOnClickListener(this);
       play.setBackgroundResource(R.drawable.help);
        indikator = findViewById(R.id.indikator);

        btn[0] = findViewById(R.id.play);
        btn[0].setOnClickListener(this);
        //btn[0].setBackgroundResource(R.drawable.new_game);
        btn[4] = findViewById(R.id.butt);
        btn[5] = findViewById(R.id.b5);
        btn[5].setBackgroundResource(R.drawable.pause);
//        btn[6] = findViewById(R.id.b6);
        btn[5].setOnClickListener(this);
          btn[4].setBackgroundResource(R.drawable.picker);
        btn[1] = findViewById(R.id.score);
        indikator.setBackgroundResource(R.drawable.score);
        btn[1].setOnClickListener(this);

        btn[18] = findViewById(R.id.b18);
        btn[18].setOnClickListener(this);


        btn[19] = findViewById(R.id.b19);
        btn[19].setOnClickListener(this);
          btn[19].setBackgroundResource(R.drawable.memory);
        btn[20] = findViewById(R.id.b20);
        btn[20].setOnClickListener(this);
         btn[20].setBackgroundResource(R.drawable.temp);
        btn[21] = findViewById(R.id.b21);
        btn[21].setOnClickListener(this);
          btn[21].setBackgroundResource(R.drawable.memory1);

        btn[25] = findViewById(R.id.b25);
        btn[25].setOnClickListener(this);
          btn[25].setBackgroundResource(R.drawable.stress);
        btn[26] = findViewById(R.id.b26);
        btn[26].setOnClickListener(this);
         btn[26].setBackgroundResource(R.drawable.heartbeat);
        btn[27] = findViewById(R.id.b27);
        btn[27].setOnClickListener(this);
          btn[27].setBackgroundResource(R.drawable.vision);

        btn[31] = findViewById(R.id.b31);
        btn[31].setOnClickListener(this);
          btn[31].setBackgroundResource(R.drawable.thinking);
        btn[32] = findViewById(R.id.b32);
        btn[32].setOnClickListener(this);
          btn[32].setBackgroundResource(R.drawable.breath);
        btn[33] = findViewById(R.id.b33);
        btn[33].setOnClickListener(this);
          btn[33].setBackgroundResource(R.drawable.mouth);

        btn[36] = findViewById(R.id.b36);
        btn[36].setOnClickListener(this);
         btn[36].setBackgroundResource(R.drawable.thinking1);
        btn[37] = findViewById(R.id.b37);
        btn[37].setOnClickListener(this);
          btn[37].setBackgroundResource(R.drawable.skeleton);
        btn[38] = findViewById(R.id.b38);
        btn[38].setOnClickListener(this);
          btn[38].setBackgroundResource(R.drawable.hunger);
        btn[39] = findViewById(R.id.b39);
        btn[39].setOnClickListener(this);
          btn[39].setBackgroundResource(R.drawable.muscle);
        btn[40] = findViewById(R.id.b40);
        btn[40].setOnClickListener(this);
         btn[40].setBackgroundResource(R.drawable.bloodpressure);

        btn[42] = findViewById(R.id.b42);
        btn[42].setOnClickListener(this);
          btn[42].setBackgroundResource(R.drawable.lefthand);
        btn[43] = findViewById(R.id.b43);
        btn[43].setOnClickListener(this);
         btn[43].setBackgroundResource(R.drawable.immunity);
        btn[44] = findViewById(R.id.b44);
        btn[44].setOnClickListener(this);
          btn[44].setBackgroundResource(R.drawable.regeneration);
        btn[45] = findViewById(R.id.b45);
        btn[45].setOnClickListener(this);
          btn[45].setBackgroundResource(R.drawable.reproduction);
        btn[46] = findViewById(R.id.b46);
        btn[46].setOnClickListener(this);
         btn[46].setBackgroundResource(R.drawable.righthand);

        btn[49] = findViewById(R.id.b49);
        btn[49].setOnClickListener(this);
         btn[49].setBackgroundResource(R.drawable.leftleg);
        btn[50] = findViewById(R.id.b50);
        btn[51] = findViewById(R.id.b51);
        btn[51].setOnClickListener(this);
      ;
        btn[52] = findViewById(R.id.b52);
          btn[51].setBackgroundResource(R.drawable.rightleg);




        final MediaPlayer gamover = MediaPlayer.create(this, R.raw.sample);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart) {
            showStartDialog();
        }

        startNewGame();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    while (!isInterrupted()

                    ) {
                        Thread.sleep(1000 );
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (!mPaused) {
//cats[42]=cats[46];
//cats[49]=cats[51];
                                    for (int i:decr)
                                    {

                                            if (cats[i] < lowedge[i]) {
                                                switch (i){
                                                    case 20:
                                                    case 21:
                                                    case 25:
                                                    case 27:
                                                    case 31:
                                                    case 40:
                                                    case 42:
                                                    case 43:
                                                    case 45:
                                                    case 49:
                                                        cats[i]++;break;
                                                    default:cats[i]--;break;
                                                }

                                                btn[i].setTextColor(Color.WHITE);
                                                if (cats[i] < 1) {
                                                    cats[i]=0;

                                                }

                                            }
                                            if ((cats[i] >= lowedge[i]) && (cats[i] <= highedge[i])) {

                                                switch (i){
                                                    case 20:
                                                    case 21:
                                                    case 25:
                                                    case 27:
                                                    case 31:
                                                    case 40:
                                                    case 42:
                                                    case 43:
                                                    case 45:
                                                    case 49:
                                                        cats[i] = +val1*sin(ugol[i])+(cats[i] + 3*sin(val1))*cos(ugol[i]);;break;
                                                    default: cats[i] = -val1*sin(ugol[i])+(cats[i] - 3*sin(val1))*cos(ugol[i]);break;
                                                }

                                                btn[i].setTextColor(Color.GREEN);
                                            }
                                            if (cats[i] > highedge[i]) {
                                                switch (i){
                                                    case 20:
                                                    case 21:
                                                    case 25:
                                                    case 27:
                                                    case 31:
                                                    case 40:
                                                    case 42:
                                                    case 43:
                                                    case 45:
                                                    case 49:
                                                        cats[i]+=1;break;
                                                    default:cats[i]-=1;break;
                                                }
                                                btn[i].setTextColor(Color.YELLOW);
                                                if (cats[i] > 99) {
                                                    cats[i]=100;

                                                }

                                            }
                                            btn[i].setText("" + (int) (StrictMath.round(cats[i])));

                                        if (( cats[i]<1)||(cats[i]==100)) {

                                                mPaused = true;
                                               // gamover.start();

                                                Intent intentGameOver=new Intent(MainActivity.this, ResultActivity.class);
                                                intentGameOver.putExtra("score",countIndikator);
                                                startActivity(intentGameOver);
                                                finish();
                                                startNewGame();

                                        }
                                    }
if ((cats[38]>56)&&(cats[19]>80)&&(cats[33]>30)&&(cats[45]>50)){winner();countIndikator+=10000;}
                                    if ((countIndikator>50)&&(countIndikator % 5==0)){cats[decr[r.nextInt(decr.length)]]-=r.nextInt(20);}// случайные

countIndikator=val1++;indikator.setText(""+countIndikator);
                    delta=(int)StrictMath.round((cos(val1/10))*10);//positive shift
                    btn[4].setText(delta+"");btn[4].setTextColor(Color.WHITE);



                                }
                            }  });
                    }
                }
                catch (Exception e){};
            }
        };
        thread.start();
    }


    @Override
    public void onClick(View v) {
       // MediaPlayer mp = MediaPlayer.create(this, R.raw.click);

        switch (v.getId()){

            case R.id.play:
            {mPaused=true;
                showStartDialog();
            break;}

            case R.id.b5:
            {if (!mPaused) mPaused=true;
            else mPaused=false;
                break;}

            case R.id.score:
            {count++;
                score.setText(""+count);
                countIndikator=countIndikator--;
                indikator.setText(""+countIndikator);
                break;}

            case R.id.b19:
            {cats[19]=cats[19]+delta;
                break;}

            case R.id.b20:
            {cats[20]=cats[20]+delta;
                break;}

            case R.id.b21:
            { cats[21]=cats[21]+delta;
                break;}

            case R.id.b25:
            {  cats[25]=cats[25]+delta;
                break;}

            case R.id.b26:
            {  cats[26]=cats[26]+delta;
                break;}

            case R.id.b27:
            { cats[27]=cats[27]+delta;
                break;}

            case R.id.b31:
            {cats[31]=cats[31]+delta;
                break;}

            case R.id.b32:
            { cats[32]=cats[32]+delta;
                break;}

            case R.id.b33:
            { cats[33]=cats[33]+delta;
                break;}

            case R.id.b36:
            {cats[36]=cats[36]+delta;
                break;}

            case R.id.b37:
            { cats[37]=cats[37]+delta;
                break;}

            case R.id.b38:
            { cats[38]=cats[38]+delta;
                break;}

            case R.id.b39:
            {  cats[39]=cats[39]+delta;
                break;}

            case R.id.b40:
            {  cats[40]=cats[40]+delta;
                break;}


            case R.id.b42:
            {cats[42]=cats[42]+delta;
                break;}

            case R.id.b43:
            { cats[43]=cats[43]+delta;
                break;}

            case R.id.b44:
            { cats[44]=cats[44]+delta;
                break;}

            case R.id.b45:
            {cats[45]=cats[45]+delta;
                break;}

            case R.id.b46:
            { cats[46]=cats[46]+delta;
                break;}

            case R.id.b49:
            { cats[49]=cats[49]+delta;
                break;}

            case R.id.b51:
            { cats[51]=cats[51]+delta;
                break;}

        }
       // mp.start();
val1+=2;
}

    public void play(){

        count=0;
        mPaused=false;


    }
    private void startTime(){
        countDownTimer= new CountDownTimer(timemilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timemilliseconds=l;
                update();
            }

            @Override
            public void onFinish() {
//
            }
        }.start();
    }
    void update(){
        int seconds=(int)timemilliseconds/1000;
        time.setText(""+seconds);}

    @Override
    protected void onResume() {
        super.onResume();

        mPaused=true;
    }
    @Override
    protected void onPause(){

        super.onPause();

mPaused=true;
//
    }

    public void setCats(double[] cats) {

        for (int i=0;i<lowedge.length;i++){
            lowedge[i]=lowedgebase[i]-10+r.nextInt(20);
        }
        for (int j=0;j<lowedge.length;j++){
            highedge[j]=highedgebase[j]-10+r.nextInt(20);
        }
        for (int k=0;k<lowedge.length;k++){
            cats[k]=lowedge[k]+r.nextInt(30);

        }

        this.cats = cats;
    }

    private void startNewGame() {
        setCats(cats);
        mPaused=true;
        mLives=30;

    }



    private void showStartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("How to play")
                .setMessage("Keep the person green as long as it possible by tapping corresponding buttons. Every tap increases or decreases button number by some value that shown in picker. Green color is optimal, but white and yellow means underweight and overweight correspondingly. If button text shows 0 or 100, the person is dead.  ")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
    private void winner() {
        mPaused=true;
        new AlertDialog.Builder(this)
                .setTitle("Congratulations")
                .setMessage("YOU WON!")
                .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

    }
}