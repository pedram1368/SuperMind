package com.example.pedram.hoshebartar;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceFragmentCompat;




public class ReversePref extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.reversepref);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Preference prefListOption = findPreference("number_of_digit");
        Preference prefListOption1 = findPreference("appear_time_reverse");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        String firstNumber = pref.getString("number_of_digit", "4");
        String appear_time = pref.getString("appear_time_reverse", "2 second");
        prefListOption.setSummary(firstNumber);
        prefListOption1.setSummary(appear_time);
    }
}
