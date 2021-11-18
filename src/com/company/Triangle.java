package com.company;

import com.company.interfaces.IMovable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Triangle extends Polygon {

    public Triangle(ArrayList<Point> points) {
        super(points);
    }

    public static Triangle inputTriangle() {
        ArrayList<Point> points = new ArrayList<>();
        System.out.println("Введите координаты вершин треугольника:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Point pointA = new Point(x, y);
        x = in.nextInt();
        y = in.nextInt();
        Point pointB = new Point(x, y);
        x = in.nextInt();
        y = in.nextInt();
        Point pointC = new Point(x, y);
        return new Triangle(points);
    }

    @Override
    public String toString() {
        String result = "Треугольник с вершинами в точках " + points +
                "\n" + "Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea();
        return result;
    }
//
//    @Override
//    public void move(Point vect) {
//        System.out.println("я лечу");
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return points.equals(triangle.points);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(points);
//    }
//
//
//    @Override
//    public void rotate(double angle) {
//
//    }
//
//    @Override
//    public void scale(double scale) {
//
//    }
}
