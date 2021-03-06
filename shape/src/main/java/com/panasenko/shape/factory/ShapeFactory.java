package com.panasenko.shape.factory;

import com.panasenko.shape.entity.Shape;
import com.panasenko.shape.exception.ShapeException;

import java.util.List;

public abstract class ShapeFactory {
    public abstract Shape getInstance(List<Integer> parameterList) throws ShapeException;
}
