package com.example.sae41_2023;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Croix {
    private float x, y;
    private float size;
    private Paint paint;

    public Croix(Context context, float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
        int color = context.getResources().getColor(R.color.black);
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(5);
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(x - size, y, x + size, y, paint);
        canvas.drawLine(x, y - size, x, y + size, paint);
    }

    public boolean contains(float touchX, float touchY) {
        return touchX >= x - size && touchX <= x + size && touchY >= y - size && touchY <= y + size;
    }
}
