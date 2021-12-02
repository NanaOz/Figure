package com.company.factory;

import com.company.figure.Point;
import com.company.figure.Polygon;

import java.util.List;

public class PolygonCreator implements FigureCreator {
    @Override
    public Polygon createFigure(List<Point> points) {
        return new Polygon(points);

    }
}
