package com.example.sae41_2023;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.preferences);
    }
}
