package com.company.factory;

import com.company.Figure;
import com.company.figure.Point;

import java.util.List;

public interface FigureCreator {

    Figure createFigure(List<Point> points);
}
