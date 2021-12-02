package com.company.Swing;

import com.company.figure.Circle;
import com.company.Figure;
import com.company.figure.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel extends JPanel {

    private final List<Figure> figures;

    public Panel(List<Figure> figures){
        super();
        this.figures = figures;

    }

    public void drawFigures (List<Figure> figures){



    }

    @Override
    public void paintComponent(Graphics g){
       int width = 1000;
       int height = 1000;
       int startX = 0;
       int startY = 0;
        Graphics2D g2 = (Graphics2D) g.create(startX, startY, width, height);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, width, height);
        g2.setColor(Color.BLACK);
        g2.drawLine(width/2, 0, width/2, height);
        g2.drawLine(0, height/2, height/2, width);


        int multiplayer = 10;
        for (Figure figure: figures) {
            List<Point> points = figure.getPoints();
            if (figure instanceof Circle){
                Circle circle = (Circle)figure;
                int x1 = (int)circle.getCenter().getX()*multiplayer;
                int y1 = (int)circle.getCenter().getY()*multiplayer;
                g2.drawOval((int)(x1-circle.getRadius())*multiplayer,(int)(y1-circle.getRadius())*multiplayer,
                        (int)circle.getRadius()*2*multiplayer,
                        (int)circle.getRadius()*2*multiplayer);
            }
            else {
                for (int i = 0; i < points.size() - 1; i++) {
                    double x1 = points.get(i).getX()*multiplayer;
                    double y1 = points.get(i).getY()*multiplayer;
                    double x2 = points.get(i + 1).getX()*multiplayer;
                    double y2 = points.get(i + 1).getY()*multiplayer;
                    g2.draw(new Line(x1, y1, x2, y2));
                }
                double x1 = points.get(points.size() - 1).getX()*multiplayer;
                double y1 = points.get(points.size() - 1).getY()*multiplayer;
                double x2 = points.get(0).getX()*multiplayer;
                double y2 = points.get(0).getY()*multiplayer;
                g2.draw(new Line(x1, y1, x2, y2));
            }
        }

    }


}
