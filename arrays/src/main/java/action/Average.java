package action;

import model.Array;

public class Average {
    private SumOfElements sum;

    public double getAverage (Array array) {
        return sum.sum(array) / array.getMyArray().length;
    }
}
