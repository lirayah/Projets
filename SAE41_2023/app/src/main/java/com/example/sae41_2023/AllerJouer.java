package com.example.sae41_2023;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

public class AllerJouer implements View.OnClickListener {
    private Activity parent;
    private SharedPreferences sharedPreferences;

    public AllerJouer(Activity parent, SharedPreferences sharedPreferences){
        this.parent = parent;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void onClick(View v) {
//TODO Créer une intent vers l'activité de jeu
        Intent i = new Intent(parent, GameActivity.class);
        parent.startActivity(i);
    }
}
