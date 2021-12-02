package com.company.factory;

import com.company.figure.Circle;
import com.company.figure.Point;

import java.util.List;

public class CircleCreator implements FigureCreator {
    @Override
    public Circle createFigure(List<Point> points) {
        return new Circle(points);
    }
}
