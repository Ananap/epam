package model;

import java.util.Random;

public class Array {
    private final int[] myArray;

    public Array(int size) {
        myArray = new int[size];
        Random r =  new Random();
        int max = 50;
        int min = -50;
        int diff = max - min;
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = r.nextInt(diff);
        }
    }

    public int[] getMyArray() {
        return myArray;
    }
}
