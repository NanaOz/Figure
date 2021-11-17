package com.company;

import com.company.interfaces.IMovable;
import com.company.interfaces.IRotatable;
import com.company.interfaces.IScalable;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Figure implements IMovable, IRotatable, IScalable {
    ArrayList<Point> points;
    Point figureCenter;
    double area;
    double perimeter;


    public Figure(ArrayList<Point> points) {
        this.points = points;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void calculateArea (){}

    public void calculatePerimeter(){}

    public Point getCenter () {
        return this.figureCenter;
    }
}
