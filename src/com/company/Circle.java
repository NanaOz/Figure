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
        System.out.println("Введите координаты центра и радиуса окружности:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        Point center = new Point(x, y);
        x = in.nextInt();
        y = in.nextInt();
        Point radius = new Point(x, y);
        return new Circle(points);
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
    public String toString() {
        String result = "Круг с центорм " + points + " и радиусом " + radius +
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
