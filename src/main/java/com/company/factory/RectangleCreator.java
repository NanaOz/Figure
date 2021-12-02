package com.company.factory;

import com.company.Figure;
import com.company.figure.Point;
import com.company.figure.Rectangle;

import java.util.List;

public class RectangleCreator implements FigureCreator{
    @Override
    public Figure createFigure(List<Point> points) {
        return new Rectangle(points);

    }
}
