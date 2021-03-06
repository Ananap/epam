package com.panasenko.shape.observer;

import com.panasenko.shape.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    public TriangleEvent(Triangle inputSource) {
        super(inputSource);
    }
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
