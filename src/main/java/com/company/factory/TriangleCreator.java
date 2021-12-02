package com.company.factory;

import com.company.Figure;
import com.company.figure.Point;
import com.company.figure.Triangle;

import java.util.List;

public class TriangleCreator implements FigureCreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new Triangle(points);

    }
}
