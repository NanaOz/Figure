package com.company.factory;

import com.company.Figure;
import com.company.Triangle;

public class TriangleCreator extends FigureCreator{
    @Override
    public Figure createFigure() {

        return new Triangle(Figure.inputFigure(3));
    }
}
