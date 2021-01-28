package action;

import exception.ArrayException;
import model.CustomArray;
import org.apache.log4j.Logger;

import java.util.stream.IntStream;

public class ArithmeticAction {
    final static Logger logger = Logger.getLogger(ArithmeticAction.class);

    public double averageStream(CustomArray customArray) throws ArrayException {
        if(customArray.getCustomArray() == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else {
            logger.info("Average value of custom array");
            return IntStream.of(customArray.getCustomArray())
                    .average()
                    .getAsDouble();
        }
    }

    public int sumStream(CustomArray customArray) throws ArrayException {
        if(customArray.getCustomArray() == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else {
            logger.info("Sum of custom array");
            return IntStream.of(customArray.getCustomArray())
                    .sum();
        }
    }

    public int searchMinStream(CustomArray customArray) throws ArrayException {
        if(customArray.getCustomArray() == null){
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else {
            logger.info("Min value of custom array");
            return IntStream.of(customArray.getCustomArray())
                    .min()
                    .getAsInt();
        }
    }

    public int searchMaxStream(CustomArray customArray) throws ArrayException {
        if(customArray.getCustomArray() == null){
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else {
            logger.info("Max value of custom array");
            return IntStream.of(customArray.getCustomArray())
                    .max()
                    .getAsInt();
        }
    }

    public double average (CustomArray customArray) throws ArrayException{
        if (customArray.getCustomArray() == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else {
            logger.info("Average value of custom array");
            return (double) sum(customArray) / customArray.getSize();
        }
    }

    public int sum (CustomArray customArray) throws ArrayException {
        if (customArray.getCustomArray() == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else{
            int sum = 0;
            for (int i = 0; i < customArray.getSize(); i++) {
                sum += customArray.get(i);
            }
            logger.info("Sum value of custom array");
            return sum;
        }
    }

    public int searchMin (CustomArray customArray) throws ArrayException {
        if (customArray.getCustomArray() == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else{
            int min = customArray.get(0);
            for (int i = 0; i < customArray.getSize(); i++) {
                if (customArray.get(i) < min) {
                    min = customArray.get(i);
                }
            }
            logger.info("Min value of custom array");
            return min;
        }
    }

    public int searchMax (CustomArray customArray) throws ArrayException {
        if (customArray.getCustomArray() == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else{
            int max = customArray.get(0);
            for (int i = 0; i < customArray.getSize(); i++) {
                if (customArray.get(i) > max) {
                    max = customArray.get(i);
                }
            }
            logger.info("Max value of custom array");
            return max;
        }
    }
}
