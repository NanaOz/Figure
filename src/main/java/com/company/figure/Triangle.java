package com.company.figure;

import java.util.List;

public class Triangle extends Polygon {

    public Triangle() {
    }

    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public void calculateCenter() {
        this.figureCenter = new Point(0, 0);
    }

    @Override
    public String toString() {
        String result = "\nТреугольник с вершинами в точках " + points +
                "\n" + "*Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea();
        return result;
    }


}
