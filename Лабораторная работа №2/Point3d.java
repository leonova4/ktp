package com.company;
public class Point3d extends Point2d{
    private double zCoord;

    public Point3d (double x, double y, double z){
        xCoord =x;
        yCoord = y;
        zCoord = z;
    }
// конструктор инициализации
    public Point3d (){
        this(0, 0, 0);
    }
//конструктор по умолчанию
    public double getZ(){
        return zCoord;
    }
// возвращение координаты  z
    public void SetZ(double val){
        zCoord = val;
    }
// сравнение двух объектов - равенство координат точки
    public boolean CompareCoord3d(Point3d object){
        return this.xCoord == object.xCoord && this.yCoord == object.yCoord && this.zCoord == object.zCoord;
    }
//метод для сравнения значений двух объектов Point3d
    public double distanceTo (Point3d object) {
        return Math.floor(Math.sqrt(Math.pow(object.xCoord - this.xCoord, 2) + Math.pow(object.yCoord - this.yCoord, 2) + Math.pow(object.zCoord - this.zCoord, 2)) * 100)/100;
    }
}
