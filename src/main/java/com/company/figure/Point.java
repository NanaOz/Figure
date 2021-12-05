package com.company.figure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.Objects;

@JsonAutoDetect
public class Point implements Serializable {
    private double x;
    private double y;

    public Point() {
    }

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
}
