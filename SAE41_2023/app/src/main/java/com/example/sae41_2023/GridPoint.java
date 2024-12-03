package com.example.sae41_2023;

import java.util.Objects;

public class GridPoint {
    private int x;
    private int y;

    public GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPoint gridPoint = (GridPoint) o;
        return x == gridPoint.x && y == gridPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

