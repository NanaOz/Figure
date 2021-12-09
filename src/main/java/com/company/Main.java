package com.company;

import com.company.Swing.MyWindow;

public class Main {
    static final String file = ("src/main/java/com/company/data/template.txt");

    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu() {
        //раскомментировать при первом запуске программы
        //      Menu.existingFigure();
        //     Menu.saveToFile(Menu.figures, file);

        Menu menu = new Menu(Menu.initializeFromFile(file));

        new MyWindow(Menu.figures);
        menu.start();

    }


}