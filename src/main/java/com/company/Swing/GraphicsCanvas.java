package com.company.Swing;

import com.company.figure.Circle;
import com.company.Figure;
import com.company.figure.Point;
import com.sun.source.tree.Tree;

import java.awt.*;
import java.util.List;
import java.util.TreeMap;

public class GraphicsCanvas extends Canvas {

    private TreeMap<String, Figure> figures;
    public int multiplierX;
    public int multiplierY;


    public GraphicsCanvas(TreeMap<String, Figure> figures) {
        super();
        this.figures = figures;
    }

    @Override
    public void paint(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        int startX = 0;
        int startY = 0;
        Graphics canvas = (Graphics) g.create(startX, startY, width, height);
        canvas.setColor(Color.LIGHT_GRAY);
        canvas.fillRect(0, 0, width, height);
        canvas.setColor(Color.BLACK);
        canvas.drawLine(width / 2, 0, width / 2, height);
        canvas.drawLine(0, height / 2, width, height / 2);

        //stream().toList() ПОСМОТРЕТЬ
        if (figures.size() > 0) {
            double minX = figures.values().stream().toList().get(0).getPoints().get(0).getX();
            double minY = figures.values().stream().toList().get(0).getPoints().get(0).getY();
            double maxX = figures.values().stream().toList().get(0).getPoints().get(0).getX();
            double maxY = figures.values().stream().toList().get(0).getPoints().get(0).getY();
            for (Figure figure : figures.values()) {
                for (Point point : figure.getPoints()) {
                    if (point.getX() < minX) minX = point.getX();
                    if (point.getX() > maxX) maxX = point.getX();
                    if (point.getY() < minY) minY = point.getY();
                    if (point.getY() > maxY) maxY = point.getY();
                }
            }
            multiplierX = (int) (this.getWidth() * 0.9 / (maxX - minX));
            multiplierY = (int) (this.getHeight() * 0.9 / (maxY - minY));
            for (Figure figure : figures.values()) {
                drawFigures(g, figure, multiplierX, multiplierY);
            }
        }
    }

    public void drawFigures (Graphics g, Figure figure, int multiplierX, int multiplierY){
//        Graphics canvas = (Graphics) g.create();
        List<Point> points = figure.getPoints();
            if (figure instanceof Circle) {
                int multiplier = (int)Math.min(multiplierX, multiplierY);
                Circle circle = (Circle) figure;
                int x1 = (int) circle.getCenter().getX() * multiplierX;
                int y1 = (int) circle.getCenter().getY() * multiplierY;
                int radius = (int) circle.getRadius() *multiplier;
                g.drawOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
            } else {
                for (int i = 0; i < figure.getPoints().size() - 1; i++) {
                    int x1 = (int) figure.getPoints().get(i).getX() * multiplierX;
                    int y1 = (int) figure.getPoints().get(i).getY() * multiplierY;
                    int x2 = (int) figure.getPoints().get(i + 1).getX() * multiplierX;
                    int y2 = (int) figure.getPoints().get(i + 1).getY() * multiplierY;
                    g.drawLine(x1, y1, x2, y2);
                }
                int x1 = (int) figure.getPoints().get(figure.getPoints().size() - 1).getX() * multiplierX;
                int y1 = (int) figure.getPoints().get(figure.getPoints().size() - 1).getY() * multiplierY;
                int x2 = (int) figure.getPoints().get(0).getX() * multiplierX;
                int y2 = (int) figure.getPoints().get(0).getY() * multiplierY;
                g.drawLine(x1, y1, x2, y2);
            }
        }

    public void repaintGraphics(TreeMap<String, Figure> figures) {
        this.figures = figures;
        this.repaint();
    }
}
