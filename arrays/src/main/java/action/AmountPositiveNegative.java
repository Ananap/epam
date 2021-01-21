package action;

import model.Array;

public class AmountPositiveNegative {

    public int amountPositive (Array array) {
        int positive = 0;
        for (int i = 0; i < array.getMyArray().length; i++) {
            if (array.getMyArray()[i] > 0) {
                positive++;
            }
        }
        return positive;
    }

    public int amountNegative (Array array) {
        int negative = 0;
        for (int i = 0; i < array.getMyArray().length; i++) {
            if (array.getMyArray()[i] < 0) {
                negative++;
            }
        }
        return negative;
    }
}
