package com.company.figure;

import com.company.Figure;

import java.util.List;
import java.util.Objects;

public class Polygon extends Figure {

    public Polygon() {
    }

    public Polygon(List<Point> points) {
        super(points);
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

    @Override
    public boolean containPoint(int x, int y, int multiplierX, int multiplierY) {
        boolean flag = false;
        for (int i = 0; i < this.getPoints().size(); i++) {
            int j = i == this.getPoints().size() - 1 ? 0 : i + 1;
            double x1 = this.getPoints().get(i).getX() * multiplierX;
            double x2 = this.getPoints().get(j).getX() * multiplierX;
            double y1 = this.getPoints().get(i).getY() * multiplierY;
            double y2 = this.getPoints().get(j).getY() * multiplierY;

            if(x2-x1!=0) {
                double a = (y2 - y1) / (x2 - x1);
                double b = y1 - a * x1;
                if ((Math.abs(y - (int) (a * x + b)) <= 2)) flag = true;
            }
            else{
                if ((Math.abs(x - x1) <= 2)&&(y>=Math.min(y1, y2) && y<=Math.max(y1, y2))) flag = true;
            }
        }
        return flag;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon figure = (Polygon) o;
        return points.equals(figure.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "с вершинами в точках: " + points + "\nХарактеристики: "
                + "\nПериметр: " + getPerimeter() + "\nПлощадь: " + getArea() + "\nЦентр фигуры: " + getCenter();
    }

}
