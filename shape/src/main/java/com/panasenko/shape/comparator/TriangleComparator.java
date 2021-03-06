package com.panasenko.shape.comparator;

import com.panasenko.shape.entity.Shape;
import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.entity.TriangleWareHouse;

import java.util.Comparator;

public enum TriangleComparator {
    ID((triangle, triangle1) ->  triangle.getId() - triangle1.getId()),
    FIRST_POINT_X((triangle, triangle1) -> ((Triangle)triangle).getFirstPoint().getX() -
            ((Triangle)triangle1).getFirstPoint().getX()),
    FIRST_POINT_Y((triangle, triangle1) -> ((Triangle)triangle).getFirstPoint().getY() -
            ((Triangle)triangle1).getFirstPoint().getY()),
    SECOND_POINT_X((triangle, triangle1) -> ((Triangle)triangle).getSecondPoint().getX() -
            ((Triangle)triangle1).getSecondPoint().getX()),
    SECOND_POINT_Y((triangle, triangle1) -> ((Triangle)triangle).getSecondPoint().getY() -
            ((Triangle)triangle1).getSecondPoint().getY()),
    THIRD_POINT_X((triangle, triangle1) -> ((Triangle)triangle).getThirdPoint().getX() -
            ((Triangle)triangle1).getThirdPoint().getX()),
    THIRD_POINT_Y((triangle, triangle1) -> ((Triangle)triangle).getThirdPoint().getY() -
            ((Triangle)triangle1).getThirdPoint().getY()),
    PERIMETER((triangle, triangle1) -> Double.compare(TriangleWareHouse.getInstance().
                    getData(triangle.getId()).getPerimeter(),
            TriangleWareHouse.getInstance().getData(triangle1.getId()).getPerimeter())),
    SQUARE((triangle, triangle1) -> Double.compare(TriangleWareHouse.getInstance().
                    getData(triangle.getId()).getSquare(),
            TriangleWareHouse.getInstance().getData(triangle1.getId()).getSquare()));

    private final Comparator<Shape> comparator;

    TriangleComparator(Comparator<Shape> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Shape> getComparator() {
        return comparator;
    }
}
