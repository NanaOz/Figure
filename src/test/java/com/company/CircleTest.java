package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void calculateRadius() {
        //все ОК
        ArrayList<Point> circlePoints = new ArrayList<>();
        Collections.addAll(circlePoints, new Point(2, 2), new Point(2, 4));
        Circle circle = new Circle(circlePoints);
        circle.calculateRadius();
        Assertions.assertEquals(circle.getRadius(),2 );
        //если координаты 0, то:
        ArrayList<Point> circlePoints0 = new ArrayList<>();
        Collections.addAll(circlePoints0, new Point(0, 0), new Point(0, 0));
        Circle circle0 = new Circle(circlePoints0);
        circle0.calculateRadius();
        Assertions.assertEquals(circle0.getRadius(),0 );

    }

    @Test
    void calculateArea() {
        ArrayList<Point> circlePoints = new ArrayList<>();
        Collections.addAll(circlePoints, new Point(2, 2), new Point(2, 4));
        Circle circle = new Circle(circlePoints);
        circle.calculateArea();
        Assertions.assertEquals(circle.area,12.566370614359172 );
        //если координаты 0, то:
        ArrayList<Point> circlePoints0 = new ArrayList<>();
        Collections.addAll(circlePoints0, new Point(0, 0), new Point(0, 0));
        Circle circle0 = new Circle(circlePoints0);
        circle0.calculateArea();
        Assertions.assertEquals(circle0.area,0 );
    }

    @Test
    void calculatePerimeter() {
        ArrayList<Point> circlePoints = new ArrayList<>();
        Collections.addAll(circlePoints, new Point(2, 2), new Point(2, 4));
        Circle circle = new Circle(circlePoints);
        circle.calculatePerimeter();
        Assertions.assertEquals(circle.perimeter,12.566370614359172 );
        //если координаты 0, то:
        ArrayList<Point> circlePoints0 = new ArrayList<>();
        Collections.addAll(circlePoints0, new Point(0, 0), new Point(0, 0));
        Circle circle0 = new Circle(circlePoints0);
        circle0.calculatePerimeter();
        Assertions.assertEquals(circle0.perimeter,0 );
    }
}