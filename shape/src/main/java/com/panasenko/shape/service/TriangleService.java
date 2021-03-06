package com.panasenko.shape.service;

import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.exception.ShapeException;

public interface TriangleService {
    boolean isTriangle(Triangle triangle);
    boolean isTriangleIsosceles(Triangle triangle);
    boolean isTriangleRight(Triangle triangle);
    boolean isTriangleEquilateral(Triangle triangle);
    boolean isTriangleObtuse(Triangle triangle) throws ShapeException;
    boolean isTriangleAcute(Triangle triangle) throws ShapeException;
    double calculatePerimeter(Triangle triangle);
    double calculateSquare(Triangle triangle);
}
