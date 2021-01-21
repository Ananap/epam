package action;

import model.Array;

public class SearchMinMax {

    public int searchMin (Array array) {
        int min = array.getMyArray()[0];
        for (int i = 0; i < array.getMyArray().length; i++) {
            if (array.getMyArray()[i] < min) {
                min = array.getMyArray()[i];
            }
        }
        return min;
    }

    public int searchMax (Array array) {
        int max = array.getMyArray()[0];
        for (int i = 0; i < array.getMyArray().length; i++) {
            if (array.getMyArray()[i] > max) {
                max = array.getMyArray()[i];
            }
        }
        return max;
    }
}
