package com.example.pedram.hoshebartar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_jam,btn_back,btn_zarb,btn_tafrigh,btn_taghsim,btn_double,btn_revers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_jam=findViewById(R.id.btn_jam);
        btn_back=findViewById(R.id.back_btn);
        btn_zarb=findViewById(R.id.btn_zarb);
        btn_tafrigh=findViewById(R.id.btn_tafrigh);
        btn_taghsim=findViewById(R.id.btn_taghsim);
        btn_double=findViewById(R.id.btn_double);
        btn_revers=findViewById(R.id.btn_reverse);



        btn_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,JamActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_zarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,activity_zarb.class);
                startActivity(intent);
                finish();
            }
        });

        btn_tafrigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,tafrigh_acrivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_taghsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Taghsim.class);
                startActivity(intent);
                finish();
            }
        });

        btn_double.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Double.class);
                startActivity(intent);
                finish();
            }
        });

        btn_revers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Reverse.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
