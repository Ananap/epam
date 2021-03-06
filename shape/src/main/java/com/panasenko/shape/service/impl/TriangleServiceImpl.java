package com.panasenko.shape.service.impl;

import com.panasenko.shape.entity.Side;
import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.exception.ShapeException;
import com.panasenko.shape.service.TriangleService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class TriangleServiceImpl implements TriangleService {
    final static Logger logger = LogManager.getLogger(TriangleServiceImpl.class);

    public boolean isTriangle(Triangle triangle) {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        double a = side.getA();
        double b = side.getB();
        double c = side.getC();
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    public boolean isTriangleIsosceles(Triangle triangle) {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        return side.getA() == side.getB() || side.getB() == side.getC() || side.getC() == side.getA();
    }

    public boolean isTriangleEquilateral(Triangle triangle) {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        return side.getA() == side.getB() && side.getB() == side.getC() && side.getC() == side.getA();
    }

    public boolean isTriangleRight(Triangle triangle) {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        double a = side.getA();
        double b = side.getB();
        double c = side.getC();
        return Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)
                || Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)
                || Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
    }

    public boolean isTriangleObtuse(Triangle triangle) throws ShapeException {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        ArrayList<Double> sidesTriangle = side.sortDescSide();
        return Math.pow(sidesTriangle.get(0), 2) > Math.pow(sidesTriangle.get(1), 2) + Math.pow(sidesTriangle.get(2), 2);
    }

    public boolean isTriangleAcute(Triangle triangle) throws ShapeException {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        ArrayList<Double> sidesTriangle = side.sortDescSide();
        return Math.pow(sidesTriangle.get(0), 2) < Math.pow(sidesTriangle.get(1), 2) + Math.pow(sidesTriangle.get(2), 2);
    }

    public double calculatePerimeter(Triangle triangle) {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        double perimeter = side.getA() + side.getB() + side.getC();
        logger.debug("Perimeter calculated: " + perimeter);
        return perimeter;
    }

    public double calculateSquare(Triangle triangle) {
        Side side = new Side(triangle.getFirstPoint(), triangle.getSecondPoint(), triangle.getThirdPoint());
        double semiPerimeter = calculatePerimeter(triangle) / 2;
        double square = Math.sqrt(
                semiPerimeter
                        * (semiPerimeter - side.getA())
                        * (semiPerimeter - side.getB())
                        * (semiPerimeter - side.getC()));
        logger.debug("Square calculated: " + square);
        return square;
    }
}
