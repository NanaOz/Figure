package com.company.helper;

import com.company.Figure;
import com.company.figure.Point;
import com.company.factory.*;
import com.sun.source.tree.Tree;

import java.util.*;

public class FigureCreateHelper {
    public static int id=1;

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

    public static String getKeyByFigure (TreeMap<String, Figure> figures, Figure figure){
        if (figures.containsValue(figure)) {
            for (Map.Entry <String, Figure>f: figures.entrySet()){
                if (f.getValue().equals(figure)){
                    return f.getKey();
                }

            }
        }
        return null;
    }
}

