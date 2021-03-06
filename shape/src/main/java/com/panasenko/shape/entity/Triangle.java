package com.panasenko.shape.entity;

import com.panasenko.shape.exception.ShapeException;

public class Triangle extends Shape {
    private CustomPoint firstPoint;
    private CustomPoint secondPoint;
    private CustomPoint thirdPoint;

    public Triangle() {}

    public Triangle(CustomPoint firstPoint, CustomPoint secondPoint, CustomPoint thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public CustomPoint getFirstPoint() {
        return firstPoint;
    }

    public CustomPoint getSecondPoint() {
        return secondPoint;
    }

    public CustomPoint getThirdPoint() {
        return thirdPoint;
    }

    public void setFirstPoint(CustomPoint firstPoint) throws ShapeException {
        if (firstPoint == null) {
            throw new ShapeException("Point is null");
        }
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(CustomPoint secondPoint) throws ShapeException {
        if (firstPoint == null) {
            throw new ShapeException("Point is null");
        }
        this.secondPoint = secondPoint;
    }

    public void setThirdPoint(CustomPoint thirdPoint) throws ShapeException {
        if (firstPoint == null) {
            throw new ShapeException("Point is null");
        }
        this.thirdPoint = thirdPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;
        if (firstPoint == null) {
            if (triangle.firstPoint != null) {
                return false;
            }
        } else if (!firstPoint.equals(triangle.firstPoint)) {
            return false;
        }
        if (secondPoint == null) {
            if (triangle.secondPoint != null) {
                return false;
            }
        } else if (!secondPoint.equals(triangle.secondPoint)) {
            return false;
        }
        if (thirdPoint == null) {
            return triangle.thirdPoint == null;
        } else return thirdPoint.equals(triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((firstPoint != null) ? firstPoint.hashCode() : 0);
        result = prime * result + ((secondPoint != null) ? secondPoint.hashCode() : 0);
        result = prime * result + ((thirdPoint != null) ? thirdPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("firstPoint=").append(firstPoint);
        sb.append(", secondPoint=").append(secondPoint);
        sb.append(", thirdPoint=").append(thirdPoint);
        sb.append('}');
        return sb.toString();
    }
}
