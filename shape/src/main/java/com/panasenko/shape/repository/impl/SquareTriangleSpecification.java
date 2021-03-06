package com.panasenko.shape.repository.impl;

import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.entity.TriangleRecorder;
import com.panasenko.shape.entity.TriangleWareHouse;
import com.panasenko.shape.repository.Specification;

public class SquareTriangleSpecification implements Specification<Triangle> {
    private double from;
    private double to;

    public SquareTriangleSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWareHouse wareHouse = TriangleWareHouse.getInstance();
        TriangleRecorder triangleRecorder = wareHouse.getData(triangle.getId());
        double square = triangleRecorder.getSquare();
        boolean result = square >= from && square <= to;
        return result;
    }
}
