package com.company;

import com.company.interfaces.IMovable;
import com.company.interfaces.IRotatable;
import com.company.interfaces.IScalable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "Triangle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle")
})
public abstract class Figure implements IMovable, IRotatable, IScalable, Serializable {

    private static final long serialVersionUID = 1L;

    protected ArrayList<Point> points;
    protected Point figureCenter;
    protected double area;
    protected double perimeter;

    public Figure(ArrayList<Point> points) {

        this.points = points;
        this.calculateCenter();
    }

    public static ArrayList inputFigure (int quantityOfPoints){
        ArrayList <Point> points = new ArrayList<>();
        System.out.println("Введите координаты:");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < quantityOfPoints; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x, y));
        }
        System.out.println("Фигура добавлена\n");
        return points;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public abstract void calculateArea ();

    public abstract void calculatePerimeter();

    public Point getCenter () {
        return this.figureCenter;
    }

    public abstract void calculateCenter () ;

    public ArrayList<Point> getPoints() {return points;}
}
