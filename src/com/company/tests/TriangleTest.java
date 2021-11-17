package com.company.tests;

import com.company.Point;
import com.company.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @org.junit.jupiter.api.Test
    void calculateSides() {
//        Point pointA = new Point(0, 0);
//        Point pointB = new Point(4, 0);
//        Point pointC = new Point(0, 3);
//        Triangle t = new Triangle(pointA, pointB, pointC);
//        assertEquals(t.getSideAB(),4);
//        assertEquals(t.getSideAC(), 3);
//        assertEquals(t.getSideBC(), 5);
    }

    @org.junit.jupiter.api.Test
    void inputTriangle() {
    }

    @org.junit.jupiter.api.Test
    void getPerimeter() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(4, 0);
        Point pointC = new Point(0, 3);
        calculateSides();

    }

    @org.junit.jupiter.api.Test
    void getArea() {
    }
}