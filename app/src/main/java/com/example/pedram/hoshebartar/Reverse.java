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
import android.widget.Toast;

public class Reverse extends AppCompatActivity implements Frag.check,Frag.clean,Frag.onSomeEventListener{

    ImageView play;
    TextView tv,tv_true,tv_false;
    Switch speech;
    Button back,setting;
    TextToSpeech tts;
    String number="";
    String digit;
    int valFirst;
    int turn=0;
    int numberOfTrue=0,numberOfFulse=0;
    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);
        Frag frag=new Frag();
        getSupportFragmentManager().beginTransaction().add(R.id.reverse_layout,frag).commit();
        back=findViewById(R.id.reverse_back_btn);
        play=findViewById(R.id.reverse_btn_play);
        tv=findViewById(R.id.tv_reverse_main);
        tv_true=findViewById(R.id.tv_true_reverse);
        tv_false=findViewById(R.id.tv_false_reverse);
        speech=findViewById(R.id.reverse_speech);
        setting=findViewById(R.id.reverse_setting);





        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Reverse.this,SettingReverse.class);
                startActivity(intent);
            }
        });
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
                Intent intent=new Intent(Reverse.this,MainActivity.class);
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
        if (number.equals(digit)){
            Animation animation = AnimationUtils.loadAnimation(Reverse.this, R.anim.anim);
            tv_true.startAnimation(animation);
            tv_true.setText(String.valueOf(++numberOfTrue));
            tv.setTextColor(Color.rgb(0,204,0));
            tv.setText(digit);
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
            Animation animation = AnimationUtils.loadAnimation(Reverse.this, R.anim.anim);
            tv.setTextColor(Color.rgb(254,0,0));
            tv_false.startAnimation(animation);
            tv_false.setText(String.valueOf(++numberOfFulse));
            tv.setText(digit);
            handler.postDelayed(nextNumber, 2000);}
        turn=0;
    }


    public void startGame(){
        number="";
        turn=1;
        tv.setTextColor(Color.rgb(1,87,155));
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String firstNumber = pref.getString("number_of_digit", "4");
        String appear_time = pref.getString("appear_time_reverse", "2000");
        GenerateNumber generatNumber =new GenerateNumber(firstNumber);
        handler.postDelayed(appearTime, Integer.valueOf(appear_time));
        valFirst=generatNumber.random_number_reverse();
        String val=String.valueOf(valFirst);
        digit=new StringBuffer(val).reverse().toString();
        if (speech.isChecked()) {
            tv.setText("Listen Carefully");
            tts.speak(val, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            tv.setText(val);
        }
    }
    public Runnable appearTime = new Runnable() {
        @Override
        public void run() {
            tv.setText("Answer!");
        }
    };

    public void startChronometer() {
        ((Chronometer) findViewById(R.id.reverse_chronometer)).start();
    }

    public void stopChronometer() {
        ((Chronometer) findViewById(R.id.reverse_chronometer)).stop();
    }
    public Runnable nextNumber = new Runnable() {
        @Override
        public void run() {
            startGame();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Reverse.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
