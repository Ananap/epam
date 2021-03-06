package com.panasenko.shape.reader;

import com.panasenko.shape.exception.ShapeException;
import com.panasenko.shape.service.impl.TriangleServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeReader {
    final static Logger logger = LogManager.getLogger(TriangleServiceImpl.class);

    public List<String> readFile(String filename) throws ShapeException {
        if (filename == null) {
            logger.error("Filename is null");
            throw new ShapeException("Filename is null");
        } else {
            ArrayList<String> parameterList = new ArrayList<>();
            try (FileReader reader = new FileReader(filename)) {
                parameterList = new ArrayList<>();
                Scanner sc = new Scanner(reader);
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    parameterList.add(str);
                }
            } catch (IOException ex) {
                logger.error("This is error: " + ex.getLocalizedMessage());
            }
            return parameterList;
        }
    }
}
