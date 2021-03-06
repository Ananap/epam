package com.panasenko.shape.factory;

import com.panasenko.shape.entity.CustomPoint;
import com.panasenko.shape.entity.Shape;
import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.exception.ShapeException;
import com.panasenko.shape.validator.CustomPointValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class TriangleFactory extends ShapeFactory {
    final static Logger logger = LogManager.getLogger(TriangleFactory.class);

    @Override
    public Shape getInstance(List<Integer> parameterList) throws ShapeException {
        CustomPoint firstPoint = new CustomPoint(parameterList.get(0), parameterList.get(1));
        CustomPoint secondPoint = new CustomPoint(parameterList.get(2), parameterList.get(3));
        CustomPoint thirdPoint = new CustomPoint(parameterList.get(4), parameterList.get(5));
        if(!CustomPointValidator.isPointsFromTriangle(firstPoint, secondPoint, thirdPoint)){
            logger.error("Incorrect point values");
            throw new ShapeException("Incorrect point values");
        }
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        logger.info("Triangle was created");
        return triangle;
    }
}
