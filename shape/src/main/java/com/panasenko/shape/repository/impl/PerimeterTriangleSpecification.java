package com.panasenko.shape.repository.impl;

import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.entity.TriangleRecorder;
import com.panasenko.shape.entity.TriangleWareHouse;
import com.panasenko.shape.repository.Specification;

public class PerimeterTriangleSpecification implements Specification<Triangle> {
    private double from;
    private double to;

    public PerimeterTriangleSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWareHouse wareHouse = TriangleWareHouse.getInstance();
        TriangleRecorder triangleRecorder = wareHouse.getData(triangle.getId());
        double perimeter = triangleRecorder.getPerimeter();
        boolean result = perimeter >= from && perimeter <= to;
        return result;
    }
}
