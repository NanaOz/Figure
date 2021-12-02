package com.company;

import com.company.figure.Point;
import com.company.figure.Rectangle;
import com.company.figure.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class PolygonTest {

    @Test
    void calculateAreaForRectanglePointN() {
        //для прямоугольника: ВСЕ ОК
        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(3, 2), new Point(3, 8), new Point(10, 8), new Point(10, 2));
        Rectangle rectangle = new Rectangle(rectanglePoints);
        rectangle.calculateArea();
        Assertions.assertEquals(rectangle.area, 42);
    }

    @Test
    void calculateAreaForRectanglePointNull() {
        //если коогрдинаты 0, то:
        ArrayList<Point> rectanglePoints0 = new ArrayList<>();
        Collections.addAll(rectanglePoints0, new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0));
        Rectangle rectangle0 = new Rectangle(rectanglePoints0);
        rectangle0.calculateArea();
        Assertions.assertEquals(rectangle0.area, 0);
    }

    @Test
    void calculateAreaForTrianglePoint() {
        //для треугольника: ВСЕ ОК
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
        Triangle triangle = new Triangle(trianglePoints);
        triangle.calculateArea();
        Assertions.assertEquals(triangle.area, 6);
    }

    @Test
    void calculateAreaForTrianglePointNull() {
        //если коогрдинаты 0, то:
        ArrayList<Point> trianglePoints0 = new ArrayList<>();
        Collections.addAll(trianglePoints0, new Point(0, 0), new Point(0, 0), new Point(0, 0));
        Triangle triangle0 = new Triangle(trianglePoints0);
        triangle0.calculateArea();
        Assertions.assertEquals(triangle0.area, 0);
    }

    @Test
    void calculatePerimeterForRectanglePoint() {
        //для прямоугольника: все ОК
        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(3, 2), new Point(3, 8), new Point(10, 8), new Point(10, 2));
        Rectangle rectangle = new Rectangle(rectanglePoints);
        rectangle.calculatePerimeter();
        Assertions.assertEquals(rectangle.perimeter, 26);
    }

    @Test
    void calculatePerimeterForRectanglePointNull() {
        //если коогрдинаты 0, то:
        ArrayList<Point> rectanglePoints0 = new ArrayList<>();
        Collections.addAll(rectanglePoints0, new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0));
        Rectangle rectangle0 = new Rectangle(rectanglePoints0);
        rectangle0.calculatePerimeter();
        Assertions.assertEquals(rectangle0.perimeter, 0);
    }

    @Test
    void calculatePerimeterForTrianglePoint() {
        //для треугольника: все ок
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
        Triangle triangle = new Triangle(trianglePoints);
        triangle.calculateArea();
        Assertions.assertEquals(triangle.perimeter, 12);
    }

    @Test
    void calculatePerimeterForTrianglePointNull() {
        //если коогрдинаты 0, то:
        ArrayList<Point> trianglePoints0 = new ArrayList<>();
        Collections.addAll(trianglePoints0, new Point(0, 0), new Point(0, 0), new Point(0, 0));
        Triangle triangle0 = new Triangle(trianglePoints0);
        triangle0.calculatePerimeter();
        Assertions.assertEquals(triangle0.perimeter, 0);
    }

    @Test
    void calculateFigureCenterForRectangle() {
        //для прямоугольника: ВСЕ ОК
        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(4, 4), new Point(4, 6), new Point(6, 6), new Point(6, 4));
        Rectangle rectangle = new Rectangle(rectanglePoints);
        rectangle.calculateCenter();
        Assertions.assertEquals(rectangle.figureCenter.getX(), 5);
        Assertions.assertEquals(rectangle.figureCenter.getY(), 5);
    }

    @Test
    void calculateFigureCenterForRectangleNull() {
        //если коогрдинаты 0, то:
        ArrayList<Point> rectanglePoints0 = new ArrayList<>();
        Collections.addAll(rectanglePoints0, new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0));
        Rectangle rectangle0 = new Rectangle(rectanglePoints0);
        rectangle0.calculateCenter();
        Assertions.assertEquals(rectangle0.figureCenter.getX(), 0);
        Assertions.assertEquals(rectangle0.figureCenter.getY(), 0);
    }

    @Test
    void calculateFigureCenterForTriangle() {
        //для треугольника: ВСЕ ОК
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(5, 3), new Point(4, 6));
        Rectangle triangle = new Rectangle(trianglePoints);
        triangle.calculateCenter();
        Assertions.assertEquals(triangle.figureCenter.getX(), 3);
        Assertions.assertEquals(triangle.figureCenter.getY(), 3);
    }

    @Test
    void calculateFigureCenterForTriangleNull() {
        //если коогрдинаты 0, то:
        ArrayList<Point> trianglePoints0 = new ArrayList<>();
        Collections.addAll(trianglePoints0, new Point(0, 0), new Point(0, 0), new Point(0, 0));
        Triangle triangle0 = new Triangle(trianglePoints0);
        triangle0.calculateCenter();
        Assertions.assertEquals(triangle0.figureCenter.getX(), 0);
        Assertions.assertEquals(triangle0.figureCenter.getY(), 0);
    }
}