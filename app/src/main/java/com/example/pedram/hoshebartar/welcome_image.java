package com.example.pedram.hoshebartar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class welcome_image extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_image);

        tv=findViewById(R.id.tv);
        tv.setAlpha(0);


        tv.animate().setDuration(4000l).alpha(1).start();
        Handler handler=new Handler();
        handler.postDelayed(changeActivity,4000);

    }

    public Runnable changeActivity = new Runnable() {
        @Override
        public void run() {
            Intent intent=new Intent(welcome_image.this,MainActivity.class);
            startActivity(intent);
            finish();

        }
    };
}
