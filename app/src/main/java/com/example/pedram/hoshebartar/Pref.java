package com.example.pedram.hoshebartar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;


public class Pref extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Preference prefListOption = findPreference("first_number");
        Preference prefListOption1 = findPreference("second_number");
        Preference prefListOption2 = findPreference("appear_time");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        String firstNumber = pref.getString("first_number", "4");
        String secondNumber = pref.getString("second_number", "4");
        String appear_time = pref.getString("appear_time", "2 second");
        prefListOption.setSummary(firstNumber);
        prefListOption1.setSummary(secondNumber);
        prefListOption2.setSummary(appear_time);
    }
}
