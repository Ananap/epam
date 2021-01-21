package action;

import model.CustomArray;

import java.util.stream.IntStream;

public class AmountPositiveNegative {

    public int amountPositiveStream (CustomArray array) {
        return (int) IntStream.of(array.getCustomArray()).filter(value -> value > 0).count();
    }

    public int amountNegativeStream (CustomArray array) {
        return (int) IntStream.of(array.getCustomArray()).filter(value -> value < 0).count();
    }

    public int amountPositive (CustomArray array) {
        int positive = 0;
        for (int i = 0; i < array.getCustomArray().length; i++) {
            if (array.getCustomArray()[i] > 0) {
                positive++;
            }
        }
        return positive;
    }

    public int amountNegative (CustomArray array) {
        int negative = 0;
        for (int i = 0; i < array.getCustomArray().length; i++) {
            if (array.getCustomArray()[i] < 0) {
                negative++;
            }
        }
        return negative;
    }
}
