package com.example.sae41_2023;

public class Ligne {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Ligne(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public void setEnd(int X, int Y){
        endX=X;
        endY=Y;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
