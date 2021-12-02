package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

//    @Test
//    void inputFigureForTwoPoint() {
//        //если 2 координаты:
//        InputStream coordinate2 = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n4\n5".getBytes());
//        System.setIn(in);
//        int quantityOfPoints = 2;
//        ArrayList<Point> points = (ArrayList<Point>) Figure.inputFigure(quantityOfPoints);
//        System.setIn(coordinate2);
//        Assertions.assertEquals(points.get(0).getX(), 3);
//        Assertions.assertEquals(points.get(0).getY(), 2);
//        Assertions.assertEquals(points.get(1).getX(), 4);
//        Assertions.assertEquals(points.get(1).getY(), 5);
//        Assertions.assertNotEquals(points.size(), 0);
//    }
//
//    @Test
//    void inputFigureForThreePoint() {
//        //если 3 координаты:
//        InputStream coordinate3 = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n4\n5\n7\n2".getBytes());
//        System.setIn(in);
//        int quantityOfPoints = 3;
//        ArrayList<Point> points = (ArrayList<Point>) Figure.inputFigure(quantityOfPoints);
//        System.setIn(coordinate3);
//        Assertions.assertEquals(points.get(0).getX(), 3);
//        Assertions.assertEquals(points.get(0).getY(), 2);
//        Assertions.assertEquals(points.get(1).getX(), 4);
//        Assertions.assertEquals(points.get(1).getY(), 5);
//        Assertions.assertEquals(points.get(2).getX(), 7);
//        Assertions.assertEquals(points.get(2).getY(), 2);
//        Assertions.assertNotEquals(points.size(), 0);
//    }
//
//    @Test
//    void inputFigureForFourPoint() {
//        //если 4 координаты:
//        InputStream coordinate4 = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n4\n5\n7\n2\n9\n1".getBytes());
//        System.setIn(in);
//        int quantityOfPoints = 4;
//        ArrayList<Point> points = (ArrayList<Point>) Figure.inputFigure(quantityOfPoints);
//        System.setIn(coordinate4);
//        Assertions.assertEquals(points.get(0).getX(), 3);
//        Assertions.assertEquals(points.get(0).getY(), 2);
//        Assertions.assertEquals(points.get(1).getX(), 4);
//        Assertions.assertEquals(points.get(1).getY(), 5);
//        Assertions.assertEquals(points.get(2).getX(), 7);
//        Assertions.assertEquals(points.get(2).getY(), 2);
//        Assertions.assertEquals(points.get(3).getX(), 9);
//        Assertions.assertEquals(points.get(3).getY(), 1);
//        Assertions.assertNotEquals(points.size(), 0);
//    }

}