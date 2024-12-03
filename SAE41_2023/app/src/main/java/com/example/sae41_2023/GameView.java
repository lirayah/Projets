package com.example.sae41_2023;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;

public class GameView extends View {
    private static final String TAG = "GameView";
    private Paint paint;
    private Map<GridPoint, Integer> grid;
    private float offsetX, offsetY;
    private float scaleFactor;
    private ScaleGestureDetector scaleDetector;
    private GestureDetector gestureDetector;
    private int gridInitSize;
    private SharedPreferences sharedPreferences;
    private RelativeLayout layout;
    private Map<Integer,Ligne> dicoLigne;
    private AjouterLigne ajouterLigne;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.layout = getRootView().findViewById(R.id.mainGame) ;
        this.grid = new HashMap<>();
        this.dicoLigne = new HashMap<>();
        this.gridInitSize = 80;
        this.scaleFactor = 1f;
        this.paint = new Paint();
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int[][] baseGrid;
        if (sharedPreferences.getBoolean(getResources().getString(R.string.petite_grille), false)){
            baseGrid = BaseGrid.PETITE_GRILLE;
        } else {
            baseGrid = BaseGrid.GRANDE_GRILLE;
        }
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (int[] point : baseGrid) {
            grid.put(new GridPoint(centerX + point[0], centerY + point[1]), 1);
        }
        scaleDetector = new ScaleGestureDetector(context, new ScaleListener(scaleFactor,this));
        gestureDetector = new GestureDetector(context, new GestureListener(this));
        ajouterLigne = new AjouterLigne(this.dicoLigne, this.grid, context, scaleFactor, gridInitSize);

        this.paint.setStrokeWidth(3);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Center the initial cross
        offsetX = w / 2;
        offsetY = h / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(offsetX, offsetY);
        canvas.scale(scaleFactor, scaleFactor);

        // Draw light gray grid lines
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);

        int halfWidth = getWidth() / 2;
        int halfHeight = getHeight() / 2;

        // Calculate grid start and end positions based on offset and scale
        int startGridX = (int) (-offsetX / (gridInitSize * scaleFactor)) * gridInitSize;
        int endGridX = (int) ((getWidth() - offsetX) / (gridInitSize * scaleFactor)) * gridInitSize;
        int startGridY = (int) (-offsetY / (gridInitSize * scaleFactor)) * gridInitSize;
        int endGridY = (int) ((getHeight() - offsetY) / (gridInitSize * scaleFactor)) * gridInitSize;

        paint.setStrokeWidth(3);
        // Draw vertical lines
        for (int x = startGridX; x <= endGridX; x += gridInitSize) {
            canvas.drawLine(x, startGridY, x, endGridY, paint);
        }

        // Draw horizontal lines
        for (int y = startGridY; y <= endGridY; y += gridInitSize) {
            canvas.drawLine(startGridX, y, endGridX, y, paint);
        }

        // Draw the crosses
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        for (Map.Entry<GridPoint, Integer> entry : grid.entrySet()) {
            GridPoint point = entry.getKey();
            drawCross(canvas, point.getX() * gridInitSize, point.getY() * gridInitSize); // Adjust cross size
        }

        this.paint.setColor(getResources().getColor(R.color.rouge));
        for (Map.Entry<Integer, Ligne> entry : dicoLigne.entrySet()){
            Ligne ligne = entry.getValue();
            canvas.drawLine(ligne.getStartX()* gridInitSize, ligne.getStartY() * gridInitSize, ligne.getEndX() * gridInitSize, ligne.getEndY() *gridInitSize, this.paint);
        }

        canvas.restore();
    }

    private void drawCross(Canvas canvas, float x, float y) {
        Log.d(TAG, "Drawing cross at: (" + x + ", " + y + ")");
        float crossSize = gridInitSize / 2 - 5; // Adjust cross size
        canvas.drawLine(x - crossSize, y-(crossSize/2), x + crossSize, y+(crossSize/2), paint);
        canvas.drawLine(x-(crossSize/2), y - crossSize, x+(crossSize/2), y + crossSize, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);

        float startX = event.getX();
        float startY = event.getY();
        int x = (int) ((startX - offsetX) / (gridInitSize * scaleFactor));
        int y = (int) ((startY - offsetY) / (gridInitSize * scaleFactor));
        this.ajouterLigne.setX(x);
        this.ajouterLigne.setY(y);
        this.ajouterLigne.setOffsetX(offsetX);
        this.ajouterLigne.setOffsetY(offsetY);
        ajouterLigne.onTouch(this,event);
        return true;
    }

    public void addOffsetX(float f){
        offsetX += f;
    }

    public void addOffsetY(float f){
        offsetY += f;
    }

    public void setScaleFactor(float f){
        scaleFactor = f;
    }
}