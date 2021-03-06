package com.example.pedram.hoshebartar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.speech.tts.SynthesisRequest;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.GenericArrayType;
import java.util.Locale;


public class JamActivity extends AppCompatActivity implements Frag.onSomeEventListener,Frag.clean,Frag.check {



        ImageView play;
        TextView tv,tv_true,tv_false;
        Switch speech;
        Button back,setting;
        TextToSpeech tts;
        String number="";
        int valFirst,valSecond;
        int turn=0;
        int numberOfTrue=0,numberOfFulse=0;
        Handler handler =new Handler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_jam);

            Frag frag=new Frag();
            getSupportFragmentManager().beginTransaction().add(R.id.jam_layout,frag).commit();
            back=findViewById(R.id.jam_back_btn);
            setting=findViewById(R.id.jam_setting);
            play=findViewById(R.id.jam_btn_play);
            tv=findViewById(R.id.tv_jam_main);
            tv_true=findViewById(R.id.tv_true_jam);
            tv_false=findViewById(R.id.tv_false_jam);
            speech=findViewById(R.id.jam_speech);
            final CountDownTimer count=new CountDownTimer(3000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    tv.setText(String.valueOf("" + millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    startGame();
                    startChronometer();
                }
            };
            tts =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {

                }
            });



            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    Intent intent=new Intent(JamActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });

            setting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(JamActivity.this,Preference_activity.class);
                    startActivity(intent);
                }
            });

            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (turn==0){
                        count.start();
                        play.setImageResource(R.drawable.ic_pause_black_24dp);
                        turn=1;
                    }
                    else if (turn==1){
                        count.cancel();
                        tv.setText("Press the play!");
                        play.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        turn=0;
                        stopChronometer();
                    }

                }
            });

        }





        @Override
        public void someEvent(String s) {
            if (turn==1){
                number=number+s;
                tv.setText(number);}else return;
            if (valFirst+valSecond==Integer.valueOf(number)){
                Animation animation = AnimationUtils.loadAnimation(JamActivity.this, R.anim.anim);
                tv_true.startAnimation(animation);
                tv_true.setText(String.valueOf(++numberOfTrue));
                tv.setTextColor(Color.rgb(0,204,0));
                String valmines=String.valueOf(valFirst+valSecond);
                tv.setText(String.valueOf(valFirst+"+"+valSecond+"="+valmines));
                handler.postDelayed(nextNumber, 2000);
                number="";

            }

        }

        @Override
        public void cleanNumber(String clean) {
            if (turn==1){
                number="";
                tv.setText("Answer!");}else return;
        }

        @Override
        public void checkNumber(String check) {
            if (turn==1){
                number="";
                Animation animation = AnimationUtils.loadAnimation(JamActivity.this, R.anim.anim);
                tv.setTextColor(Color.rgb(254,0,0));
                tv_false.startAnimation(animation);
                tv_false.setText(String.valueOf(++numberOfFulse));
                String valmines=String.valueOf(valFirst+valSecond);
                tv.setText(String.valueOf(valFirst+"+"+valSecond+"="+valmines));
                handler.postDelayed(nextNumber, 2000);}
            turn=0;
        }



        public void startGame(){
            number="";
            turn=1;
            tv.setTextColor(Color.rgb(1,87,155));
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            String firstNumber = pref.getString("first_number", "89");
            String secondNumber = pref.getString("second_number", "89");
            String appear_time = pref.getString("appear_time", "2000");
            GenerateNumber generatNumber =new GenerateNumber(firstNumber,secondNumber);
            handler.postDelayed(appearTime, Integer.valueOf(appear_time));
            valFirst=generatNumber.random_number_first();
            valSecond=generatNumber.random_number_second();
            if (speech.isChecked()) {

                String val=valFirst + "+" + valSecond;
                tv.setText("Listen Carefully");
                tts.speak(val, TextToSpeech.QUEUE_FLUSH, null);
            } else {
                tv.setText(generatNumber.val_first + "+" + generatNumber.val_second);
            }
        }


        public Runnable nextNumber = new Runnable() {
            @Override
            public void run() {
                startGame();
            }
        };
        public Runnable appearTime = new Runnable() {
            @Override
            public void run() {
                tv.setText("Answer!");
            }
        };
        public void startChronometer() {
            ((Chronometer) findViewById(R.id.jam_chronometer)).start();
        }

        public void stopChronometer() {
            ((Chronometer) findViewById(R.id.jam_chronometer)).stop();
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(JamActivity.this,MainActivity.class);
        startActivity(intent);
    }
    }


