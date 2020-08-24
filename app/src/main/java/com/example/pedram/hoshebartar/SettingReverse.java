package com.example.pedram.hoshebartar;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class SettingReverse extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_reverse);
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        ReversePref fragm=new ReversePref();
        fragmentTransaction.replace(android.R.id.content,fragm);
        fragmentTransaction.commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            Intent intent=new Intent(SettingReverse.this,Reverse.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
