package action;

import model.Array;

public class SumOfElements {

    public int sum (Array array) {
        int sum = 0;
        for (int i = 0; i < array.getMyArray().length; i++) {
            sum += array.getMyArray()[i];
        }
        return sum;
    }
}
