package action;

import model.Array;

public class Sort {

     public Array bubbleSort (Array array) {
         int temp = 0;
         boolean flag = false;
         while (!flag) {
             flag = true;
             for (int i = 0; i < array.getMyArray().length - 1; i++) {
                 if (array.getMyArray()[i] > array.getMyArray()[i + 1]) {
                     temp = array.getMyArray()[i];
                     array.getMyArray()[i] = array.getMyArray()[i + 1];
                     array.getMyArray()[i + 1] = temp;
                     flag = false;
                 }
             }
         }
         return array;
     }

     public Array choiceSort (Array array) {
         for (int repeat = 0; repeat < array.getMyArray().length; repeat++) {
             int temp = array.getMyArray()[0];
             for (int elementCounter = repeat + 1; elementCounter < array.getMyArray().length; elementCounter++) {
                 if (array.getMyArray()[repeat] > array.getMyArray()[elementCounter]) {
                     temp = array.getMyArray()[repeat];
                     array.getMyArray()[repeat] = array.getMyArray()[elementCounter];
                     array.getMyArray()[elementCounter] = temp;
                 }
             }
         }
         return array;
     }

     public Array insertionSort (Array array) {
         int temp, item;
         for (int i = 1; i < array.getMyArray().length; i++) {
             temp = array.getMyArray()[i];
             item = i - 1;
             while (item >= 0 && array.getMyArray()[item] > temp) {
                 array.getMyArray()[item + 1] = array.getMyArray()[item];
                 array.getMyArray()[item] = temp;
                 item--;
             }
         }
         return array;
     }
}
