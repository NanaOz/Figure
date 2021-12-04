package com.company.Swing;

import com.company.figure.Circle;
import com.company.Figure;
import com.company.figure.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.TreeMap;

public class GraphicsCanvas extends Canvas {

    private List<Figure> figures;

    public GraphicsCanvas(List<Figure> figures){
        super();
        this.figures = figures;
    }

    public void paint (Graphics g) {
        int width = 1000;
        int height = 1000;
        int startX = 0;
        int startY = 0;
        Graphics canvas = (Graphics) g.create(startX, startY, width, height);
        canvas.setColor(Color.LIGHT_GRAY);
        canvas.fillRect(0, 0, width, height);
        canvas.setColor(Color.BLACK);
        canvas.drawLine(width / 2, 0, width / 2, height);
        canvas.drawLine(0, height / 2, width, height / 2);

        for (Figure figure : figures) {
            List<Point> points = figure.getPoints();
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                int x1 = (int) circle.getCenter().getX();
                int y1 = (int) circle.getCenter().getY();
                int radius = (int) circle.getRadius();
                canvas.drawOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
            } else {
                for (int i = 0; i < figure.getPoints().size() - 1; i++) {
                    int x1 = (int) figure.getPoints().get(i).getX();
                    int y1 = (int) figure.getPoints().get(i).getY();
                    int x2 = (int) figure.getPoints().get(i + 1).getX();
                    int y2 = (int) figure.getPoints().get(i + 1).getY();
                    canvas.drawLine(x1, y1, x2, y2);
                }
                int x1 = (int) figure.getPoints().get(figure.getPoints().size()-1).getX();
                int y1 = (int) figure.getPoints().get(figure.getPoints().size()-1).getY();
                int x2 = (int) figure.getPoints().get(0).getX();
                int y2 = (int) figure.getPoints().get(0).getY();
                canvas.drawLine(x1, y1, x2, y2);
            }
        }
    }
}
