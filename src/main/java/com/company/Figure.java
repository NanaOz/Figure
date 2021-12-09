package com.company;

import com.company.figure.Circle;
import com.company.figure.Point;
import com.company.figure.Rectangle;
import com.company.figure.Triangle;
import com.company.interfaces.IMovable;
import com.company.interfaces.IRotatable;
import com.company.interfaces.IScalable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "Triangle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle")
})
public abstract class Figure implements IMovable, IRotatable, IScalable, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected List<Point> points;
    protected Point figureCenter;
    protected double area;
    protected double perimeter;

    public Figure() {}

    public Figure(List<Point> points) {
        this.points = points;
        this.calculateCenter();
        this.calculateArea();
        this.calculatePerimeter();
    }

    public abstract void calculateCenter () ;

    public abstract void calculateArea ();

    public abstract void calculatePerimeter();

    public Point getCenter () {
        return this.figureCenter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public List<Point> getPoints() {return points;}

    public abstract boolean containPoint (int x, int y, int  multiplierX, int multiplierY);
}
