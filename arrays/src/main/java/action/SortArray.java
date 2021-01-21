package action;

import model.CustomArray;

public class SortArray {

     public CustomArray bubbleSort (CustomArray array) {
         int temp;
         boolean flag = false;
         while (!flag) {
             flag = true;
             for (int i = 0; i < array.getSize() - 1; i++) {
                 if (array.get(i) > array.get(i + 1)) {
                     temp = array.get(i);
                     array.getCustomArray()[i] = array.getCustomArray()[i + 1];
                     array.getCustomArray()[i + 1] = temp;
                     flag = false;
                 }
             }
         }
         return array;
     }

     public CustomArray choiceSort (CustomArray array) {
         for (int repeat = 0; repeat < array.getSize(); repeat++) {
             int temp   ;
             for (int elementCounter = repeat + 1; elementCounter < array.getSize(); elementCounter++) {
                 if (array.get(repeat) > array.get(elementCounter)) {
                     temp = array.getCustomArray()[repeat];
                     array.getCustomArray()[repeat] = array.getCustomArray()[elementCounter];
                     array.getCustomArray()[elementCounter] = temp;
                 }
             }
         }
         return array;
     }

     public CustomArray insertionSort (CustomArray array) {
         int temp, item;
         for (int i = 1; i < array.getSize(); i++) {
             temp = array.get(i);
             item = i - 1;
             while (item >= 0 && array.get(item) > temp) {
                 array.getCustomArray()[item + 1] = array.getCustomArray()[item];
                 array.getCustomArray()[item] = temp;
                 item--;
             }
         }
         return array;
     }
}
