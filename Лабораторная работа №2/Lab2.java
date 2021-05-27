package com.company;
import java.util.Scanner;
public class Lab2 {
    public static void main (String[] args){
        String readstr;

        Scanner reader = new Scanner(System.in);

        System.out.println("x1:");
        readstr = reader.nextLine();
        double x1 = Double.parseDouble(readstr);

        System.out.println("y1:");
        readstr = reader.nextLine();
        double y1 = Double.parseDouble(readstr);

        System.out.println("z1:");
        readstr = reader.nextLine();
        double z1 = Double.parseDouble(readstr);

        System.out.println("x2:");
        readstr = reader.nextLine();
        double x2 = Double.parseDouble(readstr);

        System.out.println("y2:");
        readstr = reader.nextLine();
        double y2 = Double.parseDouble(readstr);

        System.out.println("z2:");
        readstr = reader.nextLine();
        double z2 = Double.parseDouble(readstr);

        System.out.println("x3:");
        readstr = reader.nextLine();
        double x3 = Double.parseDouble(readstr);

        System.out.println("y3:");
        readstr = reader.nextLine();
        double y3 = Double.parseDouble(readstr);

        System.out.println("z3:");
        readstr = reader.nextLine();
        double z3 = Double.parseDouble(readstr);

        reader.close();

        Point3d coordinate1 = new Point3d(x1, y1, z1);
        Point3d coordinate2 = new Point3d(x2, y2, z2);
        Point3d coordinate3 = new Point3d(x3, y3, z3);

        if (!coordinate1.CompareCoord3d(coordinate2) && !coordinate2.CompareCoord3d(coordinate3) && !coordinate3.CompareCoord3d(coordinate1)) {
            System.out.println("Площадь тругольника из трех точек равна: " + computeArea(coordinate1, coordinate2, coordinate3));
        } else {
            System.out.println("Ошибка! Перепроверьте координаты!");
        }
    }

    public static Double computeArea(Point3d object1, Point3d object2, Point3d object3) {
        double a = object1.distanceTo(object2);
        double b = object2.distanceTo(object3);
        double c = object3.distanceTo(object1);
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
