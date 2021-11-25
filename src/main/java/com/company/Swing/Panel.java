package com.company.Swing;

import com.company.Circle;
import com.company.Figure;
import com.company.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {
    private List<Figure> figures;
//исправить на ArrayList мб ?
    public Panel(List<Figure> figures){
        this.figures = figures;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //интернет советы! Нужно проверить на сколько они верны!!!!!!!!!1
        for (Figure figure: figures) {
            ArrayList<Point> points = figure.getPoints();
            if (figure instanceof Circle){
                Circle circle = (Circle)figure;
                double x1 = points.get(0).getX();
                double y1 = points.get(0).getY();
                g2.drawOval((int)(x1-circle.getRadius()),(int)(y1-circle.getRadius()),(int)circle.getRadius()*2,(int)circle.getRadius()*2);
            }
            else {
                for (int i = 0; i < points.size() - 1; i++) {
                    double x1 = points.get(i).getX();
                    double y1 = points.get(i).getY();
                    double x2 = points.get(i + 1).getX();
                    double y2 = points.get(i + 1).getY();
                    g2.draw(new Line(x1, y1, x2, y2));
                }
                double x1 = points.get(points.size() - 1).getX();
                double y1 = points.get(points.size() - 1).getY();
                double x2 = points.get(0).getX();
                double y2 = points.get(0).getY();
                g2.draw(new Line(x1, y1, x2, y2));
            }
        }
    }

}
