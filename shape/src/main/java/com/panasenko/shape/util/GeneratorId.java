package com.panasenko.shape.util;

public class GeneratorId {
    private static int id;
    public static int generateId(){
        return ++id;
    }
}
