package com.company;

import com.company.figure.Circle;
import com.company.figure.Point;
import com.company.figure.Rectangle;
import com.company.figure.Triangle;
import com.company.helper.FigureCreateHelper;
import com.company.helper.ScannerHelper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class Menu {

    private static final String SELECT_ACTION = "Выберите действие: ";
    private static final String INCORRECT_INPUT = "Такого действия не существует!";
    public static TreeMap<String, Figure> figures;
    static int id = 1;

    public Menu(TreeMap<String, Figure> figures) {
        this.figures = figures;
    }

    /**
     * Необходим при первом запуске программы.
     */
    public static void existingFigure() {
        figures = new TreeMap<String, Figure>();

        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
        Triangle triangle = new Triangle(trianglePoints);

        ArrayList<Point> rectanglePoints = new ArrayList<>();
        Collections.addAll(rectanglePoints, new Point(3, 2), new Point(3, 8), new Point(10, 8), new Point(10, 2));
        Rectangle rectangle = new Rectangle(rectanglePoints);

        ArrayList<Point> circlePoints = new ArrayList<>();
        Collections.addAll(circlePoints, new Point(2, 2), new Point(2, 4));
        Circle circle = new Circle(circlePoints);

        figures.put(String.valueOf(id), triangle);
        id++;
        figures.put(String.valueOf(id), rectangle);
        id++;
        figures.put(String.valueOf(id), circle);
        id++;
    }

    public static void saveToFile(TreeMap<String, Figure> figures, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
       oos.writeObject(figures);
            System.out.printf("Объект записан\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static TreeMap<String, Figure> initializeFromFile(String file) {
        TreeMap<String, Figure> figures = new TreeMap<String, Figure>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            figures = (TreeMap<String, Figure>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return figures;
    }

    private static final String MAIN_MENU = "Выберите нужный пункт меню:"
            + "\n\t1 - Вывести все фигуры"
            + "\n\t2 - Создать фигуру"
            + "\n\t3 - Изменить фигуру"
            + "\n\t4 - Сохранить файл"
            + "\n\t0 - Выход";

    private static final String change_menu = "\n\t1 - Повернуть"
            + "\n\t2 - Переместить"
            + "\n\t3 - Увеличить"
            + "\n\t4 - Удалить"
            + "\n\t0 - Вернуться назад\n";

    public static void start() {
        System.out.println("--------WELCOME--------");
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(MAIN_MENU);
            switch (ScannerHelper.getIntFromInput(SELECT_ACTION)) {
                case 1:
                    displayAllFigures();
                    break;
                case 2:
                    addFigure();
                    break;
                case 3:
                    startActionFigureMenu();
                    break;
                case 4:
                    saveToFile(figures, Main.file);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println(INCORRECT_INPUT);
                    break;
            }
        }
        ScannerHelper.close();
    }

    /**
     * Отобразить все фигуры
     */
    private static void displayAllFigures() {
        for (String key : figures.keySet()) {
            System.out.println("\nСтрока № " + key + ": " + figures.get(key));
        }
    }

    /**
     * Добавление фигуры
     */
    public static void addFigure() {
        List<Point> points = FigureCreateHelper.createPointFromInput();
        Figure createdFigure = FigureCreateHelper.getFigureFactory(points).createFigure(points);
        System.out.println("Добавлена фигура:" + createdFigure);
        figures.put(String.valueOf(id), createdFigure);
        id++;
    }

    /**
     * Выброб конкретной фигуры (для ее изменения)
     */
    public static void startActionFigureMenu() {
        boolean validate;
        String key;
        do {
            key = String.valueOf(ScannerHelper.getIntFromInput("\nДоступные фигуры:\n " + figures.keySet() + "\nВведите номер: "));
            validate = figures.containsKey(key);
        } while (!validate);
        actionFigure(key);
    }

    private static void actionFigure(String id) {
        Figure figure = figures.get(id);
        boolean isAction = true;
        System.out.println("\nВы выбрали: " + figure + "\nЧто необходимо сделать с фигурой?");
        while (isAction) {
            switch (ScannerHelper.getIntFromInput(change_menu + SELECT_ACTION)) {
                case 1:
                    rotateFigure(figure);
                    break;
                case 2:
                    moveFigure(figure);
                    break;
                case 3:
                    scaleFigure(figure);
                    break;
                case 4:
                    removeFigure(id);
                    break;
                case 0:
                    isAction = false;
                    break;
                default:
                    System.out.println("Введено некорректное значение!");
                    break;
            }
        }
    }

    /**
     * Поворот фигуры
     */
    private static void rotateFigure(Figure figure) {
        System.out.println("Введите на сколько градусов повернуть фигуру: ");
        double angle = ScannerHelper.readDouble();
        figure.rotate(angle);
        System.out.println(figure);
    }

    /**
     * Увеличение фигуры
     */
    private static void scaleFigure(Figure figure) {
        System.out.println("На сколько вы хотите увеличить вашу фигуру: ");
        double size = ScannerHelper.readDouble();
        figure.scale(size);
        System.out.println(figure);
    }

    /**
     * Перемещение фигуры
     */
    private static void moveFigure(Figure figure) {
        System.out.println("Введите направление, для перемещения фигуры: ");
        double x = ScannerHelper.getDoubleFromInput("Введите x: ");
        double y = ScannerHelper.getDoubleFromInput("Введите y: ");
        figure.move(new Point(x, y));
        System.out.println(figure);
    }

    /**
     * Удалить фигуру
     */
    public static void removeFigure(String id) {
        figures.remove(id);
        System.out.println("Фигура удалена\n");
    }
}
