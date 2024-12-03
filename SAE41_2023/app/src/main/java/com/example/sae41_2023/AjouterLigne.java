package com.example.sae41_2023;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Map;

public class AjouterLigne implements View.OnTouchListener {
    private Map<Integer,Ligne> dicoLigne;
    private Map<GridPoint, Integer> grid;
    private int x;
    private int y;
    private Context context;
    private int id;
    private float scaleFactor;
    private int gridInitSize;
    private float offsetX, offsetY;

    public AjouterLigne(Map<Integer, Ligne> dicoLigne, Map<GridPoint,Integer> grid, Context context, float scaleFactor, int gridInitSize) {
        this.dicoLigne = dicoLigne;
        this.grid = grid;
        this.context = context;
        this.id = 0;
        this.scaleFactor = scaleFactor;
        this.gridInitSize = gridInitSize;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN && event.getPointerCount() == 1) {
            Ligne ligne = new Ligne(x,y);
            ligne.setEnd(x,y);
            this.id++;
            this.dicoLigne.put(id,ligne);
            v.invalidate();
        }
        if (event.getActionMasked() == MotionEvent.ACTION_MOVE && event.getPointerCount() == 1){
            Ligne ligne = this.dicoLigne.get(id);
            int endX = (int) ((event.getX() - offsetX) / (gridInitSize * scaleFactor));
            int endY = (int) ((event.getY() - offsetY) / (gridInitSize * scaleFactor));
            ligne.setEnd(endX, endY);
            v.invalidate();
        }
        if (event.getActionMasked() == MotionEvent.ACTION_UP && event.getPointerCount() == 1){
            Ligne ligne = this.dicoLigne.get(id);
            int distX = (int) ligne.getStartX() - ligne.getEndX();
            int distY = (int) ligne.getStartY() - ligne.getEndY();
            if (distX == 0 && Math.abs(distY) == 4){
                int yy = Math.max((int) ligne.getStartY(),(int) ligne.getEndY());
                int nbVide = 0;
                GridPoint pointVide = null;
                for (int i = 0; i < 5; i++) {
                    GridPoint point = new GridPoint(ligne.getStartX(), yy);
                    if (grid.containsKey(point)){
                        Log.d("jsp", "oui");
                    } else {
                        Log.d("jsp", "non");
                        nbVide++;
                        pointVide = point;
                    }
                    yy--;
                }
                if (nbVide == 1){
                    grid.put(pointVide,1);
                } else {
                    dicoLigne.remove(id);
                }
            } else if (Math.abs(distX) == Math.abs(distY) && Math.abs(distX) == 4) {
                int nbVide = 0;
                GridPoint pointVide = null;
                if (distX < 0 && distY < 0){
                    int xxx = Math.min(ligne.getStartX(), ligne.getEndX());
                    int yyy = Math.min(ligne.getStartY(), ligne.getEndY());
                    Log.d("diago", "bas droit");
                    for (int i = 0; i < 5; i++) {
                        GridPoint point = new GridPoint(xxx, yyy);
                        if (grid.containsKey(point)){
                            Log.d("jsp", "oui");
                        } else {
                            Log.d("jsp", "non");
                            nbVide++;
                            pointVide = point;
                        }
                        xxx++;
                        yyy++;
                    }
                    if (nbVide == 1){
                        grid.put(pointVide,1);
                    } else {
                        dicoLigne.remove(id);
                    }
                } else if (distX < 0 && distY > 0){
                    int xxx = Math.min(ligne.getStartX(), ligne.getEndX());
                    int yyy = Math.max(ligne.getStartY(), ligne.getEndY());
                    Log.d("diago", "haut droit");
                    for (int i = 0; i < 5; i++) {
                        GridPoint point = new GridPoint(xxx, yyy);
                        if (grid.containsKey(point)){
                            Log.d("jsp", "oui");
                        } else {
                            Log.d("jsp", "non");
                            nbVide++;
                            pointVide = point;
                        }
                        xxx++;
                        yyy--;
                    }
                    if (nbVide == 1){
                        grid.put(pointVide,1);
                    } else {
                        dicoLigne.remove(id);
                    }
                } else if (distX > 0 && distY < 0) {
                    int xxx = Math.max(ligne.getStartX(), ligne.getEndX());
                    int yyy = Math.min(ligne.getStartY(), ligne.getEndY());
                    Log.d("diago", "bas gauche");
                    for (int i = 0; i < 5; i++) {
                        GridPoint point = new GridPoint(xxx, yyy);
                        if (grid.containsKey(point)){
                            Log.d("jsp", "oui");
                        } else {
                            Log.d("jsp", "non");
                            nbVide++;
                            pointVide = point;
                        }
                        xxx--;
                        yyy++;
                    }
                    if (nbVide == 1){
                        grid.put(pointVide,1);
                    } else {
                        dicoLigne.remove(id);
                    }
                }  else if (distX > 0 && distY > 0) {
                    int xxx = Math.max(ligne.getStartX(), ligne.getEndX());
                    int yyy = Math.max(ligne.getStartY(), ligne.getEndY());
                    Log.d("diago", "haut gauche");
                    for (int i = 0; i < 5; i++) {
                        GridPoint point = new GridPoint(xxx, yyy);
                        if (grid.containsKey(point)){
                            Log.d("jsp", "oui");
                        } else {
                            Log.d("jsp", "non");
                            nbVide++;
                            pointVide = point;
                        }
                        xxx--;
                        yyy--;
                    }
                    if (nbVide == 1){
                        grid.put(pointVide,1);
                    } else {
                        dicoLigne.remove(id);
                    }
                }
            } else if (distY == 0 && Math.abs(distX) == 4) {
                int xxx = Math.max((int) ligne.getStartX(),(int) ligne.getEndX());
                int nbVide = 0;
                GridPoint pointVide = null;
                boolean ligneCollision = false;
                for (int i = 0; i < 5; i++) {
                    GridPoint point = new GridPoint(xxx, ligne.getStartY());
                    int pointY = point.getY();
                    if (grid.containsKey(point)){
                        Log.d("jsp", "oui");
                        if (id != 0 && id != 4) {
                            int pointX = point.getX();
                            for (Map.Entry<Integer, Ligne> entry : dicoLigne.entrySet()) {
                                Ligne entryLigne = entry.getValue();
                                int entryStartY = entryLigne.getStartY();
                                int entryEndY = entryLigne.getEndY();
                                if (entryEndY == entryStartY) {
                                    int entryEndX = entryLigne.getEndX();
                                    int entryStartX = entryLigne.getStartX();
                                    if ((entryEndX == pointX && entryEndY == pointY) || (entryStartX == pointX && entryStartY == pointY)) {
                                        ligneCollision = true;
                                    }
                                }
                            }
                        }
                    } else {
                        Log.d("jsp", "non");
                        nbVide++;
                        pointVide = point;
                    }
                    xxx--;
                }
                if (nbVide == 1 && !ligneCollision){
                    grid.put(pointVide,1);
                } else {
                    dicoLigne.remove(id);
                }
            } else {
                this.dicoLigne.remove(id);
            }
            v.invalidate();
        }
        return true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }
}
