package com.panasenko.shape.entity;

import com.panasenko.shape.exception.ShapeException;

import java.util.ArrayList;
import java.util.Collections;

public class Side {
    private double a;
    private double b;
    private double c;

    public Side(CustomPoint firstPoint, CustomPoint secondPoint, CustomPoint thirdPoint) {
        this.a = findSideOfTriangle(firstPoint, secondPoint);
        this.b = findSideOfTriangle(firstPoint, thirdPoint);
        this.c = findSideOfTriangle(secondPoint, thirdPoint);
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }


    public double findSideOfTriangle(CustomPoint firstPoint, CustomPoint secondPoint) {
        double projectionX = firstPoint.getX() - secondPoint.getX();
        double projectionY = firstPoint.getY() - secondPoint.getY();
        return Math.sqrt(Math.pow(projectionX, 2) + Math.pow(projectionY, 2));
    }

    public ArrayList<Double> sortDescSide() throws ShapeException {
        if (a == 0 || b == 0 || c == 0) {

            throw new ShapeException("Sides are null");
        } else {
            ArrayList<Double> sortedSides = new ArrayList<>();
            sortedSides.add(a);
            sortedSides.add(b);
            sortedSides.add(c);
            Collections.sort(sortedSides);
            return sortedSides;
        }
    }
}
