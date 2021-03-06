package com.panasenko.shape.repository;

import com.panasenko.shape.entity.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeRepository {
    private List<Shape> shapeList;

    public ShapeRepository() {
        shapeList  = new ArrayList<>();
    }

    public List<Shape> getShapeList() {
        return Collections.unmodifiableList(shapeList);
    }

    public void addShapeList(Shape shape) {
        shapeList.add(shape);
    }

    public void removeShapeList(Shape shape) {
        shapeList.remove(shape);
    }

    public Shape get(int index) {
        return shapeList.get(index);
    }

    public Shape set(int index, Shape element) {
        return shapeList.set(index, element);
    }

    public List<Shape> query(Specification<Shape> specification) {
        List<Shape> list = shapeList.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }

    public List<Shape> sort(Comparator<Shape> type) {
        List<Shape> sortedList = shapeList.stream().sorted(type).collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ShapeRepository\n");
        sb.append(shapeList);
        return sb.toString();
    }
}
