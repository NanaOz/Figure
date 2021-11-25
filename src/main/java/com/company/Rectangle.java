package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Rectangle extends Polygon {

    public Rectangle(ArrayList<Point> points) {
        super(points);
    }

    public static Rectangle inputRectangle() {
        ArrayList<Point> points = new ArrayList<>();
        System.out.println("Введите координаты диагональных вершин прямоугольника:");
        Scanner in = new Scanner(System.in);
        int n = 4;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x, y));
        }
        return new Rectangle(points);
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
