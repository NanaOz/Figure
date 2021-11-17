package com.company;

import java.util.ArrayList;

public abstract class Polygon extends Figure {

    public Polygon(ArrayList<Point> points) {
        super(points);
        this.calculateArea();
        this.calculatePerimeter();
        this.calculateFigureCenter();
    }

    public void calculateArea() {
        area = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            area += 0.5 * Math.abs(points.get(i).getX() * points.get(i + 1).getY()) - (points.get(i + 1).getX() * points.get(i).getY());
        }
    }

    public void calculatePerimeter() {
        perimeter = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            perimeter += Math.sqrt(Math.pow(points.get(i + 1).getX() - points.get(i).getX(), 2)
                    + Math.pow(points.get(i + 1).getY() - points.get(i).getY(), 2));
        }
        perimeter += Math.sqrt(Math.pow(points.get(0).getX() - points.get(points.size() - 1).getX(), 2)
                + Math.pow(points.get(0).getY() - points.get(points.size() - 1).getY(), 2));
    }

    public void calculateFigureCenter() {
        double sumX = 0;
        double sumY = 0;
        for (Point p : points) {
            sumX += p.getX();
            sumY += p.getY();
        }
        this.figureCenter = new Point(sumX / points.size(), sumY / points.size());
    }


    @Override
    public void move(Point vect) {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, new Point(points.get(i).getX() + vect.getX(), points.get(i).getY() + vect.getY()));
        }
    }

    @Override
    public void rotate(double angle) {
        angle *= Math.PI / 180;
        for (int i = 0; i < points.size(); i++) {
            double x = (points.get(i).getX() - figureCenter.getX()) * Math.cos(angle) - (points.get(i).getY() - figureCenter.getY()) * Math.sin(angle);
            double y = (points.get(i).getX() - figureCenter.getX()) * Math.cos(angle) + (points.get(i).getY() - figureCenter.getY()) * Math.sin(angle);
            points.set(i, new Point(x, y));
        }
    }

    @Override
    public void scale(double scale) {
        for (int i = 0; i < points.size(); i++) {
            double x = (points.get(i).getX() - figureCenter.getX()) * scale + figureCenter.getX();
            double y = (points.get(i).getY() - figureCenter.getY()) * scale + figureCenter.getY();
            points.set(i, new Point(x, y));
        }
    }
}
