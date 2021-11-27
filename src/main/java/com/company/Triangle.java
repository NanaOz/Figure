package com.company;

import com.company.interfaces.IMovable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Triangle extends Polygon {

    public Triangle(ArrayList<Point> points) {
        super(points);
    }

    @Override
    public void calculateCenter() {
        this.figureCenter = new Point(0, 0);
    }

    @Override
    public String toString() {
        String result = "Треугольник с вершинами в точках " + points +
                "\n" + "Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea();
        return result;
    }


}
