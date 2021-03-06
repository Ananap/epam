package com.panasenko.shape.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataValidator {
    final static Logger logger = LogManager.getLogger(DataValidator.class);
    private static final String REGEX_DATA = "[+-]?[0-9]+";

    private static List<String> validateData (List<String> parameterList) {
        List<String> validParameters = new ArrayList<>();
        for (String data : parameterList) {
            if (isTriangleData(data)) {
                validParameters.add(data);
            }
        }
        return validParameters;
    }

    private static boolean isTriangleData (String data) {
        boolean result = data.matches(REGEX_DATA);
        logger.debug("Data " + data + " was checked. Result - " + result);
        return result;
    }

}
