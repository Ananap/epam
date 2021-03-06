package com.panasenko.shape.repository.impl;

import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.repository.Specification;
import com.panasenko.shape.service.impl.TriangleServiceImpl;

public class RightTriangleSpecification implements Specification<Triangle> {
    @Override
    public boolean specify(Triangle triangle) {
        TriangleServiceImpl service = new TriangleServiceImpl();
        boolean result = service.isTriangleRight(triangle);
        return result;
    }
}
