package com.example.sae41_2023;

import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    GameView view;

    public GestureListener(GameView v){
        super();
        view = v;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (e1.getPointerCount() == 2 || e2.getPointerCount() == 2) {
            view.addOffsetX(-distanceX);
            view.addOffsetY(-distanceY);
            view.invalidate();
            return true;
        }
        return false;
    }


}