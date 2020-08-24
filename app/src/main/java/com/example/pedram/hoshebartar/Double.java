package com.example.pedram.hoshebartar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Double extends AppCompatActivity implements Fragment1.check1,Fragment1.clean1,Fragment1.onSomeEventListener1,Frag2.check2,Frag2.clean2,Frag2.onSomeEventListener2{


    ImageView play_jam;
    TextView tv_jam,tv_true_jam,tv_false_jam;
    TextToSpeech tts_jam;
    String number_jam="";
    int valFirst_jam,valSecond_jam;
    int turn_jam=0;
    int numberOfTrue_jam=0,numberOfFulse_jam=0;
    Handler handler =new Handler();




    private TextToSpeech tts_zarb;
    TextView tv_zarb,tv_true_zarb,tv_false_zarb;
    String number_zarb="";
    ImageView play_zarb;
    int turn_zarb=0;
    int valFirst_zarb,valSecond_zarb;
    int numberOfTrue_zarb=0,numberOfFalse_zarb=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double);

        final CountDownTimer count_jam=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_jam.setText(String.valueOf("" + millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                startGame_jam();
                startChronometer_jam();
            }
        };


        final CountDownTimer count_zarb=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_zarb.setText(String.valueOf("" + millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                startGame_zarb();
                startChronometer_zarb();
            }
        };
        tts_jam =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });


        Fragment1 frag=new Fragment1();
        Frag2 frag2=new Frag2();
        getSupportFragmentManager().beginTransaction().add(R.id.baghye,frag).replace(R.id.baghye2,frag2).commit();


        play_jam=findViewById(R.id.double_jam_btn_play);
        tv_jam=findViewById(R.id.tv_double_jam_main);
        tv_true_jam=findViewById(R.id.tv_true_double_jam);
        tv_false_jam=findViewById(R.id.tv_false_double_jam);

        play_zarb=findViewById(R.id.right_zarb_btn_play);
        tv_zarb=findViewById(R.id.tv_right_zarb_main);
        tv_true_zarb=findViewById(R.id.tv_true_right_zarb);
        tv_false_zarb=findViewById(R.id.tv_false_right_zarb);

        play_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn_jam==0){
                    count_jam.start();
                    play_jam.setImageResource(R.drawable.ic_pause_black_24dp);
                    turn_jam=1;
                }
                else if (turn_jam==1){
                    count_jam.cancel();
                    tv_jam.setText("Press the play!");
                    play_jam.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    turn_jam=0;
                    stopChronometer_jam();
                }

            }
        });
        play_zarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn_zarb==0){
                    count_zarb.start();
                    play_zarb.setImageResource(R.drawable.ic_pause_black_24dp);
                    turn_zarb=1;
                }
                else if (turn_zarb==1){
                    count_zarb.cancel();
                    tv_zarb.setText("Press the play!");
                    play_zarb.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    turn_zarb=0;
                    stopChronometer_zarb();
                }

            }
        });
    }








    @Override
    public void someEvent1(String s) {
        if (turn_jam==1){
            number_jam=number_jam+s;
            tv_jam.setText(number_jam);}else return;
        if (valFirst_jam+valSecond_jam==Integer.valueOf(number_jam)){
            Animation animation = AnimationUtils.loadAnimation(Double.this, R.anim.anim);
            tv_true_jam.startAnimation(animation);
            tv_true_jam.setText(String.valueOf(++numberOfTrue_jam));
            tv_jam.setTextColor(Color.rgb(0,204,0));
            String valmines=String.valueOf(valFirst_jam+valSecond_jam);
            tv_jam.setText(String.valueOf(valFirst_jam+"+"+valSecond_jam+"="+valmines));
            handler.postDelayed(nextNumber_jam, 2000);
            number_jam="";

        }
    }

    @Override
    public void cleanNumber1(String clean1) {
        if (turn_jam==1){
            number_jam="";
            tv_jam.setText("Answer!");}else return;
    }

    @Override
    public void checkNumber1(String check1) {
        if (turn_jam==1){
            number_jam="";
            Animation animation = AnimationUtils.loadAnimation(Double.this, R.anim.anim);
            tv_jam.setTextColor(Color.rgb(254,0,0));
            tv_false_jam.startAnimation(animation);
            tv_false_jam.setText(String.valueOf(++numberOfFulse_jam));
            String valmines=String.valueOf(valFirst_jam+valSecond_jam);
            tv_jam.setText(String.valueOf(valFirst_jam+"+"+valSecond_jam+"="+valmines));
            handler.postDelayed(nextNumber_jam, 2000);}
        turn_jam=0;
    }

    @Override
    public void someEvent2(String s) {
        if (turn_zarb==1){
            number_zarb=number_zarb+s;
            tv_zarb.setText(number_zarb);}else return;
        if (valFirst_zarb*valSecond_zarb==Integer.valueOf(number_zarb)){
            Animation animation = AnimationUtils.loadAnimation(Double.this, R.anim.anim);
            tv_true_zarb.startAnimation(animation);
            tv_true_zarb.setText(String.valueOf(++numberOfTrue_zarb));
            tv_zarb.setTextColor(Color.rgb(0,204,0));
            String valmines=String.valueOf(valFirst_zarb*valSecond_zarb);
            tv_zarb.setText(String.valueOf(valFirst_zarb+"×"+valSecond_zarb+"="+valmines));
            handler.postDelayed(nextNumber_zarb, 2000);
            number_zarb="";

        }
    }

    @Override
    public void cleanNumber2(String clean) {
        if (turn_zarb==1){
            number_zarb="";
            tv_zarb.setText("Answer!");}else return;
    }

    @Override
    public void checkNumber2(String check) {
        if (turn_zarb==1){
            number_zarb="";
            Animation animation = AnimationUtils.loadAnimation(Double.this, R.anim.anim);
            tv_zarb.setTextColor(Color.rgb(254,0,0));
            tv_false_zarb.startAnimation(animation);
            tv_false_zarb.setText(String.valueOf(++numberOfFalse_zarb));
            String valmines=String.valueOf(valFirst_zarb*valSecond_zarb);
            tv_zarb.setText(String.valueOf(valFirst_zarb+"×"+valSecond_zarb+"="+valmines));
            handler.postDelayed(nextNumber_zarb, 2000);}
        turn_zarb=0;
    }

    public void startChronometer_jam() {
        ((Chronometer) findViewById(R.id.double_jam_chronometer)).start();
    }

    public void stopChronometer_jam() {
        ((Chronometer) findViewById(R.id.double_jam_chronometer)).stop();
    }
    public void startGame_jam(){
        number_jam="";
        turn_jam=1;
        tv_jam.setTextColor(Color.rgb(1,87,155));
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

//        String appear_time = pref.getString("appear_time", "2000");
        GenerateNumber generatNumber =new GenerateNumber("89","89");
        handler.postDelayed(appearTime_jam, Integer.valueOf("3000"));
        valFirst_jam=generatNumber.random_number_first();
        valSecond_jam=generatNumber.random_number_second();


            String val=valFirst_jam + "+" + valSecond_jam;
            tv_jam.setText("Listen Carefully");
            tts_jam.speak(val, TextToSpeech.QUEUE_FLUSH, null);

    }
    public Runnable appearTime_jam = new Runnable() {
        @Override
        public void run() {
            tv_jam.setText("Answer!");
        }
    };
    public Runnable nextNumber_jam = new Runnable() {
        @Override
        public void run() {
            startGame_jam();
        }
    };

    public void startGame_zarb(){
        number_zarb="";
        turn_zarb=1;
        tv_zarb.setTextColor(Color.rgb(1,87,155));
        GenerateNumber generatNumber =new GenerateNumber("89","89");
        handler.postDelayed(appearTime_zarb, Integer.valueOf("3000"));
        valFirst_zarb=generatNumber.random_number_first();
        valSecond_zarb=generatNumber.random_number_second();

            tv_zarb.setText(generatNumber.val_first + "×" + generatNumber.val_second);

    }
    public Runnable appearTime_zarb = new Runnable() {
        @Override
        public void run() {
            tv_zarb.setText("Answer!");
        }
    };

    public void startChronometer_zarb() {
        ((Chronometer) findViewById(R.id.right_zarb_chronometer)).start();
    }

    public void stopChronometer_zarb() {
        ((Chronometer) findViewById(R.id.right_zarb_chronometer)).stop();
    }
    public Runnable nextNumber_zarb = new Runnable() {
        @Override
        public void run() {
            startGame_zarb();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(Double.this,MainActivity.class);
        startActivity(intent);
    }

}
