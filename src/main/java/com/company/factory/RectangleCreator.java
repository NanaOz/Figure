package com.company.factory;

import com.company.Figure;
import com.company.Rectangle;

public class RectangleCreator extends FigureCreator{
    @Override
    public Figure createFigure() {
        return new Rectangle(Figure.inputFigure(4));
    }
}
