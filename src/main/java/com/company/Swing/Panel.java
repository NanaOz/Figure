package com.company.Swing;

import com.company.Circle;
import com.company.Figure;
import com.company.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {

    private final List<Figure> figures;

    public Panel(List<Figure> figures){
        this.figures = figures;
    }

    public void drawFigures (List<Figure> figures){

    }

    @Override
    public void paintComponent(Graphics g){
//        g.setColor(Color.BLACK);
//        g.drawLine(50, 50, 100 , 100);
//        g.fillRect(50, 50, 200, 200);
        Graphics2D g2 = (Graphics2D) g.create(0, 0, 2000, 2000);
//        super.paintComponent(g2);
        g2.setColor(Color.LIGHT_GRAY);

        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(Color.BLACK);


        int multiplayer = 10;
        for (Figure figure: figures) {
            ArrayList<Point> points = figure.getPoints();
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
