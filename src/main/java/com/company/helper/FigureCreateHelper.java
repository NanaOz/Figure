package com.company.helper;

import com.company.Figure;
import com.company.figure.Point;
import com.company.factory.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FigureCreateHelper {
    private static int LINE_NUM = 1;

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

    /**
     * @param fileName Из файла получаем список фигур, храним его в виде мапы. Где строка - ключ.
     */
//    public static TreeMap<String, Figure> getShapesByFile(String fileName) {
//        TreeMap<String, Figure> shapes = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
//        FigureCreator factory;
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while (reader.ready()) {
//                line = reader.readLine();
//                List<Point> points = definePoints(line, true);
//                if (points.size() > 1) {
//                    factory = getFigureFactory(points);
//                    shapes.put(String.valueOf(LINE_NUM), factory.createFigure(points));
//                }
//                LINE_NUM++;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Файл не найден");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return shapes;
//    }
//
//    private static List<Point> definePoints(String line, boolean displayed) {    // определение Точек
//        String[] points = line.split(";");
//        List<Point> listPoints = new ArrayList<>();
//        double x;
//        double y;
//        for (String point : points) {
//            point = point.replaceAll("[A-zА-я]|[\\[\\](){}]|=", "").trim().replace(",", " ");
//            try (Scanner scanner = new Scanner(point)) {
//                scanner.useLocale(Locale.US);
//                if (scanner.hasNextDouble()) {
//                    x = scanner.nextDouble();
//
//                    y = scanner.nextDouble();
//                    listPoints.add(new Point(x, y));
//                }
//            } catch (InputMismatchException e) {
//                if (displayed) System.out.println("В строке №" + LINE_NUM + " - произошла ошибка при считывании");
//                return listPoints;
//            } catch (NoSuchElementException e) {
//                if (displayed) System.out.println("В строке №" + LINE_NUM + " - нет пар координат!");
//                return listPoints;
//            }
//        }
//        int pointSize = listPoints.size();
//        if (pointSize < 2 && displayed) {
//            System.out.println("\nВ строке №" + LINE_NUM + " - " + pointSize
//                    + (pointSize == 0 ? " координат" : " координата")
//                    + ". Строка пропускается");
//        }
//        return listPoints;
//    }
}

