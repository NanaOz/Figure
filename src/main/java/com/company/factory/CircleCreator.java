package com.company.factory;

import com.company.Circle;
import com.company.Figure;

public class CircleCreator extends FigureCreator{
    @Override
    public Figure createFigure() {
        return Circle.inputCircle();
    }
}
