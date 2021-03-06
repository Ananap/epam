package com.panasenko.shape.observer.impl;

import com.panasenko.shape.entity.Triangle;
import com.panasenko.shape.entity.TriangleRecorder;
import com.panasenko.shape.entity.TriangleWareHouse;
import com.panasenko.shape.observer.TriangleEvent;
import com.panasenko.shape.observer.TriangleObserver;
import com.panasenko.shape.service.impl.TriangleServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TriangleObserverImpl implements TriangleObserver {
    static Logger logger = LogManager.getLogger(TriangleObserverImpl.class);

    @Override
    public void parameterChanged(TriangleEvent event) {
        Triangle triangle = event.getSource();
        TriangleServiceImpl service = new TriangleServiceImpl();
        TriangleWareHouse wareHouse = TriangleWareHouse.getInstance();

        double currentPerimeter = service.calculatePerimeter(triangle);
        double currentSquare = service.calculateSquare(triangle);

        TriangleRecorder recorder = wareHouse.getData(triangle.getId());
        if (recorder == null) {
            recorder = new TriangleRecorder(currentPerimeter, currentSquare);
        } else {
            recorder.setPerimeter(currentPerimeter);
            recorder.setSquare(currentSquare);
        }
        wareHouse.add(triangle.getId(), recorder);
        logger.debug("Data was updated.");
    }
}
