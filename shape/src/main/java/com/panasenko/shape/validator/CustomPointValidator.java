package com.panasenko.shape.validator;

import com.panasenko.shape.entity.CustomPoint;

public class CustomPointValidator {
    private static final int MAX_COORDINATE = 100;
    private static final int MIN_COORDINATE = -100;

    public static boolean isPointsFromTriangle(CustomPoint firstPoint, CustomPoint secondPoint, CustomPoint thirdPoint){
        boolean result = validateCoordinate(firstPoint) && validateCoordinate(secondPoint) && validateCoordinate(thirdPoint);
        if (!result) {
            return false;
        }
        result = isSingleAxis(firstPoint.getX(), secondPoint.getX(), thirdPoint.getX())
                && isSingleAxis(firstPoint.getY(), secondPoint.getY(), thirdPoint.getY());
        return result;
    }

    private static boolean isSingleAxis (double coordinate1, double coordinate2, double coordinate3) {
        return coordinate1 != coordinate2 && coordinate2 != coordinate3 && coordinate3 != coordinate1;
    }

    private static boolean validateCoordinate(CustomPoint point) {
        return validateValue(point.getX()) && validateValue(point.getY());
    }

    private static boolean validateValue(int value) {
        return value < MAX_COORDINATE && value > MIN_COORDINATE;
    }
}
