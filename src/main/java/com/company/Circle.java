package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Circle extends Figure {

    private double radius;

    public Circle(ArrayList<Point> points) {
        super(points);
        this.calculateRadius();
        this.calculatePerimeter();
        this.calculateArea();
    }

    public void calculateRadius() {
        this.radius = Math.sqrt(Math.pow(points.get(1).getX() - points.get(0).getX(), 2)
                + Math.pow(points.get(1).getY() - points.get(0).getY(), 2));
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void calculateArea() {
        this.area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * Math.PI * radius;
    }

    @Override
    public void calculateCenter() {
       this.figureCenter = this.points.get(0);
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        String result = "Круг с координатами центра и точки на окружности: " + points + " и радиусом " + getRadius() +
                "\n" + "Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea();
        return result;
    }

    @Override
    public void move(Point vect) {
        for (int i = 0; i < points.size(); i++){
            double x1 = vect.getX();
            double y1 = vect.getY();
            points.set (i, new Point(x1 + points.get(i).getX(), y1+points.get(i).getY()));
        }
    }

    @Override
    public void rotate(double angle) {

    }

    @Override
    public void scale(double scale) {
        radius *= scale;
    }
}
