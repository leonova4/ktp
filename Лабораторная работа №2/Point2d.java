package com.company;
public class Point2d {
    protected double xCoord;
    protected double yCoord;
    // конструктор инициализации
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    //конструктор заданный по умолчанию
    public Point2d () {
        this(0, 0);
    }
    //возвращение координаты x
    public double getX () {
        return xCoord;
    }
    //возвращение координаты у
    public double getY () {
        return yCoord;
    }
    // установка значения координаты х
    public void setX ( double val) {
        xCoord = val;
    }
    // установка значения координаты у
    public void setY ( double val) {
        yCoord = val;
    }
    //Метод для сравнения значения двух объектов Point2d
    public boolean isEqual2D (com.company.Point2d object) {
        return this.xCoord == object.xCoord && this.yCoord == object.yCoord;
    }
}