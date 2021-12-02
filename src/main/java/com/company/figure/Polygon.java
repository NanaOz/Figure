package com.company.figure;

import com.company.Figure;

import java.util.List;
import java.util.Objects;

public class Polygon extends Figure {

    public Polygon(List<Point> points) {
        super(points);
        this.calculateArea();
        this.calculatePerimeter();
        this.calculateCenter();
    }

    /**
     * Расчет площади фигуры
     * по формуле Гауса 0.5*|X[i]*Y[i+1] - X[i+1]Y[i]|
     */
    public void calculateArea() {
        this.area = 0;
        for (int i = 0; i < (points.size() - 1); i++) {
            this.area += ((points.get(i).getX() * points.get(i + 1).getY())
                    - (points.get(i + 1).getX() * points.get(i).getY()));
        }

        this.area += ((points.get(points.size() - 1).getX() * points.get(0).getY())
                - (points.get(0).getX() * points.get(points.size() - 1).getY()));

        this.area = Math.abs(area / 2);
    }

    /**
     * Расчет периметра фигуры
     * sqrt((X[b]-X[a])^2+(Y[b]-Y[a])^2)
     */
    public void calculatePerimeter() {
        this.perimeter = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            this.perimeter += Math.sqrt(Math.pow(points.get(i + 1).getX() - points.get(i).getX(), 2)
                    + Math.pow(points.get(i + 1).getY() - points.get(i).getY(), 2));
        }
        this.perimeter += Math.sqrt(Math.pow(points.get(0).getX() - points.get(points.size() - 1).getX(), 2)
                + Math.pow(points.get(0).getY() - points.get(points.size() - 1).getY(), 2));
    }

    /**
     * Расчет центра фигуры
     */
    public void calculateCenter() {
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
        calculateArea();
        calculatePerimeter();
    }

    @Override
    public String toString() {
        String result = "\nМногоугольник с вершинами в точках: ";

        for (int i = 0; i < points.size(); i++) {
            result += points.get(i) + " ";
        }
        result += "\n*Характеристики: \nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea() + "\n";
        return result;
    }
}