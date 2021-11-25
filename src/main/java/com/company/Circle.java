package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Circle extends Figure {

    private double radius;

    public Circle(ArrayList<Point> points) {
        super(points);
    }

    public static Circle inputCircle() {
        ArrayList<Point> points = new ArrayList<>();
        System.out.println("Введите координаты центра и точки окружности:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Point center = new Point(x, y);
        x = in.nextInt();
        y = in.nextInt();
        Point A = new Point(x, y);
        return new Circle(points);
    }

    public void calculateRadius() {
        radius = Math.sqrt(Math.pow(points.get(1).getX() - points.get(0).getX(), 2)
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

    }

    @Override
    public void rotate(double angle) {

    }

    @Override
    public void scale(double scale) {
        radius *= scale;
    }
}
