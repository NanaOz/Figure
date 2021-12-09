package com.company.helper;

import com.company.figure.Point;
import com.company.factory.*;
import java.util.*;

public class FigureCreateHelper {

    /**
     * @return Создание точек (сколько ввел пользователь)
     */
    public static List<Point> createPointFromInput() {
        ArrayList<Point> points = new ArrayList<>();
        boolean itContinues = true;
        double x, y;
        while (itContinues || points.size() < 2) {
            x = ScannerHelper.getDoubleFromInput("Введите x: ");
            y = ScannerHelper.getDoubleFromInput("Введите y: ");
            points.add(new Point(x, y));
            itContinues = ScannerHelper.isYes("Ввести еще координату? ");
            if (points.size() < 2 && !itContinues) {
                System.out.println("Нужно ввести минимум 2 координаты");
            }
        }
        return points;
    }

    /**
     * @param points Создание фигуры (из фабрики)по списку точек
     */
    public static FigureCreator getFigureFactory(List<Point> points) {
        FigureCreator factory;
        switch (points.size()) {
            case 2:
                factory = new CircleCreator();
                break;
            case 3:
                factory = new TriangleCreator();
                break;
            case 4:
                factory = new RectangleCreator();
                break;
            default:
                factory = new PolygonCreator();
        }
        return factory;
    }
}

