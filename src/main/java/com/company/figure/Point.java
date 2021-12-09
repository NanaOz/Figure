package com.company.figure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect
public class Point implements Serializable {
    private double x;
    private double y;

    @Serial
    private static final long serialVersionUID = 1L;
    public Point() {}

    public Point  (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    @Override
    public String toString() {
        String result = "(" + x + "; " + y + ") ";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
