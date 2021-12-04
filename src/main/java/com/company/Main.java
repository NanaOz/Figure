package com.company;

import com.company.Swing.Canvas;
import com.company.helper.FigureCreateHelper;

public class Main {

    public static void main(String[] args) {
        startMenu();
    }

    public static final String FILE_NAME = "template.txt";

    public static void startMenu() {
        Menu menu = new Menu(FigureCreateHelper.getFigureByFile(FILE_NAME), FILE_NAME);
        menu.existingFigure();
        new Canvas();
        menu.start();

    }


}