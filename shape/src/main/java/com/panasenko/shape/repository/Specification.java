package com.panasenko.shape.repository;

import com.panasenko.shape.entity.Shape;

public interface Specification <T extends Shape>{
    boolean specify(T t);
}
