package com.company;

import com.company.interfaces.IMovable;

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
        Point A = new Point(x, y);
        x = in.nextInt();
        y = in.nextInt();
        Point B = new Point(x, y);
        return new Circle(points);
    }

    public double radius(Point A, Point B) {
//        for (int i = 0; i < 3; i++) {
//            radius = Math.sqrt((Math.pow(points.get(i + 1).getX() - points.get(i).getX(), 2))
//                    + Math.pow(points.get(i + 1).getY() - points.get(i).getY(), 2));
//        }
//        radius = radius / 2;
        radius = (Math.sqrt((Math.pow(A.getX() - B.getX(), 2))
                + Math.pow(A.getY() - B.getY(), 2))) / 2;

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
        String result = "Круг с координатами " + points + " и радиусом " + radius +
                "\n" + "Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea();
        return result;
    }

    @Override
    public void move(Point vect) {

        System.out.println("я плыву");
    }

    @Override
    public void rotate(double angle) {

    }

    @Override
    public void scale(double scale) {

    }
}
