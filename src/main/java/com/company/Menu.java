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
    static final File file = new File("src/main/java/com/company/data/figures.txt");

    private static final String SELECT_ACTION = "Выберите действие: ";
    private static final String INCORRECT_INPUT = "Такого действия не существует!";
    public static TreeMap<String, Figure> figures;
    static int id = 1;

    public Menu(TreeMap<String, Figure> figures){
        this.figures = figures;
    }

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

//        Collections.addAll(figures, triangle, rectangle, circle);
        figures.put(String.valueOf(id), triangle);
        id++;
        figures.put(String.valueOf(id), rectangle);
        id++;
        figures.put(String.valueOf(id), circle);
        id++;

//        Frame frame = new Frame(figures);
//        menu(figures);

//        try (FileWriter writer = new FileWriter("figures.txt", true)){
//            writer.write(triangle.toString());
//
//        }
//        catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }

//        menu(initializeFromFile(file));

    }

    private static void saveToFile(TreeMap<String, Figure>  figures, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
            oos.writeObject(figures);
            System.out.printf("Объект записан\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static ArrayList<Figure> initializeFromFile(File file) {
        ArrayList<Figure> f = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            f = (ArrayList<Figure>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
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

    public static void startMenu() {
        serializeAndDeserialize();
//        saveToFile (figures, file);
//        initializeFromFile (file);
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
    private static void addFigure() {
        List<Point> points = FigureCreateHelper.createPointFromInput();
        Figure createdFigure = FigureCreateHelper.getFigureFactory(points).createFigure(points);
        System.out.println("Добавлена фигура:" + createdFigure);
        figures.put(String.valueOf(id), createdFigure);
        id++;
    }

    /**
     * Выброб конкретной фигуры (для ее изменения)
     */
    private static void startActionFigureMenu() {
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
//        int vect = ScannerHelper.readInt();
        double x = ScannerHelper.getDoubleFromInput("Введите x: ");
        double y = ScannerHelper.getDoubleFromInput("Введите y: ");
        figure.move(new Point(x, y));
        System.out.println(figure);
    }

    /**
     * Удалить фигуру
     */
    private static void removeFigure(String id) {
        figures.remove(id);
        System.out.println("Фигура удалена\n");
    }

    @JsonAutoDetect
    public static class FigureCollection {
        public ArrayList<Figure> figures;

        public FigureCollection() {
            this.figures = new ArrayList<>();
        }
    }

    /**
     * Сериализация и десериализация JSON
     */
    private static void serializeAndDeserialize() {
        FigureCollection collection = new FigureCollection();
        collection.figures.addAll(figures.values());
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // Сериализация
        try {
            mapper.writeValue(writer, collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();

        System.out.println("result = " + result);

        // Десериализация
        try {
            collection = mapper.readValue(result, FigureCollection.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (Figure figure : collection.figures) {
            System.out.println(figure);
        }
    }
}
