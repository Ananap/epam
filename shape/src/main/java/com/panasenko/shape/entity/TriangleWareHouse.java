package com.panasenko.shape.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TriangleWareHouse {
    private static TriangleWareHouse instance;

    private Map<Integer, TriangleRecorder> data;
    static Logger logger = LogManager.getLogger(TriangleWareHouse.class);

    private TriangleWareHouse() {
        data = new HashMap<>();
    }

    public static TriangleWareHouse getInstance() {
        if (instance == null) {
            instance = new TriangleWareHouse();
        }
        return instance;
    }

    public TriangleRecorder getData(int id) {
        TriangleRecorder recorder = data.get(id);
        return recorder;
    }

    public void add(int id, TriangleRecorder parameters) {
        data.put(id, parameters);
        logger.debug("Adding successful");
    }

    public void remove(int id) {
        data.remove(id);
        logger.debug("Removed successful");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TriangleWareHouse\n");
        sb.append(data);
        return sb.toString();
    }
}
