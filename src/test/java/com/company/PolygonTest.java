package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    @Test
    void calculateArea() {
        //для квадрата: КОСЯК
        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(3, 2), new Point(3, 8), new Point(10, 8), new Point(10, 2));
        Rectangle rectangle = new Rectangle(rectanglePoints);
        rectangle.calculateArea();
        Assertions.assertEquals(rectangle.area, 42);
        //для треугольника: ВСЕ ОК
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
        Triangle triangle = new Triangle(trianglePoints);
        triangle.calculateArea();
        Assertions.assertEquals(triangle.area, 6);
    }

    @Test
    void calculatePerimeter() {
        //для квадрата: все ОК
        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(3, 2), new Point(3, 8), new Point(10, 8), new Point(10, 2));
        Rectangle rectangle = new Rectangle(rectanglePoints);
        rectangle.calculatePerimeter();
        Assertions.assertEquals(rectangle.perimeter, 26);
        //для треугольника: все ок
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
        Triangle triangle = new Triangle(trianglePoints);
        triangle.calculateArea();
        Assertions.assertEquals(triangle.perimeter, 12);

    }

    @Test
    void calculateFigureCenter() {
        //для прямоугольника: ВСЕ ОК
        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(4, 4), new Point(4, 6), new Point(6, 6), new Point(6, 4));
        Rectangle rectangle = new Rectangle(rectanglePoints);
        rectangle.calculateFigureCenter();
        Assertions.assertEquals(rectangle.figureCenter.getX(), 5);
        Assertions.assertEquals(rectangle.figureCenter.getY(), 5);

        //для треугольника: ВСЕ ОК
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(5, 3), new Point(4, 6));
        Rectangle triangle = new Rectangle(trianglePoints);
        triangle.calculateFigureCenter();
        Assertions.assertEquals(triangle.figureCenter.getX(), 3);
        Assertions.assertEquals(triangle.figureCenter.getY(), 3);

    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}