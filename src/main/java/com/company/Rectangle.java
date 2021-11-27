package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Rectangle extends Polygon {

    public Rectangle(ArrayList<Point> points) {
        super(points);
    }

    @Override
    public void calculateCenter() {
        this.figureCenter = new Point(0, 0);
    }

    @Override
    public String toString() {
        String result = "Прямоугольник с вершинами в точках: ";
        int n = 4;
        for (int i = 0; i < n; i++) {
            result += points.get(i) + " ";
        }
        result += "\n Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea();
        return result;
    }
}
