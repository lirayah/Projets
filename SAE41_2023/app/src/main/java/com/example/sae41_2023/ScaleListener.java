package com.example.sae41_2023;

import android.icu.number.Scale;
import android.view.ScaleGestureDetector;

public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    float scaleFactor;
    GameView view;

    public ScaleListener(float sf, GameView v){
        super();
        scaleFactor = sf;
        view = v;
    }
    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        scaleFactor *= detector.getScaleFactor();
        scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
        view.setScaleFactor(scaleFactor);
        view.invalidate();
        return true;
    }
}