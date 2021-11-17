package com.company;

import com.company.factory.CircleCreator;
import com.company.factory.FigureCreator;
import com.company.factory.RectangleCreator;
import com.company.factory.TriangleCreator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<Figure>();

        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(3, 3), new Point(6, 8), new Point(12, 5));
        Triangle triangle = new Triangle(trianglePoints);

        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(5, 3), new Point(7, 5), new Point(2, 6), new Point(4, 6));
        Rectangle rectangle = new Rectangle(rectanglePoints);

        ArrayList<Point> circlePoints = new ArrayList<>();
        Collections.addAll(circlePoints, new Point(3, 3), new Point(6, 8));
        Circle circle = new Circle(circlePoints);

        Collections.addAll(figures, triangle, rectangle,circle);
        menu(figures);
    }

    public static void menu(List<Figure> figures) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите нужный пункт меню");
            System.out.println("1. Вывести все фигуры");
            System.out.println("2. Добавить фигуру");
            System.out.println("3. Изменить фигуру");
            System.out.println("4. Удалить фигуру");
            System.out.println("0. Выход");

            int num = in.nextInt();
            switch (num) {
                case 0:
                    System.exit(0);
                case 1:
                    printFigures(figures);
                    break;
                case 2:
                    System.out.println("Какую фигуру хотите создать?");
                    FigureCreator figureCreator;
                    figureCreator = selectFigure();
                    Figure figure = figureCreator.createFigure();
                    figures.add(figure);
                    break;
                case 3:
                    printFigures(figures);
                    System.out.println("Введите номер фигуры, которую хотите изменить:");
                    num = in.nextInt();
                    System.out.println("Как вы хотите изменить фигуру?");
                    System.out.println("1. Изменить масштаб");
                    System.out.println("2. Повернуть фигуру");
                    System.out.println("3. Переместить фигуру");
                    int num2 = in.nextInt();

                    //figures.set ();
                    break;
                case 4:
                    printFigures(figures);
                    System.out.println("Введите номер фигуры, которую нужно удалить:");
                    num = in.nextInt();
                    figures.remove(num - 1);
                    break;
            }
        }
    }

    static void printFigures(List<Figure> figures) {
        int i = 1;
        for (Figure f : figures) {
            System.out.println(i + ". " + f);
            i++;
        }
    }

    static FigureCreator selectFigure() {
        System.out.println("Выберете какую фигуру создать:");
        System.out.println("1. Треугольник");
        System.out.println("2. Круг");
        System.out.println("3. Прямоугольник");
        FigureCreator figureCreator;
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        switch (num) {
            case 1:
                figureCreator = new TriangleCreator();
                break;
            case 2:
                figureCreator = new CircleCreator();
                break;
            case 3:
                figureCreator = new RectangleCreator();
                break;
            default:
                System.out.println("Введите правльное значение");
                return selectFigure();
        }
        return figureCreator;
    }
}
